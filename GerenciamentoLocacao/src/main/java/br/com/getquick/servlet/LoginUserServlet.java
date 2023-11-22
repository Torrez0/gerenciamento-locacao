package br.com.getquick.servlet;

import br.com.getquick.dao.UsuarioDao;
import br.com.getquick.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/login", "/admin/login"})
public class LoginUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("login-email");
        String senha = req.getParameter("login-senha");

        Usuario usuario = new Usuario(email, senha);

        boolean isUsuarioValido = new UsuarioDao().verificarCredenciais(usuario);

        if (isUsuarioValido) {

            req.getSession().setAttribute("usuarioLogado", usuario.getEmail());

            resp.sendRedirect("/login.jsp");

        } else {

            req.setAttribute("message", "Credenciais inválidas! Por favor, verifique o e-mail e a senha inseridos para prosseguir com o login.");
            req.setAttribute("usuarioLogado", false);

            req.getRequestDispatcher("index.jsp").forward(req, resp);

        }


    }
}
