package br.com.getquick.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/locacao")
public class CreateLocacaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String usuarioEmail = (String) req.getSession().getAttribute("usuarioLogado");

        String quadraNome = req.getParameter("id do html");

        String dataLoc = req.getParameter("id da data");

        String horarioLoc = req.getParameter("id do horario");


    }
}
