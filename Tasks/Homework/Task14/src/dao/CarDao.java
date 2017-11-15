package dao;

/**
 * Created by EVZabinskaya on 12.11.2017.
 */
import models.Car;

import java.util.List;

public interface CarDao extends CrudDao<Car> {
    List<Car> findAllByColor(String color);
    List<Car> findAll();
    Car find(int id);
    void update(Car model);
    void delete(int id);
}
