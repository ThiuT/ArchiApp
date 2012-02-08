/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = Musicien.FIND_ALL, query = "SELECT m FROM Musicien m"),
    @NamedQuery(name = Musicien.FIND_BY_ID, query = "SELECT m FROM Musicien m WHERE m.id=:i")
})
public class Musicien implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public final static String FIND_ALL = "Musicien.findAll";
    public final static String Del_SOM = "Musicien.delete";
    public final static String FIND_BY_ID = "Musicien.findByID";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String instrument;
    @ManyToMany(mappedBy = "membres")
    private List<Groupe> groupes;
    @Transient
    private Boolean selected;
    
    // ======================================
    // =            Constructors            =
    // ======================================
    
    public Musicien() {
        
    }
    
    public Musicien(String n, String p, String i) {
        this.nom = n;
        this.prenom = p;
        this.instrument = i;
    }
    
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public Boolean isSelected() {
        return selected;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musicien)) {
            return false;
        }
        Musicien other = (Musicien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }
    
}
