package ru.katt.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.katt.config.ApplicationContext;
import ru.katt.models.FormativeOrgunit;
import ru.katt.models.ProgramForm;
import ru.katt.repositories.FormativeOrgunitRepository;
import ru.katt.repositories.ProgramFormRepository;

import java.util.List;

/**
 * Created by EVZabinskaya on 20.01.2018.
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ApplicationContext.class);

        ProgramForm form = ProgramForm.builder()
                .title("Форма обучения")

                .build();

        ProgramFormRepository programFormRepository = context.getBean(ProgramFormRepository.class);
        //programFormRepository.save(form);
        List<ProgramForm> programForms = programFormRepository.findAll();
        for(ProgramForm programForm:programForms){
            System.out.println(programForm.getId()+" "+programForm.getTitle());
        }

        FormativeOrgunitRepository formativeOrgunitRepository = context.getBean(FormativeOrgunitRepository.class);
        //List<FormativeOrgunit> formativeOrgunits = formativeOrgunitRepository.findAll();
        List<FormativeOrgunit> formativeOrgunits = formativeOrgunitRepository.findByShortTitle("ИРЭТ");
        for(FormativeOrgunit formativeOrgunit:formativeOrgunits){
            System.out.println(formativeOrgunit.getId()+" "+formativeOrgunit.getShortTitle()+ " "+formativeOrgunit.getFullTitle());
        }
    }
}
