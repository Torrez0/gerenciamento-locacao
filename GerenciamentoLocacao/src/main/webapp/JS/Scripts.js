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
const controls = document.querySelectorAll('.control');
let currentItem = 0;
const items = document.querySelectorAll('.item');
const maxItems = items.length;
let timer;

//Evento para o clique
controls.forEach(control => {
    control.addEventListener('click', () => {
        const isLeft = control.classList.contains("arrow-left");
        console.log('control clicked', isLeft);

        if (isLeft) {
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
        updateCarousel();

        items[currentItem].classList.add("current-item");
    });
});

// Função do timer para ir ao próximo item
function nextItem() {
    currentItem = (currentItem + 1) % maxItems;
    updateCarousel();
}

//atualiza o carousel
function updateCarousel() {
    items.forEach(item => item.classList.remove('current-item'));

    items[currentItem].classList.add('current-item'); // função aplica o current-item do css a cada imagem em destaque

    items[currentItem].scrollIntoView({
        inline: "center",
        behavior: "smooth"
    });
}


// Função para iniciar o timer adicionando o tempo
function startAutoSlide() {
    timer = setInterval(nextItem, 3000);
}

// Função para parar o timer, ativada quando o mouse interage com o slide
function stopAutoSlide() {
    clearInterval(timer);
}

// Iniciar o tempo automaticamente
startAutoSlide();

// Adiciona um evento de foco para reiniciar o timer quando o mouse estiver fora do carousel
const carousel = document.querySelector('.carousel');
carousel.addEventListener('mouseenter', stopAutoSlide);
carousel.addEventListener('mouseleave', startAutoSlide);