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

        String quadraNome = req.getParameter("id do html");

        String dataLocIni = req.getParameter("id data inicio");

        String dataLocFim = req.getParameter("id data fim");

        String userUsuario = (String) req.getSession().getAttribute("usuarioLogado");

        int idLocavel = Integer.parseInt(req.getParameter("id quadra"));

        Locacao loc = new Locacao(quadraNome, dataLocIni, dataLocFim, userUsuario, idLocavel);

        new LocacaoDao().locacao(userUsuario, quadraNome, dataLocIni, dataLocFim, idLocavel);

        req.getRequestDispatcher("locacao.jsp").forward(req,resp); //HELP HERE

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("locacao.jsp").forward(req, resp);

//        resp.sendRedirect("index.jsp");

    }
}
