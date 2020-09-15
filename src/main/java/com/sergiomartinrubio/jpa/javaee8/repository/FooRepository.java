package com.sergiomartinrubio.jpa.javaee8.repository;


import com.sergiomartinrubio.jpa.javaee8.model.Foo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class FooRepository {

    @PersistenceContext(unitName = "DefaultPersistenceUnit")
    private EntityManager entityManager;

    public List<Foo> findAll() {
        return entityManager.createNamedQuery("Foo.findAll", Foo.class)
                .getResultList();
    }

    public void save(Foo foo) {
        entityManager.persist(foo);
    }

}
