package ru.vetalshev.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"*.jsp"},
        servletNames = {"DispatcherServlet"}
)
public class JspFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = servletRequest.getServletContext()
                .getRequestDispatcher("/index.jsp");
        dispatcher.forward(servletRequest, servletResponse);
        return;
//        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
