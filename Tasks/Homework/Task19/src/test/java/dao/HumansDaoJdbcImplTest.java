package dao;

import models.Human;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static org.junit.Assert.*;

public class HumansDaoJdbcImplTest {

    private HumansDaoJdbcImpl testedHumansDao;

    // метод, который вызывается перед каждым тест-методом
    @Before
    public void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("postgres");
        dataSource.setPassword("280710");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Zabinskaya_db");
        testedHumansDao = new HumansDaoJdbcImpl (dataSource);
    }

    @Test
    public void findTest() throws Exception {
        Human expected = Human.builder()
                .id(2)
                .age(29)
                .name("Дмитрий")
                .height("180")
                .build();

        Human actual = testedHumansDao.find(2);

        Assert.assertEquals(expected, actual);
    }

    // тест не провален, если снегерировал исключение на
    // плохом id
    @Test(expected = IllegalArgumentException.class)
    public void findTestOnBadUserId() {
        testedHumansDao.find(44);
    }
}