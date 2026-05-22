package com.concesionaria.persistencia;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import com.concesionaria.logica.Marca;

public class MarcaJpaController implements Serializable {

    private final EntityManagerFactory emf;

    public MarcaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Marca marca) {
        validateMarca(marca);
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            em.persist(marca);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error creando la marca", e);
        }
    }

    public void destroy(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID debe ser positivo");
        }
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            Marca marca = em.find(Marca.class, id);
            if (marca == null) {
                throw new EntityNotFoundException("Marca con id " + id + " no existe");
            }
            em.remove(marca);
            em.getTransaction().commit();
        }
    }

    public void edit(Marca marca) {
        validateMarca(marca);
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            em.merge(marca);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findById(marca.getId()) == null) {
                throw new EntityNotFoundException("Marca con id " + marca.getId() + " no existe");
            }
            throw new RuntimeException("Error editando marca", ex);
        }
    }

    public List<Marca> findAll() {
        try (EntityManager em = getEntityManager()) {
            CriteriaQuery<Marca> cq = em.getCriteriaBuilder().createQuery(Marca.class);
            Root<Marca> root = cq.from(Marca.class);
            cq.select(root);
            return em.createQuery(cq).getResultList();
        }
    }

    public Marca findById(Integer id) {
        if (id == null || id <= 0) {
            return null;
        }
        try (EntityManager em = getEntityManager()) {
            return em.find(Marca.class, id);
        }
    }

    private void validateMarca(Marca marca) {
        if (marca == null) {
            throw new IllegalArgumentException("Marca no puede ser null");
        }
    }
}