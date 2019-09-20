package ch.heig.pl.presentation;

import ch.heig.pl.business.ContactService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "ControlFilter")
public class ControlFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        ContactService service = new ContactService();
        config.getServletContext().setAttribute("service",service);
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }



}
