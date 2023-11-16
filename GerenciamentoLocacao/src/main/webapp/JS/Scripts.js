
////LOGIN
//Funcão para abrir a tela de login

function abrirLoginDialog(){

    var loginDialog = document.getElementById('loginDialog');
    var overlay = document.getElementById('overlay');

        loginDialog.showModal();
        overlay.style.display = 'block';

}

//Função para fechar tela login
function fecharLoginDialog(){

    var loginDialog = document.getElementById('loginDialog');
    var overlay = document.getElementById('overlay');

        loginDialog.close();
        overlay.style.display = 'none';

}


/////CADASTRO
//Função para abrir tela Cadastro
function abrirCadastroDialog(){

    var CadastroDialog = document.getElementById('CadastroDialog');
    var overlay = document.getElementById('overlay');

        CadastroDialog.showModal();
        overlay.style.display = 'block';

}

//Função para fechar tela Cadastro
function fecharCadastroDialog(){

    var CadastroDialog = document.getElementById('CadastroDialog');
    var overlay = document.getElementById('overlay');

        CadastroDialog.close();
        overlay.style.display = 'none';

}

/////RESERVA
//Função para abrir tela Reserva
function abrirReserva(){

    var CadastroDialog = document.getElementById('reservaDialog');
    var overlay = document.getElementById('overlay');

        CadastroDialog.showModal();
        overlay.style.display = 'block';

}

//Função para fechar tela Reserva
function fecharReserva(){

    var CadastroDialog = document.getElementById('reservaDialog');
    var overlay = document.getElementById('overlay');

        CadastroDialog.close();
        overlay.style.display = 'none';

}



//DARK MODE

const chk = document.getElementById('btn')

chk.addEventListener('change', () => {
  document.body.classList.toggle('dark')

  const imagensClaras = document.querySelectorAll('.imagem-clara');
  const imagensEscuras = document.querySelectorAll('.imagem-escura');

  // Alternar entre as imagens quando o dark e ativado
  imagensClaras.forEach((imagemClara) => {
    imagemClara.classList.toggle('hidden');
  });

  imagensEscuras.forEach((imagemEscura) => {
    imagemEscura.classList.toggle('hidden');
  });

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







