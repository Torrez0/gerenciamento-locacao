<%--
  Created by IntelliJ IDEA.
  User: Eduardo N. Lacerda
  Date: 20/11/2023
  Time: 03:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/estiloListarLocacao.css" media="screen" />

</head>
<body>

    <header>
        <div class="header">
            <div class="logo-site">
                <div class="container">
                    <img class="logoQuick" src="./img/logoGetQuick.png">
                    <!-- Modo Dark -->
                </div>
                
            </div>
            <div class="botoes-locacao">
                <button class="button-inicio " onclick="window.location.href='./login.jsp';">Inicio</button>
            </div>
        </div>
          
            
        </div>
    </header>


<h1>Listagem de Locações</h1>

<table border="1">
    <tr>
        <th>Id da Locacao</th>
        <th>Nome do Locável</th>
        <th>Data de Início</th>
        <th>Data de Fim</th>
        <th>Usuário</th>
    </tr>

    <c:forEach var="locacao" items="${locacoes}">
        <tr>
            <td>${locacao.id}</td>
            <td>${locacao.nomeQuadra}</td>
            <td>${locacao.dataLocacaoIni}</td>
            <td>${locacao.dataLocacaoFim}</td>
            <td>${locacao.usuario}</td>
            <td>
                <form action="/delete-locacao" method="post">
                    <input type="hidden" name="idLocacao" value="${locacao.id}">
                    <button type="submit">Delete</button>
                </form>
                <form action="/alterLocacao" method="post">
                    <input type="hidden" name="idLocacao" value="${locacao.id}">
                    <button type="submit">Alterar</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

