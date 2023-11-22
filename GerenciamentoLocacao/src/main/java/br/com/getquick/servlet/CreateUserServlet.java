package br.com.getquick.servlet;

import br.com.getquick.dao.UsuarioDao;
import br.com.getquick.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( { "/admin/create-user", "/create-user" })
public class CreateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String usuarioNome = httpServletRequest.getParameter("usuario-nome");
        String usuarioEmail = httpServletRequest.getParameter("usuario-email");
        String usuarioGenero = httpServletRequest.getParameter("usuario-genero");
        String usuarioCelular = httpServletRequest.getParameter("usuario-celular");
        String userName = httpServletRequest.getParameter("user-name");
        String passWord = httpServletRequest.getParameter("pass-word");

        Usuario usuario = new Usuario(usuarioNome, usuarioEmail, usuarioGenero,
                usuarioCelular, userName, passWord);

        new UsuarioDao().criarUsuario(usuario);

        httpServletRequest.setAttribute("message", "Cadastro realizado com sucesso!");
        httpServletRequest.getRequestDispatcher("index.jsp").forward(httpServletRequest,httpServletResponse);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("message", "Cadastro realizado com sucesso!");
        req.getRequestDispatcher("index.jsp").forward(req, resp);

//        resp.sendRedirect("index.jsp");

    }

}
