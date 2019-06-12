package com.jeremiasneres.config;

import com.jeremiasneres.dao.DAO;
import com.jeremiasneres.model.Cadastro;
import com.jeremiasneres.dao.JpaDAO;
import java.lang.reflect.ParameterizedType;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jeremias_Neres
 */
public class Producers {
       @Produces
    @PersistenceContext
    private EntityManager em;

    @Produces
    public <T extends Cadastro> DAO<T> getDao(InjectionPoint ip) {
        ParameterizedType t = (ParameterizedType) ip.getType();
        Class classe = (Class) t.getActualTypeArguments()[0];
        return new JpaDAO(em, classe);
    }
    
}
