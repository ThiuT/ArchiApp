/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myproject.models;
import java.io.Serializable;
import javax.persistence.*;


@Entity

@NamedQuery(name = Creneau.FIND_ALL, query = "SELECT c FROM Creneau c")

public class Creneau implements Serializable {
   public final static String FIND_ALL = "Creneau.findAll";
   public final static String Del_SOM = "Creneau.delete";

 @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private int semaine;
    @Column(nullable = false)
    private int jour;
    @Column(nullable = false)
    private int heure;
    @JoinColumn
    @ManyToOne
    private Groupe groupe;
    @Transient
    private Boolean selected;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Creneau() {
    }

    public Creneau(int w, int d, int h, Groupe g) {
        this.semaine = w;
        this.jour = d;
        this.heure = h;
        this.groupe = g;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================
    public Long getId() {
        return id;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getSemaine() {
        return semaine;
    }

    public void setSemaine(int semaine) {
        this.semaine = semaine;
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

    // ======================================
    // =         hash, equals, toString     =
    // ======================================

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Créneau");
        sb.append("{id=").append(id);
        sb.append(", semaine='").append(semaine).append('\'');
        sb.append(", jour=").append(jour);
        sb.append(", heure='").append(heure).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

