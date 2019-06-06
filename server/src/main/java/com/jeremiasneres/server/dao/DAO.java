package com.jeremiasneres.server.dao;

import com.jeremiasneres.server.model.Cadastro;

/**
 *
 * @author aluno
 */
public interface DAO<T extends Cadastro> {

    T findById(long id);

    T findByField(String fieldName, Object value);

    boolean remove(T entity);

    void save(T entity);
}
