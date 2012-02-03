package com.myproject.controllers;

import com.myproject.business.MusicienEJB;
import com.myproject.models.Musicien;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;


@ManagedBean
@SessionScoped
public class MusicienController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private MusicienEJB musicienEJB;

    private HtmlDataTable dataTable;

    private Musicien musicien = new Musicien();
    private List<Musicien> cList; // j'ai utilisé un ListDataModel et pas List parce que cela permet de retrouver l'élément sélectionné dans la liste (pour l'édition d'un livre)
    
    private void updateCList() {
        cList = musicienEJB.findAll();
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNew() {
        musicien = new Musicien();
        return "newMusicien.xhtml";
    }

    public String doCreate() {
        musicien = musicienEJB.create(musicien);
        return "membres.xhtml";
    }
    
    public String doCancel() {
        return "membres.xhtml";
    }

    public String doDelete() {
        musicienEJB.delete(cList);
        updateCList();
        return "membres.xhtml";
    }

    public String doEdit() {
//        musicien = (Musicien)cList.getRowData(); // Voici comment on trouve le livre sélectionné
        return "editMusicien.xhtml";
    }

    public String doSave() {
        musicien = musicienEJB.update(musicien);
        return "membres.xhtml";
    }
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Musicien getMusicien() {
        return musicien;
    }

    public void setMusicien(Musicien c) {
        this.musicien = c;
    }

    public List<Musicien> getCList() {
        updateCList();
        return cList;
    }

    public void setCList(List<Musicien> cList) {
        this.cList = cList;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }
}