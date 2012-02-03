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
import javax.faces.model.ListDataModel;


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
    private ListDataModel cList; // j'ai utilisé un ListDataModel et pas List parce que cela permet de retrouver l'élément sélectionné dans la liste (pour l'édition d'un livre)


    private long selectedMusicienId;

    private void updateCList() {
        cList = new ListDataModel(groupeEJB.findAll());
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
        List<Groupe> Groupes = (List<Groupe>)cList.getWrappedData();
        groupeEJB.delete(onlySelected(Groupes));
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
        groupe = (Groupe)cList.getRowData(); // Voici comment on trouve le livre sélectionné
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

    public long getSelectedMusicienId() {
        return selectedMusicienId;
    }

    public void setSelectedMusicienId(long selectedMusicienId) {
        this.selectedMusicienId = selectedMusicienId;
    }
}