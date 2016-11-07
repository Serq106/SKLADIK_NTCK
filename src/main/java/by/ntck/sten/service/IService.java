package by.ntck.sten.service;

import java.util.List;

public interface IService<T> {
	public void add(T element);

	public void update(T element);

	public void remove(int id);

	public T getById(int id);

	public List<T> list();
}
