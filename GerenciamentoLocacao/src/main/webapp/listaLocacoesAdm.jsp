<%--
  Created by IntelliJ IDEA.
  User: Luan V. Viana
  Date: 20/11/2023
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.usuarioLogado == 'admin@admin.com'}">


<html>
<head>
    <title>Listagem de Locações</title>
</head>
<body>



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
                <form action="/delete-locacaoAdmin" method="post">
                    <input type="hidden" name="idLocacao" value="${locacao.id}">
                    <button type="submit">Delete</button>
                </form>
                <button type="submit" id="loginBotao" onclick="abrirAlterarDialog()" >Alterar</button>
            </td>
            <dialog id="alterarDialog" class="caixaDialog">
                <form action = "/alterLocacaoAdmin" method = "post" >

                    <select name="quadras" id="quadras" class="inputTime">
                        <option>sintetico</option>
                        <option>areia</option>
                        <option>salao</option>
                        <option>fiodase</option>
                    </select>

                    <h4>Escolha a data</h4>
                    <input type="date" name="calendario" class="calendario" />
                    <input type="date" name="calendario" class="calendario" />

                    <h4>EHora</h4>
                    <select name="horario" id="horario" class="inputTime">
                        <option>10:00</option>
                        <option>12:00</option>
                        <option>14:00</option>
                        <option>16:00</option>
                        <option>18:00</option>
                        <option>20:00</option>
                    </select>

                    <form action="/alterLocacaoAdmin" method="post">
                        <input type="hidden" name="idLocacao" value="${locacao.id}">
                        <button type="submit" >Alterar</button>
                    </form>

                    <button type="button" class="botaoVoltar" onclick="fecharAlterarDialog()">🡨</button>
                    <button type="submit" class="botao">Confirma</button>
                </form>
            </dialog>
        </tr>
    </c:forEach>

</table>
<script src="JS/Scripts.js"></script>
</body>
</html>

</c:if>
