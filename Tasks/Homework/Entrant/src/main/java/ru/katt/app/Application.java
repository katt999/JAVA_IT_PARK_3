package ru.katt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// аннотация, которая говорит, что
// данный класс будет точкой входа в приложение
// а также содержит конфигурацию приложения
@SpringBootApplication
// аннотация, которая говорит Spring-у
// где искать компоненты для связывания (вспомнить @Autowired, @Component)
@ComponentScan(basePackages = "ru.katt")
// говорим, где лежат классы, которые будут
// объектом взаимодействия с бд
@EntityScan(basePackages = "ru.katt.models")
// говорим, что наши репозитории описаны в данном пакете
// Spring JPA сам сгенерирует для них реализацию
@EnableJpaRepositories(basePackages = "ru.katt.repositories")
// выключили безопасность чтобы было норм
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class Application {
  // просто запускаем наше приложение
  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
}
