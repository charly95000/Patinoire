package org.eclipse.dao;

import java.util.List;

import org.eclipse.model.Personne;


public interface Dao <T> {
	int save(T obj);
	void remove(T obj);
	void update(T obj);
	Personne findById(int id);
	List<T> getAll();
}
