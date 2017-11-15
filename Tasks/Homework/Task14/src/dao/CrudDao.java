package dao;

/**
 * Created by EVZabinskaya on 12.11.2017.
 */
import java.util.List;

public interface CrudDao<T> {
    void save(T model);
    T find(int id);
    void update(T model);
    void delete(int id);

    List<T> findAll();
}
