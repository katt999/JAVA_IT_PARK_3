package dao;

/**
 * Created by EVZabinskaya on 07.12.2017.
 */
import models.Car;
import java.util.List;

public interface CarsDao extends CrudDao<Car> {
    List<Car> findAllByColor(String color);
    List<Car> findAllOwnerId(int ownerId);
}