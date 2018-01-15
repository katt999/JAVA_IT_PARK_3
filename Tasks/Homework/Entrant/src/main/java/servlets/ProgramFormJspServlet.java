package servlets;

import models.ProgramForm;
import repository.ProgramFormRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by EVZabinskaya on 07.01.2018.
 */
public class ProgramFormJspServlet extends HttpServlet {

    private ProgramFormRepository programFormRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.programFormRepository = (ProgramFormRepository)config.getServletContext().getAttribute("programFormRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("programForms", programFormRepository.findAll());
        req.getRequestDispatcher("/jsp/program_form_with_tags.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");

        ProgramForm programForm = ProgramForm.builder()
                .title(title)

                .build();

        programFormRepository.save(programForm);
        resp.sendRedirect("/program_form_as_jsp");
    }

}
