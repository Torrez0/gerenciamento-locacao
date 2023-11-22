package br.com.getquick.servlet;

import br.com.getquick.dao.LocacaoDao;
import br.com.getquick.model.Locacao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/alterLocacao")
public class UpdateLocacaoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idLocacao = req.getParameter("idLocacao");
        String quadraNome = req.getParameter("quadras");
        String dataLocIni = req.getParameter("calendario") + " " + req.getParameter("horario") + ":00";
        int horaFimFinal = Integer.parseInt(req.getParameter("horario").replace(":00", ""));
        String dataLocFim = req.getParameter("calendario") + " " + (horaFimFinal + 2) + ":00:00";

        Locacao locacao = new Locacao(idLocacao, quadraNome, dataLocIni, dataLocFim);
        new LocacaoDao().atualizarLocacao(locacao);

        resp.sendRedirect("/listar-locacao");
    }

}
