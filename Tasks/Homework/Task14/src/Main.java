/**
 * Created by EVZabinskaya on 12.11.2017.
 */
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import dao.HumansDao;
import dao.CarDao;
import dao.jdbc.template.HumansJdbcTemplateDaoImpl;
import dao.jdbc.template.CarDaoJdbcTemplateImpl;
import models.Human;
import models.Car;
public class Main {



    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("postgres");
        dataSource.setPassword("280710");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Zabinskaya_db");

        HumansDao humansDao = new HumansJdbcTemplateDaoImpl(dataSource);
        CarDao carsDao = new CarDaoJdbcTemplateImpl(dataSource);
       // Human avraam = new Human("Авраам", 75, 168);

       // System.out.println(avraam);
       // humansDao.save(avraam);
       // System.out.println(avraam);
        Human avraam1 = new Human(15,"Авраам",70,167);
        humansDao.update(avraam1);
        System.out.println(avraam1);
       // humansDao.delete(15);
        System.out.println(humansDao.find(9));
        System.out.println(carsDao.find(1));
    }
}