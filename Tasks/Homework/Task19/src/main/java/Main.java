import dao.CarsDao;
import dao.HumansDao;

/**
 * Created by EVZabinskaya on 11.12.2017.
 */
public class Main {
    public static void main(String[] args) {

        CarsDao carsDao = ComponentsFactory.carsDao();
        System.out.println(carsDao.find(2));

        HumansDao humansDao = ComponentsFactory.humansDao();
        System.out.println(humansDao.find(2));

    }
}
