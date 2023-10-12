<%--
  Created by IntelliJ IDEA.
  User: Eduardo N. Lacerda
  Date: 10/10/2023
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>$Title$</title>

     <form action = "/login" method = "post">

                <c:if test="${usuarioLogado == false}">
                    <span>${message}</span>
                </c:if>

                <h6>LOGIN</h6>

                <span>${requestedScope.message}</span}

                <label>E-mail: </label>
                <input type="email" name="login-email" id="login-email">
                <label>Senha: </label>
                <input type="password" name="login-senha" id="login-senha">
                <button type="button" class="botao" onclick="fecharLoginDialog()"><img src="../img/seta-voltar.png" style=" max-height:5vh;color: white;"></button>
                <button type="submit" class="botao">Entrar</button>


            </form>

  </head>
  <body>
  $END$
  </body>
</html>
