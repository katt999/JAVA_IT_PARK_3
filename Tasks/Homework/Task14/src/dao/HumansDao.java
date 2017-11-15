package dao;

/**
 * Created by EVZabinskaya on 12.11.2017.
 */
import models.Human;

import java.util.List;

public interface HumansDao extends CrudDao<Human> {
    List<Human> findAllByAge(int age);
    List<Human> findAll();
    Human find(int id);
    void update(Human model);
    void delete(int id);
}
