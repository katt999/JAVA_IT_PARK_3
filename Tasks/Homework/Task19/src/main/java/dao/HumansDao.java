package dao;

/**
 * Created by EVZabinskaya on 05.12.2017.
 */
import models.Human;

import java.sql.SQLException;
import java.util.List;

public interface HumansDao extends CrudDao<Human> {
    List<Human> findAllByAge(int age);
   // Human find(int id) throws SQLException, ClassNotFoundException;
}
