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


@WebServlet ("/locacaoAdmin")
public class ListarLocacoesAdmin extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Locacao> locacoes = new LocacaoDao().listarLocacoesRelatorio();

        req.setAttribute("locacoes", locacoes);

        RequestDispatcher dispatcher = req.getRequestDispatcher("listaLocacoesAdm.jsp");
        dispatcher.forward(req, resp);
    }

}
