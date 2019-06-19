package com.jeremias.server.dao;

/**
 * @author aluno
 */

import com.jeremias.server.model.Cadastro;
import com.jeremias.server.model.Usuario;

public interface DAO<T extends Cadastro> {
    T findById(long id);
    T findByField(String fieldName, Object value);
    boolean remove(T entity);
    long save(T entity);

    public boolean remove(long id);
}
