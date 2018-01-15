package repository;

/**
 * Created by EVZabinskaya on 28.12.2017.
 */
import models.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UsersRepositoryEntityManagerImpl implements UsersRepository {

    private EntityManager entityManager;

    public UsersRepositoryEntityManagerImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        return entityManager
                .createQuery("from User user order by user.id", User.class)
                .getResultList();
    }
}
