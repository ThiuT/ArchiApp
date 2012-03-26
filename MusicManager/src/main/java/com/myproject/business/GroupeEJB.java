package com.myproject.business;

import com.myproject.models.Groupe;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

@Stateless
public class GroupeEJB {

    // ======================================
    // =             Attributes             =
    // ======================================
    @PersistenceContext(unitName = "jsfExamplePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public List<Groupe> findAll() {
        Query query = em.createNamedQuery(Groupe.FIND_ALL);
        return query.getResultList();
    }
    
    public Groupe findByID(Long id) {
        Query query = em.createNamedQuery(Groupe.FIND_BY_ID).setParameter("i", id);
        try{
            return (Groupe)query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public Groupe create(Groupe c) {
        em.persist(c);
        return c;
    }

    public Groupe update(Groupe c) {
        return em.merge(c);
    }

    public void delete(List<Groupe> list) {
        for (Groupe c : list) {
            delete(c);
        }
    }

    public void delete(Groupe c) {
        em.remove(em.merge(c));
    }
}
