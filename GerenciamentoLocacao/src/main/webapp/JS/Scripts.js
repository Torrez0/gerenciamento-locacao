//Funcão para abrir a tela de login

function abrirLoginDialog(){

    var loginDialog = document.getElementById('loginDialog');

        loginDialog.showModal();

}

//Função para fechar tela login
function fecharLoginDialog(){

    var loginDialog = document.getElementById('loginDialog');

        loginDialog.close();

}

function abrirCadastroDialog(){

    var CadastroDialog = document.getElementById('CadastroDialog');

        CadastroDialog.showModal();

}

//Função para fechar tela login
function fecharCadastroDialog(){

    var CadastroDialog = document.getElementById('CadastroDialog');

        CadastroDialog.close();

}

//DARK MODE

const chk = document.getElementById('btn')

chk.addEventListener('change', () => {
  document.body.classList.toggle('dark')
})

// Carousel 

const controls = document.querySelectorAll('.control'); //seleciona todos os controles do html
let currentItem = 0; 
const items = document.querySelectorAll('.item'); // seleciona todos os itens, cada imagem
const maxItems = items.length; //para saber o tamanho dos itens que temos
let timer; //variável para o tempo de tela de cada imagem

//Evento para o clique
controls.forEach(control => {
    control.addEventListener('click', () => {
        const isLeft = control.classList.contains("arrow-left");
        console.log('control clicked', isLeft);

        if (isLeft) { //verifica as posições do array e acrescenta +1
            currentItem -= 1;
        } else {
            currentItem += 1;
        }

        if (currentItem >= maxItems) {
            currentItem = 0;
        }
        if (currentItem < 0) {
            currentItem = maxItems - 1;
        }

        items.forEach(item => item.classList.remove('current-item')); 
        //remove o item e volta ao inicio
        items[currentItem].scrollIntoView({
        inline: "center",
        behavior: "smooth"
    });

    items[currentItem].classList.add("current-item");
    
    })
});

//Função do timer para ir ao próximo item
function nextItem() {
    currentItem = (currentItem + 1) % maxItems; // adiciona o % maxItems, para que não ultrapasse a quantidade de itens do html
    updateCarousel(); // atualiza o Carousel
}
 
function updateCarousel() { //função que atualiza o carousel, removendo a classe item e adicionando em seguida ao tamanho atual
    items.forEach(item => item.classList.remove('current-item'));
    items[currentItem].classList.add("current-item");

    // Centraliza a próxima imagem do carousel
    items[currentItem].scrollIntoView({
        inline: "center",
        behavior: "smooth"
    });
}

// Função para iniciar o timer adicionando o tempo
function startAutoSlide() {
    timer = setInterval(nextItem, 3000); // Milisegundos - 3000ms = 3 seg
}

// Função para parar o timer, ativada quando o mouse interage com o slide
function stopAutoSlide() {
    clearInterval(timer);
}

// Iniciar o tempo automaticamente
startAutoSlide();

// Adiciona um evento de foco para reiniciar o timer quando o mouse estiver fora do carousel
const carousel = document.querySelector('.carousel');
carousel.addEventListener('mouseenter', stopAutoSlide);  // quando o cursor do mouse tem contato com o slide, chama a função para parar
carousel.addEventListener('mouseleave', startAutoSlide); // chama a função para iniciar o slide quando o mouse não tem mais contato
