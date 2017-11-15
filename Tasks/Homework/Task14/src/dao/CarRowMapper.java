package dao;

import models.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by EVZabinskaya on 15.11.2017.
 */
public class CarRowMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Car(resultSet.getInt("id"),
                resultSet.getString("number"),
                resultSet.getString("model"),
                resultSet.getString("color"),
                resultSet.getInt("owner_id"));
    }
}