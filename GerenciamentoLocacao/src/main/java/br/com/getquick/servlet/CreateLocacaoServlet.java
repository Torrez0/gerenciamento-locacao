package br.com.getquick.servlet;

import br.com.getquick.model.Locacao;
import br.com.getquick.dao.LocacaoDao;

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

        String userUsuario = (String) req.getSession().getAttribute("usuarioLogado");

        String quadraNome = req.getParameter("id do html");

        String dataLocIni = req.getParameter("id data inicio");

        String dataLocFim = req.getParameter("id data fim");

        Locacao loc = new Locacao(userUsuario, quadraNome, dataLocIni, dataLocFim);

        new LocacaoDao().locacao(userUsuario, quadraNome, dataLocIni, dataLocFim);

        req.getRequestDispatcher("aqui entra o arquivo . jsp").forward(req,resp); //HELP HERE

    }
}
