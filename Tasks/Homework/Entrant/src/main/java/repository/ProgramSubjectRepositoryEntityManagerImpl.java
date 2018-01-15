package repository;

import models.ProgramSubject;

import javax.persistence.EntityManager;
import java.util.List;

public class ProgramSubjectRepositoryEntityManagerImpl implements ProgramSubjectRepository {

    private EntityManager entityManager;

    public ProgramSubjectRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<ProgramSubject> findAll() {
        return entityManager
                .createQuery("from ProgramSubject programSubject order by programSubject.id", ProgramSubject.class)
                .getResultList();
    }

    @Override
    public void save(ProgramSubject model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        ProgramSubject programSubject = entityManager.find(ProgramSubject.class, id);
        if (programSubject != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(programSubject);
            entityManager.getTransaction().commit();
        }
    }
}
