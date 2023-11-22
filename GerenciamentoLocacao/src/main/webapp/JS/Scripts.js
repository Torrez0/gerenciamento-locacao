
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

////ALTERAR
//Funcão para abrir a tela de alterar

function abrirAlterarDialog(){

    var loginDialog = document.getElementById('alterarDialog');
    var overlay = document.getElementById('overlay');

        loginDialog.showModal();
        overlay.style.display = 'block';

}

//Função para fechar tela alterar
function fecharAlterarDialog(){

    var loginDialog = document.getElementById('alterarDialog');
    var overlay = document.getElementById('overlay');

        loginDialog.close();
        overlay.style.display = 'none';

}

/////ALERTA LOGIN
//Função para abrir ALERTA LOGIN
function abrirLoginAlerta(){

    var loginDialog = document.getElementById('loginDialogs');
    var overlay = document.getElementById('overlay');

        loginDialog.showModal();
        overlay.style.display = 'block';

}

//Função para fechar ALERTA LOGIN
function fecharAlertaLogin(){

    var CadastroDialog = document.getElementById('loginDialogs');
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



// fechar caixa alerta

function fecharCaixaAlerta() {
    document.getElementById('fecharCaixaAlerta').style.display = 'none';
}

function mouseOver() {
    document.querySelector('.hover-effect').style.transform = 'scale(1.2)';
  }

  function mouseOut() {
    document.querySelector('.hover-effect').style.transform = 'scale(1)';
  }


//---- teste

