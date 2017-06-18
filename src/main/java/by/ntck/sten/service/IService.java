package by.ntck.sten.service;

import java.util.List;

public interface IService<T> {
    void add(T element);

    void update(T element);

    void remove(int id);

    T getById(int id);

    List<T> list();
}
