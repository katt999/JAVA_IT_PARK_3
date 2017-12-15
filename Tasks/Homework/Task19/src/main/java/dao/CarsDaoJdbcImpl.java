package dao;

import models.Car;
import models.Human;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * Created by EVZabinskaya on 14.12.2017.
 */
public class CarsDaoJdbcImpl  implements CarsDao {

    private Connection connection;

    public CarsDaoJdbcImpl(DataSource dataSource) {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

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
    public Car find(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT car.*,owner.id as owner_id, owner.* FROM car JOIN " +
                            "owner ON car.owner_id=owner.id WHERE car.id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Car car = null;
            while (resultSet.next()) {
                car = Car.builder()
                        .id(resultSet.getInt("id"))
                        .model(resultSet.getString("model"))
                        .number(resultSet.getString("number"))
                        .color(resultSet.getString("color"))
                        .build();

                Human owner = Human.builder()
                        .id(resultSet.getInt("owner_id"))
                        .name(resultSet.getString("name"))
                        .age(resultSet.getInt("age"))
                        .height(resultSet.getString("height"))
                        .build();
                car.setOwner(owner);
            }
            if (car == null) {
                throw new IllegalArgumentException("Car with id <\" + id + \"> not found");
            } else return car;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
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
