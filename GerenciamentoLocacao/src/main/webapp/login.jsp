<!DOCTYPE html>
<html >
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <meta http-equiv="Content-Type" content="text/html" charset=UTF-8>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="CSS/estilo.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="CSS/carousel.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="CSS/mapa.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="CSS/sobre.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="CSS/site.css" media="screen" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body >

<!-- Caixa Dialog Login -->

<main class="login_form">
    <div id="overlay"></div>
    <dialog id="loginDialog" class="caixaDialog">
        <form action = "/login" method = "post" >
            <h6>LOGIN</h6>
            <label>E-mail: </label>
            <input type="email" name="login-email" id="login-email">
            <label>Senha: </label>
            <input type="password" name="login-senha" id="login-senha">
            <button type="button" class="botaoVoltar" onclick="fecharLoginDialog()">🡨</button>
            <button type="submit" class="botao">Entrar</button>


        </form>


    </dialog>

    <!-- Caixa Dialog Cadastro -->
    <div id="overlay"></div>
    <dialog id="CadastroDialog" class="caixaDialog">
        <form action="/create-user" method="post">

            <h5>CADASTRO</h5>
            <label>Nome: </label>
            <input type="text" name="usuario-nome" id="usuario-nome">

            <label>Email: </label>
            <input type="email" name="usuario-email" id="usuario-email">

            <label for="usuario-genero">Gênero: </label>
            <select name="usuario-genero" id="usuario-genero">
                <option value="masculino">Masculino</option>
                <option value="feminino">Feminino</option>
            </select>


            <label>Celular: </label>
            <input type="tel" name="usuario-celular" id="usuario-celular">

            <label>Usuario: </label>
            <input type="text" name="user-name" id="user-name">

            <label>Senha: </label>
            <input type="password" name="pass-word" id="pass-word">

            <button type="button" class="botaoVoltar" onclick="fecharCadastroDialog()">🡨</button>
            <button type="submit" class="botaoRegister">Register</button>


        </form>
    </dialog>




    <header>


        <div class="header">
            <div class="logo-site">
                <img class="logoQuick" src="./img/logoGetQuick.png">
            </div>

            <div class="botoes-nav">
                <button class="botaoLogin" id="loginBotao" onclick="window.location.href='listar-locacao';">Minhas Locações</button>

                <c:if test="${sessionScope.usuarioLogado != null}">
                    <button onclick="window.location.href='/logout';"class="botaoLogin">Logout</button>
                </c:if>

                <c:if test="${sessionScope.usuarioLogado == 'admin@admin.com'}">
                    <button onclick="window.location.href='/locacaoAdmin';"class="botaoLogin">Locacoes Admin</button>
                </c:if>

                <!-- <button class="botaoLogin" onclick="abrirCadastroDialog()" >Cadastro</button>-->
            </div>

        </div>


        <!-- Modo Dark -->

        <div class="container">

            <div>
                <input type="checkbox" class="checkbox" id="btn" />
                <label class="label" for="btn">
                    <i class="fas fa-moon"></i>
                    <i class="fas fa-sun"></i>
                    <div class="ball"></div>
                </label>
            </div>

       <!-- BUSCAR -->
       <div class="campo-busca">
               
        <h2 class="jogoRegras">Seu jogo, suas regras. <br>
            Reserve sua quadra esportiva conosco!</h2>
        
        <div>
            <button class="botaoBuscar" onclick="window.location.href='/locacao.jsp';">Locação</button>
        </div>
    </div>
        </div>

        <!-- Conheça nosso site -->

        <div class="container-site">

            <div class="sobre-site">
                Conheça nosso site
            </div>
            <div class="txtBloco">

                <div>
                    Get Quick desenvolvido por alunos do Senac. <br>

                </div>

                <div>
                    Sistema de cadastro e locação de equipamentos. <br>

                </div>
                <div>
                    +5 Quadras poliesportivas. <br>
                </div>

                <div>
                    Society<br>
                    Poliesportiva <br>
                    Tenis <br>
                    E mais
                </div>
            </div>



        </div>


        <!-- Sobre locação -->
        <div class="container-sobre">

            <div class="sobre-texto">Sobre Locação</div>

            <div class="imgBloco">
                <img class="imagem-clara" src="./img/24hrs.png" alt="24hrclaro">
                <img class="imagem-escura" src="./img/24hrsdark.png" alt="Imagem Escura">

                <img class="imagem-clara" src="./img/aluno.png" alt="alunoclaro">
                <img class="imagem-escura" src="./img/alunodark.png" alt="alunoclaro">

                <img class="imagem-clara" src="./img/quadras.png" alt="quadrasclaro">
                <img class="imagem-escura" src="./img/quadrasdark.png" alt="quadrasdark">

                <img class="imagem-clara" src="./img/colegas.png" alt="colegasclaro">
                <img class="imagem-escura" src="./img/colegasdark.png" alt="colegasdark">
            </div>

        </div>

        <!-- Carousel -->

        <div class="carrossel">
            <h2 class="titulo-quadras"> Locação de Quadras Esportivas - O Seu Espaço de Competição!</h2>
            <div class="img-quadras">

                <img class="testimg" src="./img/CarrosselAberto.png" onclick="window.location.href='./locacao.jsp';"/>
                <img class="testimg" src="./img/CarrosselCoberta.png" onclick="window.location.href='./locacao.jsp';"/>
                <!-- <button class="botaoLocacao">Clique Aqui</button>-->

            </div>
        </div>

        <!-- Mapa do SENAC (Saber aonde colocar) -->
        <!--<div class="mapa-senac">
            <iframe src="https://www.google.com/maps/d/embed?mid=1REeSYLXKotZmndQNu4CbqghnbqPMc74&ehbc=2E312F&noprof=1" width="640" height="480"></iframe>
        </div> -->



    </header>
</main>

<script src="JS/Scripts.js"></script>
<script src="https://kit.fontawesome.com/998c60ef77.js" crossorigin="anonymous"></script>
</body>


</html>
