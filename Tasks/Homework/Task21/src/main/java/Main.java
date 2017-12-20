/**
 * Created by EVZabinskaya on 18.12.2017.
 */
import dao.CompetitionDao;
import models.Competition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.activation.DataSource;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");

        System.out.println("Context loaded");

        CompetitionDao competitionDao = (CompetitionDao) context.getBean("competitionDao");
        System.out.println(competitionDao.find(6));
    }
}
