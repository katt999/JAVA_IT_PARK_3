package ru.katt.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.katt.models.FormativeOrgunit;
import ru.katt.repository.FormativeOrgunitRepository;

/**
 * Created by EVZabinskaya on 28.12.2017.
 */
public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ru.katt/context.xml");

        FormativeOrgunitRepository repository = context.getBean(FormativeOrgunitRepository.class);

        //System.out.println(repository.findAll());

        FormativeOrgunit orgunit = FormativeOrgunit.builder()
                .fullTitle("Институт новых технологий")
                .shortTitle("ИНТ")

                .build();

        repository.save(orgunit);
    }
}