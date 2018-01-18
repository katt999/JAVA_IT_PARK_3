package repository;

import models.CompetitionType;

import javax.persistence.EntityManager;
import java.util.List;

public class CompetitionTypeRepositoryEntityManagerImpl implements CompetitionTypeRepository {

    private EntityManager entityManager;

    public CompetitionTypeRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CompetitionType> findAll() {
        return entityManager
                .createQuery("from CompetitionType competitionType order by competitionType.id", CompetitionType.class)
                .getResultList();
    }

    @Override
    public void save(CompetitionType model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        CompetitionType competitionType = entityManager.find(CompetitionType.class, id);
        if (competitionType != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(competitionType);
            entityManager.getTransaction().commit();
        }
    }
}
