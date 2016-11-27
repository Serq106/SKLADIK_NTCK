package by.ntck.sten.dao;

import java.util.List;

public interface IDAO<T> {
	public void add(T element);

	public void update(T element);

	public void remove(int id);

	public T getById(int id);

	public List<T> list();
}
