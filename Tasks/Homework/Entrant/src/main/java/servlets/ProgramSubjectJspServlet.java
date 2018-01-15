package servlets;

import models.ProgramSubject;
import repository.ProgramSubjectRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by EVZabinskaya on 07.01.2018.
 */
public class ProgramSubjectJspServlet extends HttpServlet {

    private ProgramSubjectRepository programSubjectRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.programSubjectRepository = (ProgramSubjectRepository)config.getServletContext().getAttribute("programSubjectRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("programSubject", programSubjectRepository.findAll());
        req.getRequestDispatcher("/jsp/program_subject_with_tags.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String code = req.getParameter("code");

        ProgramSubject programSubject = ProgramSubject.builder()
                .code(code)
                .title(title)

                .build();

        programSubjectRepository.save(programSubject);
        resp.sendRedirect("/program_subject_as_jsp");
    }

}
