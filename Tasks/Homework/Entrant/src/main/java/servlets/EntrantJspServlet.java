package servlets;

import models.Entrant;
import repository.EntrantRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EntrantJspServlet extends HttpServlet {

    private EntrantRepository entrantRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.entrantRepository = (EntrantRepository)config.getServletContext().getAttribute("entrantRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("hello", "Привет, Марсель!");

        req.setAttribute("entrants", entrantRepository.findAll());
        req.getRequestDispatcher("/jsp/entrant_with_tags.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String firstName = req.getParameter("firstName");
        String middleName = req.getParameter("middleName");
        String lastName = req.getParameter("lastName");
        String citizenship = req.getParameter("citizenship");
        int eduDocumentAverageMark = Integer.parseInt(req.getParameter("eduDocumentAverageMark"));
        int eduDocumentKindId = Integer.parseInt(req.getParameter("eduDocumentKindId"));
        String eduDocumentNumber = req.getParameter("eduDocumentNumber");

        Entrant entrant = Entrant.builder()
                .firstName(firstName)
                .middleName(middleName)
                .lastName(lastName)
                //.birthDate(birthDate)
                .citizenship(citizenship)
                .eduDocumentAverageMark(eduDocumentAverageMark)
                .eduDocumentKindId(eduDocumentKindId)
                .eduDocumentNumber(eduDocumentNumber)


                .build();

        entrantRepository.save(entrant);
        resp.sendRedirect("/entrant_as_jsp");
    }
}
