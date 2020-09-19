package com.sergiomartinrubio.jpa.javaee8.repository;


import com.sergiomartinrubio.jpa.javaee8.model.Foo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class FooRepository {

    private static final Logger LOGGER = Logger.getLogger(FooRepository.class.getName());

    @PersistenceContext(unitName = "MyPersistenceUnit")
    private EntityManager entityManager;

    public List<Foo> findAll() {
        return entityManager.createNamedQuery("Foo.findAll", Foo.class)
                .getResultList();
    }

    public void save(Foo foo) {
        LOGGER.log(Level.INFO, "Saving Foo Entity...");
        entityManager.persist(foo);
        LOGGER.log(Level.INFO, "Foo Entity saved!");
    }

}
