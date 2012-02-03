package com.myproject.controllers;

import com.myproject.business.MusicienEJB;
import com.myproject.models.Musicien;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.ListDataModel;


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
    private ListDataModel cList; // j'ai utilisé un ListDataModel et pas List parce que cela permet de retrouver l'élément sélectionné dans la liste (pour l'édition d'un livre)

    private void updateCList() {
        cList = new ListDataModel(musicienEJB.findAll());
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
        return "planning.xhtml";
    }
    
    public String doCancel() {
        return "planning.xhtml";
    }

    public String doDelete() {
        List<Musicien> Musiciens = (List<Musicien>)cList.getWrappedData();
        musicienEJB.delete(onlySelected(Musiciens));
        updateCList();
        return "planning.xhtml";
    }

    private List<Musicien> onlySelected(List<Musicien> list) {
        for (Iterator<Musicien> it = list.iterator(); it.hasNext(); ) {
            if (!(it.next().isSelected()))
                it.remove();
        }
        return list;
    }

    public String doEdit() {
        musicien = (Musicien)cList.getRowData(); // Voici comment on trouve le livre sélectionné
        return "editMusicien.xhtml";
    }

    public String doSave() {
        musicien = musicienEJB.update(musicien);
        return "planning.xhtml";
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

    public ListDataModel getCList() {
        updateCList();
        return cList;
    }

    public void setCList(ListDataModel cList) {
        this.cList = cList;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    
}