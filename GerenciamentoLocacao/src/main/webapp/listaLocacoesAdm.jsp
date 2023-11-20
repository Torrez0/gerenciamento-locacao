<%--
  Created by IntelliJ IDEA.
  User: Luan V. Viana
  Date: 20/11/2023
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                <form action="/delete-locacao" method="post">
                    <input type="hidden" name="id" value="${locacao.id}">
                    <button type="submit">Delete</button>
                </form>
                <form action="/alterLocacao" method="post">
                    <input type="hidden" name="id" value="${locacao.id}">
                    <button type="submit">Alterar</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

