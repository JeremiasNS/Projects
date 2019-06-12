package com.jeremiasneres.dao;

import com.jeremiasneres.model.Cadastro;

/**
 *
 * @author Jeremias_Neres
 */
public interface DAO<T extends Cadastro> {

    T findById(Long id);

    void save(T entity);
    
    boolean remove (Long id);

}
