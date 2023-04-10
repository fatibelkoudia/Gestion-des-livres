package com.tima.tp1.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {
	T findOne(final Long id);
	List<T> findAll();
	void create(final T entity);
	void update(final T entity);
	void delete(final Long id);
}
