package by.ntck.sten.dao;

import java.util.List;

public interface IDAO<T> {
    void add(T element);

    void update(T element);

    void remove(int id);

    T getById(int id);

    List<T> list();
}
