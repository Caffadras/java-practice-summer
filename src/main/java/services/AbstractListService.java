package services;

import model.Convertible;
import model.Nameable;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListService <T extends Convertible<T> & Nameable>{
    protected final List<T> list = new ArrayList<>();

    public synchronized List<T> findAll() {
        return list;
    }

    public synchronized T findByName(String name){
        return list.stream()
                .filter(object -> object.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public synchronized T save(T object) {
        list.add(object);
        return object;
    }

    public synchronized void delete(T object) {
        list.remove(object);
    }

    public synchronized void update(T objectToUpdate, T newObjectFields){
        objectToUpdate.convert(newObjectFields);
    }
}
