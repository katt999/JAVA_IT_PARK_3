package repository;

/**
 * Created by EVZabinskaya on 28.12.2017.
 */
import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
}
