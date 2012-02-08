package com.myproject.controllers;

import com.myproject.business.GroupeEJB;
import com.myproject.business.MusicienEJB;
import com.myproject.models.Groupe;
import com.myproject.models.Musicien;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;


@ManagedBean
@SessionScoped
public class GroupeController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private GroupeEJB groupeEJB;
    @EJB
    private MusicienEJB musicienEJB;

    private HtmlDataTable dataTable;

    private Groupe groupe = new Groupe();
    private List<Groupe> cList; // j'ai utilisé un List<Groupe> et pas List parce que cela permet de retrouver l'élément sélectionné dans la liste (pour l'édition d'un livre)

    private List<Long> membreIds;

    private long selectedMusicienId;

    private void updateCList() {
        cList = groupeEJB.findAll();
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNew() {
        groupe = new Groupe();
        return "newGroupe.xhtml";
    }

    public String doCreate() {
        groupe = groupeEJB.create(groupe);
        return "membres.xhtml";
    }
    
    public String doCancel() {
        return "membres.xhtml";
    }

    public String doDelete() {
        groupeEJB.delete(onlySelected(cList));
        updateCList();
        return "membres.xhtml";
    }

    private List<Groupe> onlySelected(List<Groupe> list) {
        for (Iterator<Groupe> it = list.iterator(); it.hasNext(); ) {
            if (!(it.next().isSelected()))
                it.remove();
        }
        return list;
    }

    public String doEdit() { 
        return "editGroupe.xhtml";
    }

    public String doSave() {
        Musicien selectedLeader= musicienEJB.findById(selectedMusicienId);
        groupe.setLeader(selectedLeader);
        groupe = groupeEJB.update(groupe);
        return "membres.xhtml";
    }
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe c) {
        this.groupe = c;
    }

    public List<Long> getMembreIds() {
        return membreIds;
    }

    public void setMembreIds(List<Long> membreIds) {
        this.membreIds = membreIds;
        List<Musicien> membres = groupe.getMembres();
        for (Iterator<Long> it = membreIds.iterator(); it.hasNext(); ) {
            membres.add(musicienEJB.findById(it.next()));
            it.remove();
        }
        groupe.setMembres(membres);
    }

    public List<Groupe> getCList() {
        updateCList();
        return cList;
    }

    public void setCList(List<Groupe> cList) {
        this.cList = cList;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    public long getSelectedMusicienId() {
        return selectedMusicienId;
    }

    public void setSelectedMusicienId(long selectedMusicienId) {
        this.selectedMusicienId = selectedMusicienId;
    }
}