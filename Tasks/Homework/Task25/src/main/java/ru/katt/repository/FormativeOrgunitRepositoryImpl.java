package ru.katt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.katt.models.FormativeOrgunit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component (value="formativeOrgunitRepository")
public class FormativeOrgunitRepositoryImpl implements FormativeOrgunitRepository {

   private static final String SQL_SELECT_ALL_FORMATIVE_ORGUNIT =
            "SELECT * FROM formative_orgunit";

    @Autowired
    private JdbcTemplate template;

    @PersistenceContext
    private EntityManager entityManager;

   public List<FormativeOrgunit> findAll() {
       return template.query(SQL_SELECT_ALL_FORMATIVE_ORGUNIT, (row,rowNumber) -> FormativeOrgunit.builder()
               .id(row.getLong("id"))
               .fullTitle(row.getString("full_title"))
               .shortTitle(row.getString("short_title"))

               .build());
   }

    @Transactional
    @Override
    public void save(FormativeOrgunit model) {
        entityManager.persist(model);
    }
}
