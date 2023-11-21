package br.com.getquick.servlet;

import br.com.getquick.dao.LocacaoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-locacao")
public class DeleteLocacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idLocacao = req.getParameter("idLocacao");

        new LocacaoDao().deleteLocacao(idLocacao);

        resp.sendRedirect("/listar-locacao");
    }
}
