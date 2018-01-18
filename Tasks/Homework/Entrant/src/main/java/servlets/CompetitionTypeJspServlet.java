package servlets;

import models.CompetitionType;
import repository.CompetitionTypeRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by EVZabinskaya on 07.01.2018.
 */
public class CompetitionTypeJspServlet extends HttpServlet {

    private CompetitionTypeRepository competitionTypeRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.competitionTypeRepository = (CompetitionTypeRepository)config.getServletContext().getAttribute("competitionTypeRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("competitionTypes", competitionTypeRepository.findAll());
        req.getRequestDispatcher("/jsp/competition_type_with_tags.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");

        CompetitionType competitionType = CompetitionType.builder()
                .title(title)

                .build();

        competitionTypeRepository.save(competitionType);
        resp.sendRedirect("/competition_type_as_jsp");
    }

}
