package servlets;

import models.FormativeOrgunit;
import repository.FormativeOrgunitRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by EVZabinskaya on 07.01.2018.
 */
public class FormativeOrgunitJspServlet extends HttpServlet {

    private FormativeOrgunitRepository formativeOrgunitRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.formativeOrgunitRepository = (FormativeOrgunitRepository)config.getServletContext().getAttribute("formativeOrgunitRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("formativeOrgunits", formativeOrgunitRepository.findAll());
        req.getRequestDispatcher("/jsp/formative_orgunit_with_tags.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String shortTitle = req.getParameter("shortTitle");
        String fullTitle = req.getParameter("fullTitle");

        FormativeOrgunit formativeOrgunit = FormativeOrgunit.builder()
                .shortTitle(shortTitle)
                .fullTitle(fullTitle)

                .build();

        formativeOrgunitRepository.save(formativeOrgunit);
        resp.sendRedirect("/formative_orgunit_as_jsp");
    }
}
