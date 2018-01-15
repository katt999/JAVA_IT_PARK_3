package repository;

import models.ProgramForm;

import javax.persistence.EntityManager;
import java.util.List;

public class ProgramFormRepositoryEntityManagerImpl implements ProgramFormRepository {

    private EntityManager entityManager;

    public ProgramFormRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ProgramForm> findAll() {
        return entityManager
                .createQuery("from ProgramForm programForm order by programForm.id", ProgramForm.class)
                .getResultList();
    }

    @Override
    public void save(ProgramForm model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        ProgramForm programForm = entityManager.find(ProgramForm.class, id);
        if (programForm != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(programForm);
            entityManager.getTransaction().commit();
        }
    }
}
