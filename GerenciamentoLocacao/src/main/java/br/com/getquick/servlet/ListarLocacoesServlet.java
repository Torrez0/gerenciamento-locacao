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

@WebServlet("/listar-locacao")
public class ListarLocacoesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userUsuario = (String) req.getSession().getAttribute("usuarioLogado");

        List<Locacao> locacoes = new LocacaoDao().listarLocacoes(userUsuario);

        req.setAttribute("locacoes", locacoes);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/listarLocacoes.jsp");
        dispatcher.forward(req, resp);
    }
}
