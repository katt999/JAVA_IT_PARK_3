package dao;

import models.Car;
import models.Human;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static org.junit.Assert.*;

public class CarJdbcTemplateDaoImplTest {

    // объектная переменная, которая хранит объект тестирования
    private CarJdbcTemplateDaoImpl testedCarsDao;

    // метод, который вызывается перед каждым тест-методом
    @Before
    public void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("postgres");
        dataSource.setPassword("280710");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Zabinskaya_db");
        testedCarsDao = new CarJdbcTemplateDaoImpl(dataSource);
    }

    @Test
    public void findTest() throws Exception {
        Car expected = Car.builder()
                .id(1)
                .number("191")
                .model("Opel")
                .color("Grey")
                .build();

        Human owner = Human.builder()
                .id(4)
                .name("Екатерина")
                .age(18)
                .height("168")
                .build();
        expected.setOwner(owner);

        Car actual = testedCarsDao.find(1);

        Assert.assertEquals(expected, actual);
    }

    // тест не провален, если снегерировал исключение на
    // плохом id
    @Test(expected = IllegalArgumentException.class)
    public void findTestOnBadUserId() {
        testedCarsDao.find(44);
    }

}
