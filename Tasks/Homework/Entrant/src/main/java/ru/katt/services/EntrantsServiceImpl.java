package ru.katt.services;

/**
 * Created by EVZabinskaya on 31.01.2018.
 */

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.katt.forms.EntrantsForm;
import ru.katt.models.*;
import ru.katt.repositories.*;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class EntrantsServiceImpl implements EntrantsService {

    @Autowired
    private EntrantsRepository entrantsRepository;

    @Autowired
    private FormativeOrgunitsRepository formativeOrgunitsRepository;

    @Autowired
    private ProgramFormsRepository programFormsRepository;

    @Autowired
    private LevelTypesRepository levelTypesRepository;

    @Autowired
    private CompensationTypesRepository compensationTypesRepository;

    @Autowired
    private ProgramSubjectsRepository programSubjectsRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public List<Entrant> getEntrants(String orderBy) {
        switch (orderBy) {
            case "id": return entrantsRepository.findByOrderById();
            default: return entrantsRepository.findAll();
        }
    }

    @Override
    public Entrant getEntrant(Long entrantId) {
        return entrantsRepository.findOne(entrantId);
    }

    @Override
    public Entrant findByIdAndEmail(Long entrantId,String email) {
        return entrantsRepository.findByIdAndEmail(entrantId,email);
    }

    @Override
    public List<Entrant> getListEntrantListWithParameters(long parameter1, long parameter2, long parameter3, long parameter4, long parameter5) {
        return entrantsRepository.findListEntrant(parameter1,parameter2,parameter3,parameter4,parameter5);
    }

    @Override
    public List<FormativeOrgunit> getFormativeOrgunits() {
        return formativeOrgunitsRepository.findAll();
    }

    @Override
    public List<ProgramForm> getProgramForms() {
        return programFormsRepository.findAll();
    }

    @Override
    public List<LevelType> getLevelTypes() {
        return levelTypesRepository.findAll();
    }

    @Override
    public List<CompensationType> getCompensationTypes() {
        return compensationTypesRepository.findAll();
    }

    @Override
    public List<ProgramSubject> getProgramSubjects() {
        return programSubjectsRepository.findAll();
    }

    @Override
    @SneakyThrows
    public void entrant(EntrantsForm form) {

      Entrant newEntrant = Entrant.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .middleName(form.getMiddleName())
                .citizenship(form.getCitizenship())
                .eduDocumentNumber(form.getEduDocumentNumber())
                .email(form.getEmail())
                .competitions(form.getCompetitions())
                .examEntrants(form.getExamEntrants())
                .build();

        entrantsRepository.save(newEntrant);

        String text = "Вам присвоен номер заявления - " +newEntrant.getId();

        MimeMessage message = javaMailSender.createMimeMessage();
        message.setContent(text, "text/html");
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setTo(newEntrant.getEmail());
        messageHelper.setSubject("Заявление абитуриента");
        messageHelper.setText(text, true);

        javaMailSender.send(message);
    }

    @Autowired
    private CompetitionsRepository competitionsRepository;

    @Override
    public List<Integer> findPosition(Long entrantId) {
        return competitionsRepository.findPosition(entrantId);
    }
}