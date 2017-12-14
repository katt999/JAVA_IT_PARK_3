package dao;

/**
 * Created by EVZabinskaya on 07.12.2017.
 */
import dao.CarsDao;
import models.Human;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import models.Car;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CarJdbcTemplateDaoImpl implements CarsDao {


    //language=SQL
    private static final String SQL_SELECT_CAR_BY_ID = "SELECT car.*,owner.id as owner_id, owner.* FROM car JOIN " +
            "owner ON car.owner_id=owner.id WHERE car.id = ?";

    private JdbcTemplate template;

    // мап, где ключ - id, значение - машина
    private Map<Integer, Car> carsMap;

    public CarJdbcTemplateDaoImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }


    private RowMapper<Car> carRowMapper = new RowMapper<Car>() {
        @Override
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            Car car = Car.builder()
                    .id(resultSet.getInt("id"))
                    .number(resultSet.getString("number"))
                    .model(resultSet.getString("model"))
                    .color(resultSet.getString("color"))
                    .build();

            Human owner = Human.builder()
                    .id(resultSet.getInt("owner_id"))
                    .name(resultSet.getString("name"))
                    .age(resultSet.getInt("age"))
                    .height(resultSet.getString("height"))
                    .build();
            car.setOwner(owner);

            return car;
        }
    };


    @Override
    public List<Car> findAllByColor(String color) {
        return null;
    }

    @Override
    public List<Car> findAllOwnerId(int ownerId) {
        return null;
    }

    @Override
    public void save(Car model) {

    }

    @Override
    public Car find(final int id) {
            // перехватываем исключение, если такого id нету
        try {
             return template.queryForObject(SQL_SELECT_CAR_BY_ID, carRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            // выбрасываем новое исключение с комментарием
            throw new IllegalArgumentException("User with id <" + id + "> not found");
        }
    }

    @Override
    public void update(Car model) {

    }

    @Override
    public void delete(int id) {

    }


    @Override
    public List<Car> findAll() {
        return null;
    }
}
