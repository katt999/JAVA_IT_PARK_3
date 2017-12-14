package dao;

import models.Human;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * Created by EVZabinskaya on 14.12.2017.
 */
public class HumansDaoJdbcImpl implements HumansDao {

    private Connection connection;

    public HumansDaoJdbcImpl(DataSource dataSource) {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Human> findAllByAge(int age) {
        return null;
    }

    @Override
    public void save(Human model) {

    }

    @Override
    public Human find(int id)  {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM owner WHERE id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Human human = null;
            while (resultSet.next()) {
                human = Human.builder()
                        .id(resultSet.getInt("id"))
                        .age(resultSet.getInt("age"))
                        .name(resultSet.getString("name"))
                        .height(resultSet.getString("height"))
                        .build();
            }
            if (human == null) {
                throw new IllegalArgumentException("User with id <\" + id + \"> not found");
            } else return human;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void update(Human model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Human> findAll() {
        return null;
    }
}
