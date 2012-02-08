/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myproject.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = Groupe.FIND_ALL, query = "SELECT g FROM Groupe g"),
    @NamedQuery(name = Groupe.FIND_BY_ID, query = "SELECT g FROM Groupe g WHERE g.id=:i")
})
public class Groupe implements Serializable {

    public final static String FIND_ALL = "Groupe.findAll";
    public final static String FIND_BY_ID = "Groupe.findByID";
    public final static String Del_SOM = "Groupe.delete";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nom;
    @Column
    private String style;
    @ManyToMany
    private List<Musicien> membres;

    @Transient
    private Boolean selected;

    // ======================================
    // =            Constructors            =
    // ======================================
    public Groupe() {
        membres = new ArrayList<Musicien>();
    }

    public Groupe(String n, String s) {
        this.nom = n;
        this.style = s;
        membres = new ArrayList<Musicien>();
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

    public List<Musicien> getMembres() {
        return membres;
    }

    public void setMembres(List<Musicien> membres) {
        this.membres = membres;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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

    /*
     * @Override public boolean equals(Object object) { // TODO: Warning - this
     * method won't work in the case the id fields are not set if (!(object
     * instanceof Groupe)) { return false; } Groupe other = (Groupe) object; if
     * ((this.id == null && other.id != null) || (this.id != null &&
     * !this.id.equals(other.id))) { return false; } return true;
    }
     */
    @Override
    public String toString() {
        return nom;
    }
}
