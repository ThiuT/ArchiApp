package com.myproject.controllers;

import com.myproject.business.GroupeEJB;
import com.myproject.models.Groupe;
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

    private HtmlDataTable dataTable;

    private Groupe Groupe = new Groupe();
    private ListDataModel cList; // j'ai utilisé un ListDataModel et pas List parce que cela permet de retrouver l'élément sélectionné dans la liste (pour l'édition d'un livre)

    private void updateCList() {
        cList = new ListDataModel(groupeEJB.findAll());
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNew() {
        Groupe = new Groupe();
        return "newGroupe.xhtml";
    }

    public String doCreate() {
        Groupe = groupeEJB.create(Groupe);
        return "planning.xhtml";
    }
    
    public String doCancel() {
        return "planning.xhtml";
    }

    public String doDelete() {
        List<Groupe> Groupes = (List<Groupe>)cList.getWrappedData();
        groupeEJB.delete(onlySelected(Groupes));
        updateCList();
        return "planning.xhtml";
    }

    private List<Groupe> onlySelected(List<Groupe> list) {
        for (Iterator<Groupe> it = list.iterator(); it.hasNext(); ) {
            if (!(it.next().isSelected()))
                it.remove();
        }
        return list;
    }

    public String doEdit() {
        Groupe = (Groupe)cList.getRowData(); // Voici comment on trouve le livre sélectionné
        return "editGroupe.xhtml";
    }

    public String doSave() {
        Groupe = groupeEJB.update(Groupe);
        return "planning.xhtml";
    }
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Groupe getGroupe() {
        return Groupe;
    }

    public void setGroupe(Groupe c) {
        this.Groupe = c;
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