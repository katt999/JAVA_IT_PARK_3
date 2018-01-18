import repository.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("persistence");

        EntrantRepository entrantRepository = new EntrantRepositoryEntityManagerImpl(factory.createEntityManager());
        servletContextEvent.getServletContext().setAttribute("entrantRepository", entrantRepository);

        FormativeOrgunitRepository formativeOrgunitRepository = new FormativeOrgunitRepositoryEntityManagerImpl(factory.createEntityManager());
        servletContextEvent.getServletContext().setAttribute("formativeOrgunitRepository", formativeOrgunitRepository);

        ProgramFormRepository programFormRepository = new ProgramFormRepositoryEntityManagerImpl(factory.createEntityManager());
        servletContextEvent.getServletContext().setAttribute("programFormRepository", programFormRepository);

        ProgramSubjectRepository programSubjectRepository = new ProgramSubjectRepositoryEntityManagerImpl(factory.createEntityManager());
        servletContextEvent.getServletContext().setAttribute("programSubjectRepository", programSubjectRepository);

        CompetitionTypeRepository competitionTypeRepository = new CompetitionTypeRepositoryEntityManagerImpl(factory.createEntityManager());
        servletContextEvent.getServletContext().setAttribute("competitionTypeRepository", competitionTypeRepository);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
