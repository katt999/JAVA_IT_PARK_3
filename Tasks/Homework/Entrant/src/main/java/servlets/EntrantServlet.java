package servlets;

import models.Entrant;
import repository.EntrantRepository;
import repository.EntrantRepositoryEntityManagerImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class EntrantServlet extends HttpServlet {

  private EntrantRepository entrantRepository;

  @Override
  public void init() throws ServletException {
    EntityManagerFactory factory =
        Persistence.createEntityManagerFactory("persistence");

    this.entrantRepository = new EntrantRepositoryEntityManagerImpl(factory.createEntityManager());
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html");
    PrintWriter writer = resp.getWriter();
    writer.write("<h1>Hello!</h1>");
    writer.write("<table>");
    writer.write("<tr>");
    writer.write("<th>ID</th>");
    writer.write("<th>Имя</th>");
    writer.write("<th>Гражданство</th>");
    writer.write("</tr>");

    List<Entrant> entrants = entrantRepository.findAll();
    for (Entrant entrant : entrants) {
      writer.write("<tr>");
      writer.write("<td>" + entrant.getId() + "</td>");
      writer.write("<td>" + entrant.getFirstName() + " " + entrant.getMiddleName() + " " + entrant.getLastName() +"</td>");
      writer.write("<td>" + entrant.getCitizenship() + "</td>");
      writer.write("</tr>");
    }
    writer.write("</table>");
  }
}
