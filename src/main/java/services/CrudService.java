package services;

import java.util.List;

public interface CrudService<T> {
    List<T> findAll();

    T findByName(String name);

    T save(T object);

    void update(T objectToUpdate, T newObjectFields);
    void delete(T object);
}
