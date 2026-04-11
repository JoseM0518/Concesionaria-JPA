package com.concesionaria.persistencia;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import com.concesionaria.logica.Automovil;

public class AutomovilJpaController implements Serializable {

    private final EntityManagerFactory emf;

    public AutomovilJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Automovil automovil) {
        validateAutomovil(automovil);
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            em.persist(automovil);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error creando el automovil", e);
        }
    }

    public void destroy(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID debe ser positivo");
        }
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            Automovil automovil = em.find(Automovil.class, id);
            if (automovil == null) {
                throw new EntityNotFoundException("Automovil con id " + id + " no existe");
            }
            em.remove(automovil);
            em.getTransaction().commit();
        }
    }

    public void edit(Automovil automovil) {
        validateAutomovil(automovil);
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            em.merge(automovil);
            em.getTransaction().commit();
        } catch (Exception ex) {

            if (findById(automovil.getId()) == null) {
                throw new EntityNotFoundException("Automovil con id " + automovil.getId() + " no existe");
            }
            throw new RuntimeException("Error editando automovil", ex);
        }
    }

    public List<Automovil> findAll() {
        try (EntityManager em = getEntityManager()) {
            CriteriaQuery<Automovil> cq = em.getCriteriaBuilder().createQuery(Automovil.class);
            Root<Automovil> root = cq.from(Automovil.class);
            cq.select(root);
            return em.createQuery(cq).getResultList();
        }
    }

    public Automovil findById(Long id) {
        if (id == null || id <= 0) {
            return null;
        }
        try (EntityManager em = getEntityManager()) {
            return em.find(Automovil.class, id);
        }
    }

    private void validateAutomovil(Automovil automovil) {
        if (automovil == null) {
            throw new IllegalArgumentException("Automovil no puede ser null");
        }
    }
}