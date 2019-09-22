package ch.heig.pl.presentation;

import ch.heig.pl.business.ContactService;
import ch.heig.pl.model.Contact;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ajoute")
public class Ajoute extends HttpServlet {

    private ContactService service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        service = (ContactService) getServletContext().getAttribute("service");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/ajoute.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String telephone = request.getParameter("telephone");
        int tel = 0;

        List<String> errors = new ArrayList<>();
        if (nom == null || nom.trim().equals("")) {
            errors.add("Le nom doit être renseigné");
        }
        if (telephone == null || telephone.trim().equals("")) {
            errors.add("Le téléphone doit être renseigné");
        } else {
            try {
                tel = Integer.parseInt(telephone);

            } catch (NumberFormatException e ){
                errors.add("Le téléphone doit être numérique");
            }
        }

        request.setAttribute("nom", nom);
        request.setAttribute("telephone", telephone);

        if (errors.size() == 0) {
            int number = service.add(new Contact(nom,tel));
            request.getSession().setAttribute("number",number-1);
            // dans jsp, récupérer number
            // foreach debut -> number-1 : normal
            //  number : en gras
            // foreach number+1 -> end : normal
            //  https://jakarta.ee/specifications/tags/1.2/tagdocs/
            response.sendRedirect(request.getContextPath() + "/liste");
        } else {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/WEB-INF/pages/ajoute.jsp").forward(request, response);
        }

    }

}
