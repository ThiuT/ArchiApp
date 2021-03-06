package com.myproject.business;

import com.myproject.models.Creneau;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

@Stateless
public class PlanningEJB {

    // ======================================
    // =             Attributes             =
    // ======================================
    @PersistenceContext(unitName = "jsfExamplePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public List<Creneau> findAll() {
        Query query = em.createNamedQuery(Creneau.FIND_ALL);
        return query.getResultList();
    }

    public Creneau find(int j, int h) {
        Query query = em.createNamedQuery(Creneau.FIND).setParameter("j", j).setParameter("h", h);
        try {
            return (Creneau) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Creneau create(Creneau c) {
        em.persist(c);
        return c;
    }

    public Creneau update(Creneau c) {
        return em.merge(c);
    }

    public void delete(List<Creneau> list) {
        for (Creneau c : list) {
            delete(c);
        }
    }

    public void delete(Creneau c) {
        em.remove(em.merge(c));
    }
}
