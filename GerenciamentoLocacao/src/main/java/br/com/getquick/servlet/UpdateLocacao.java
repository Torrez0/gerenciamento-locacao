package br.com.getquick.servlet;

import br.com.getquick.dao.LocacaoDao;
import br.com.getquick.model.Locacao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/alterLocacao")
public class UpdateLocacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idLocacao = Integer.parseInt(req.getParameter("id"));

        new LocacaoDao().updateLocacao(idLocacao);

        resp.sendRedirect("/locacaoAdmin");
    }

}
