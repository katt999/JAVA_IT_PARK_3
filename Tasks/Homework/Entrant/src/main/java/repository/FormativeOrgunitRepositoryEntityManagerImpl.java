package repository;

import models.FormativeOrgunit;

import javax.persistence.EntityManager;
import java.util.List;

public class FormativeOrgunitRepositoryEntityManagerImpl implements FormativeOrgunitRepository {

    private EntityManager entityManager;

    public FormativeOrgunitRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<FormativeOrgunit> findAll() {
        return entityManager
                .createQuery("from FormativeOrgunit formativeOrgunit order by formativeOrgunit.id", FormativeOrgunit.class)
                .getResultList();
    }

    @Override
    public void save(FormativeOrgunit model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {

    }
}
