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

        String quadraNome = req.getParameter("quadras");

        String dataLocIni = req.getParameter("calendario") + " " + req.getParameter("horario") + ":00";

        int horaFimFinal = Integer.parseInt(req.getParameter("horario").replace(":00",""));

        String dataLocFim = req.getParameter("calendario") + " " + (horaFimFinal + 2) + ":00";

        String userUsuario = (String) req.getSession().getAttribute("usuarioLogado");

        String idLocavel = req.getParameter("1");

        Locacao locacao = new Locacao(quadraNome, dataLocIni, dataLocFim, userUsuario, idLocavel);

        new LocacaoDao().fazerLocacao(locacao);

        req.getRequestDispatcher("locacao.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("locacao.jsp").forward(req, resp);

//        resp.sendRedirect("index.jsp");

    }
}
