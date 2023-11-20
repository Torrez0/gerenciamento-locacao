<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="CSS/estiloLocacao.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="CSS/teste.css" media="screen" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body>

    <!-- Caixa Dialog Reserva -->
    <div id="overlay"></div>

    <dialog id="reservaDialog" class="caixaDialogReserva">
        <form action="/reserva" method="post">
            <h6 class="H6" id="sintetica">Quadra Sentética</h6>

            <h4>Escolha a data</h4>
            <input type="date" value="date" class="calendario" />

            <div class="reservaHorario">
                
                <h3 class="h3">Escolha a Horario: </h3>
                
            <select name="horario-sintetica" id="horario-sintetica" class="inputTime">
                <option value="10">10:00</option>
                <option value="12">12:00</option>
                <option value="14">14:00</option>
                <option value="16">16:00</option>
                <option value="18">18:00</option>
                <option value="20">20:00</option>
            </select>

            </div>
              
            <h5 class="h5">locação tem uma duração de 2 horas </h5>

            <button type="button" class="botaoVoltar" onclick="fecharReserva()">🡨</button>
            <button type="submit" class="botao">Confirmar</button>
        </form>
    </dialog>



    <header>
        <div class="header">
            <div class="logo-site">
                <div class="container">
                    <img class="logoQuick" src="./img/logoGetQuick.png">
                    <!-- Modo Dark -->
                </div>
               
            </div>
            <div class="botoes-locacao">
                
                    <button class="botaolocacao"  id="loginBotao" onclick="abrirLocacao()">Minhas Locações</button>
                <div class="botaoDark">
                <input type="checkbox" class="checkbox" id="btn" />
                <label class="label" for="btn">
                    <i class="fas fa-moon"></i>
                    <i class="fas fa-sun"></i>
                    <div class="ball"></div>
                </label>
            </div>
        </div>
          
            
        </div>
    </header>

    

    <!--IMAGEM QUADRA Sintetica (1)-->
    <main>
        <div class="main-locacao">
            <div class="img-locacao">
                <h1>Quadra Sintética</h1>
                <img src="./img/QuadraSociety.png">
                <h2>Incluir</h2>
                <div class="horarios">
                    <h3>Coletes 16x <br>Bola 2x</h3>
                    <h3>Segunda a Sabado <br>08h às 22h</h3>
                    <h3>Av.Eng. Eusébio <br>Stevaux, 823</h3>
                    <div class="botao-pai">
                        <button class="botaoReserve" onclick="abrirReserva()">Reservar</button>
                    </div>
                </div>
            </div>
        </div>

        <!--IMAGEM QUADRA Basquete (2)-->
        <div class="main-locacao">
            <div class="img-locacao">
                <h1>Quadra Volei/Basquete</h1>
                <img src="./img/QuadraBasquete.png">
                <h2>Incluir</h2>
                <div class="horarios" >
                    <h3>Coletes 16x <br>Bola 2x</h3>
                    <h3>Segunda a Sabado <br>08h às 22h</h3>
                    <h3>Av.Eng. Eusébio <br>Stevaux, 823</h3>
                    <div class="botao-pai">
                        <button class="botaoReserve" onclick="window.location.href='./reserva.html';">Reservar</button>
                    </div>
                </div>
            </div>
        </div>

        <!--IMAGEM QUADRA COBERTA (3)-->
        <div class="main-locacao">
            <div class="img-locacao">
                <h1>Quadra Futsal</h1>
                <img src="./img/QuadraCoberta.png">
                <h2>Incluir</h2>
                <div class="horarios">
                    <h3>Coletes 16x <br>Bola 2x</h3>
                    <h3>Segunda a Sabado <br>08h às 22h</h3>
                    <h3>Av.Eng. Eusébio <br>Stevaux, 823</h3>
                    <div class="botao-pai">
                        <button class="botaoReserve" onclick="window.location.href='./reserva.html';">Reservar</button>
                    </div>
                </div>
            </div>
        </div>

        <!--IMAGEM QUADRA Tênis (4)-->
        <div class="main-locacao">
            <div class="img-locacao">
                <h1>Quadra Tênis</h1>
                <img src="./img/QuadraTenis.png">
                <h2>Incluir</h2>
                <div class="horarios">
                    <h3>Coletes 16x <br>Bola 2x</h3>
                    <h3>Segunda a Sabado <br>08h às 22h</h3>
                    <h3>Av.Eng. Eusébio <br>Stevaux, 823</h3>
                    <div class="botao-pai">
                        <button class="botaoReserve" onclick="window.location.href='./reservas/reserva.html';">Reservar</button>
                    </div>
                </div>
            </div>
        </div>

        <!--IMAGEM QUADRA Visão geral(5)-->
        <div class="main-locacao">
            <div class="img-locacao">
                <h1>Quadra VisaoGeral</h1>
                <img src="./img/QuadraVisaoGeral.png">
                <h2>Incluir</h2>
                <div class="horarios">
                    <h3>Coletes 16x <br>Bola 2x</h3>
                    <h3>Segunda a Sabado <br>08h às 22h</h3>
                    <h3>Av.Eng. Eusébio <br>Stevaux, 823</h3>
                    <div class="botao-pai">
                        <button class="botaoReserve" onclick="window.location.href='./reserva.html';">Reservar</button>
                    </div>
                </div>
            </div>
        </div>

        <!--IMAGEM QUADRA Tênis (6)-->
        <div class="main-locacao">
            <div class="img-locacao">
                <h1>Quadra Sintética</h1>
                <img src="./img/QuadraSociety.png">
                <h2>Incluir</h2>
                <div class="horarios">
                    <h3>Coletes 16x <br>Bola 2x</h3>
                    <h3>Segunda a Sabado <br>08h às 22h</h3>
                    <h3>Av.Eng. Eusébio <br>Stevaux, 823</h3>
                    <div class="botao-pai">
                        <button class="botaoReserve" onclick="window.location.href='./reserva.html';">Reservar</button>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <script src="JS/Scripts.js"></script>
    <script src="JS/Scriptscalendario.js"></script>
    <script src="https://kit.fontawesome.com/998c60ef77.js" crossorigin="anonymous"></script>
</body>
</html>