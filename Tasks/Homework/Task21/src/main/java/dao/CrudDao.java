package dao;

/**
 * Created by EVZabinskaya on 16.12.2017.
 */
public interface CrudDao<T> {
    void insert(T model);
    T find(int id);
    void update(T model);
    void delete(int id);
}
