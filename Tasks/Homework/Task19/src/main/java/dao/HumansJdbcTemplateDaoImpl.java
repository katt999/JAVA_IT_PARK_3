package dao;

/**
 * Created by EVZabinskaya on 05.12.2017.
 */
import dao.HumansDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import models.Human;
import models.Car;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Реализция HumansDao с помощью JdbcTemplate
 */
public class HumansJdbcTemplateDaoImpl implements HumansDao {

    //language=SQL
    private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM owner " +
            "WHERE owner.id = ?";


    // Пришел из библиотеки spring-jdbc
    // содержит в себе шаблонные методы для работы с данными
    // update, query, queryForObject
    private JdbcTemplate template;

    // мап, где ключ - id, значение - человек
    private Map<Integer, Human> humansMap;

    public HumansJdbcTemplateDaoImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        humansMap = new HashMap<>();
    }

    // один из вариантов RowMapper, который описывает
    // отображение строки из бд в java-объект
    private RowMapper<Human> humanRowMapper = (resultSet, i) -> Human.builder()
            .id(resultSet.getInt("id"))
            .age(resultSet.getInt("age"))
            .name(resultSet.getString("name"))
            .height(resultSet.getString("height"))
            .build();

    // вариант с машинами
    private RowMapper<Human> humanRowMapperWithCars = new RowMapper<Human>() {
        @Override
        public Human mapRow(ResultSet resultSet, int i) throws SQLException {
            // отображаю строку в человека
            Human human = humanRowMapper.mapRow(resultSet, i);
            human.setCars(new ArrayList<>());
            // сейчас я нахожусь на какой-либо строке
            // результирующего множества строк

            // тут я в двух ситуациях - либо этот человек
            // мне встречался, либо нет

            // у меня есть мап ID(ключ)-Человек(значение)
            //
            if (humansMap.get(human.getId()) == null) {
                humansMap.put(human.getId(), human);
            }

            // в результирующем множестве все колонки
            // для машины начиются с номера 5

            // если у данного пользователя есть машина
            if (resultSet.getInt(5) != 0) {
                // отображем строку в машину
                Car car = new Car(
                        resultSet.getInt(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        humansMap.get(resultSet.getInt(9)));
                // вытаскиваем id хозяина данной машины
                int ownerId = resultSet.getInt(9);
                // берем хозяина по его id
                Human owner = humansMap.get(ownerId);
                // беру список его машин и кидаю туда новую машину
                owner.getCars().add(car);
            }
            return human;
        }
    };


    @Override
    public List<Human> findAllByAge(int age) {
        return null;
    }

    @Override
    public void save(Human model) {

    }

    @Override
    public Human find(int id) {
        // перехватываем исключение, если такого id нету
        try {
            return template.queryForObject(SQL_SELECT_USER_BY_ID, humanRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            // выбрасываем новое исключение с комментарием
            throw new IllegalArgumentException("User with id <" + id + "> not found");
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
