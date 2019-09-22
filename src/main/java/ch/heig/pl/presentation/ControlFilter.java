package ch.heig.pl.presentation;

import ch.heig.pl.business.ContactService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "ControlFilter", urlPatterns = "/*")
public class ControlFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        ContactService service = new ContactService();
        config.getServletContext().setAttribute("service",service);
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        Integer icount = (Integer) request.getSession().getAttribute("count");
        int count = 1;
        if (icount != null) {
            count = icount.intValue();
            count++;
        }
        request.getSession().setAttribute("count",count);

        if (count > 10 ) {
            req.getRequestDispatcher("/WEB-INF/pages/limit.html").forward(request, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }



}
