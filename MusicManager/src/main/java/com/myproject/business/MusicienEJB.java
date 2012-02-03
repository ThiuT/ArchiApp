package com.myproject.business;

import com.myproject.models.Musicien;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

@Stateless
public class MusicienEJB {

    // ======================================
    // =             Attributes             =
    // ======================================
    @PersistenceContext(unitName = "jsfExamplePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public List<Musicien> findAll() {
        Query query = em.createNamedQuery(Musicien.FIND_ALL);
        return query.getResultList();
    }

    public Musicien create(Musicien c) {
        em.persist(c);
        return c;
    }

    public Musicien update(Musicien c) {
        return em.merge(c);
    }

    public void delete(List<Musicien> list) {
        for (Musicien c : list) {
            delete(c);
        }
    }

    public void delete(Musicien c) {
        em.remove(em.merge(c));
    }
}
