package com.sergiomartinrubio.jpa.javaee8.repository;


import com.sergiomartinrubio.jpa.javaee8.model.Foo;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class FooRepository {

    private static final Logger LOGGER = Logger.getLogger(FooRepository.class.getName());

//    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DefaultPersistenceUnit");
//
//    public static EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }

    @PersistenceContext(unitName = "DefaultPersistenceUnit")
    private EntityManager entityManager;

    public List<Foo> findAll() {
        return entityManager.createNamedQuery("Foo.findAll", Foo.class)
                .getResultList();
    }

    public void save(Foo foo) {
        LOGGER.log(Level.INFO, "Saving Foo Entity...");
//        EntityManager entityManager = getEntityManager();
//        entityManager.getTransaction().begin();
        entityManager.persist(foo);
//        entityManager.getTransaction().commit();
        LOGGER.log(Level.INFO, "Foo Entity saved!");
    }

}
