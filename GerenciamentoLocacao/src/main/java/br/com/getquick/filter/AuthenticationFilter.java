package br.com.getquick.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter({ "/admin/*" })
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if(isUsuarioLogado(httpServletRequest)){

            filterChain.doFilter(servletRequest, servletResponse);

        }else{

            servletRequest.setAttribute("message", "Usuario nao autenticado");
            servletRequest.setAttribute("usuarioLogado", false);

            servletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest,servletResponse);

        }

    }

    @Override
    public void destroy() {}

    private boolean isUsuarioLogado(HttpServletRequest httpServletRequest){

        return httpServletRequest.getSession().getAttribute("usuarioLogado") != null;

    }
}
