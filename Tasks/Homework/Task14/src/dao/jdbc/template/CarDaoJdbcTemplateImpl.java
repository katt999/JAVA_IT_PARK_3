package dao.jdbc.template;

/**
 * Created by EVZabinskaya on 12.11.2017.
 */

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import dao.CarDao;
import models.Car;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CarDaoJdbcTemplateImpl implements CarDao {

    //language=SQL
    private static final String SQL_INSERT_USER = "INSERT INTO car(number, model, color,owner_id)" +
            "VALUES (?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_CAR_BY_ID = "SELECT * FROM car WHERE " +
            "id = ?";

    //language=SQL
    private static final String SQL_SELECT_CAR_BY_COLOR = "SELECT * FROM car WHERE " +
            "color = ?";

    //language=SQL
    private static final String SQL_SELECT_CARS = "SELECT * FROM car";


    //language=SQL
    private static final String SQL_UPDATE_CARS = "UPDATE car SET number = ?, model = ?, color = ?  WHERE " +
            "id = ?";

    //language=SQL
    private static final String SQL_DELETE_CARS_BY_ID = "DELETE FROM car WHERE " +
            "id = ?";

    private JdbcTemplate template;

    public CarDaoJdbcTemplateImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }


    private RowMapper<Car> carRowMapper = new RowMapper<Car>() {
        @Override
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Car(resultSet.getInt("id"),
                    resultSet.getString("number"),
                    resultSet.getString("model"),
                    resultSet.getString("color"),
                    resultSet.getInt("owner_id"));
        }
    };


    @Override
    public List<Car> findAllByColor(String color) {
        return template.query(SQL_SELECT_CAR_BY_COLOR, carRowMapper, color);
    }

    @Override
    public void save(final Car model) {
        // задача, сохранить model в базу данных
        // и проставить ей сгенерированный бд id-шник

        // создаем объект, который умеет хранить в себе
        // сгенерированные ключи из бд
        KeyHolder keyHolder = new GeneratedKeyHolder();
        // посылаем запрос на создание пользователя
        template.update(
                // передаем PreparedStatement и KeyHolder
                new PreparedStatementCreator() {
                    // передаете ему connection к БД
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(SQL_INSERT_USER, new String[] {"id"});
                        ps.setString(1, model.getNumber());
                        ps.setString(2, model.getModel());
                        ps.setString(3, model.getColor());
                        ps.setInt(4, model.getOwnerId());
                        return ps;
                    }
                }, keyHolder);
        model.setId(keyHolder.getKey().intValue());
    }

    @Override
    public Car find(final int id) {
        return template.queryForObject(SQL_SELECT_CAR_BY_ID, carRowMapper, id);
    }

    @Override
    public void update(final Car model) {
        template.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(SQL_UPDATE_CARS);
                        ps.setString(1, model.getNumber());
                        ps.setString(2, model.getModel());
                        ps.setString(3, model.getColor());
                        ps.setInt(4, model.getId());
                        return ps;
                    }
                });
    }

    @Override
    public void delete(final int id) {
        template.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(SQL_DELETE_CARS_BY_ID);
                        ps.setInt(1, id);
                        return ps;
                    }
                });
    }

    @Override
    public List<Car> findAll()  {
        return template.query(SQL_SELECT_CARS, carRowMapper);
    }
}
