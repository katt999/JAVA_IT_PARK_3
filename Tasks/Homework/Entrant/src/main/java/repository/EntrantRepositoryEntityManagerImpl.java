package repository;

import models.Entrant;

import javax.persistence.EntityManager;
import java.util.List;

public class EntrantRepositoryEntityManagerImpl implements EntrantRepository {

    private EntityManager entityManager;

    public EntrantRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Entrant> findAll() {
        return entityManager
                .createQuery("from Entrant entrant order by entrant.id", Entrant.class)
                .getResultList();
    }

    @Override
    public void save(Entrant model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {

    }
}
