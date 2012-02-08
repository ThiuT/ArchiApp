package com.myproject.controllers;

import com.myproject.business.GroupeEJB;
import com.myproject.business.PlanningEJB;
import com.myproject.models.Creneau;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.ListDataModel;
import javax.persistence.NoResultException;

@ManagedBean
@SessionScoped
public class PlanningController {

    // ======================================
    // =             Attributes             =
    // ======================================
    @EJB
    private PlanningEJB planningEJB;
    @EJB
    private GroupeEJB groupeEJB;
    private HtmlDataTable dataTable;
    private Creneau creneau = new Creneau();
    private ListDataModel cList; // j'ai utilisé un ListDataModel et pas List parce que cela permet de retrouver l'élément sélectionné dans la liste (pour l'édition d'un livre)
    private Long groupeID;

    private void updateCList() {
        cList = new ListDataModel(planningEJB.findAll());
    }

    // ======================================
    // =           Public Methods           =
    // ======================================
    public String doNew() {
        creneau = new Creneau();
        return "newCreneau.xhtml";
    }
    
    public String doNew(int j, int h) {
        creneau = new Creneau(j,h);
        return "reserveCreneau.xhtml";
    }

    public String doCreate() {
        creneau = planningEJB.create(creneau);
        return "planning.xhtml";
    }

    public String doCancel() {
        return "planning.xhtml";
    }

    public String doDelete() {
        List<Creneau> creneaux = (List<Creneau>) cList.getWrappedData();
        planningEJB.delete(onlySelected(creneaux));
        updateCList();
        return "planning.xhtml";
    }
    
    public String doDelete(Creneau c) {
        planningEJB.delete(c);
        updateCList();
        return "planning.xhtml";
    }

    public Creneau getCreneau(int j, int h) {
        return (Creneau) planningEJB.find(j, h);

    }

    private List<Creneau> onlySelected(List<Creneau> list) {
        for (Iterator<Creneau> it = list.iterator(); it.hasNext();) {
            if (!(it.next().isSelected())) {
                it.remove();
            }
        }
        return list;
    }

    public String doEdit() {
        creneau = (Creneau) cList.getRowData(); // Voici comment on trouve le livre sélectionné
        return "editCreneau.xhtml";
    }

    public String doSave() {
        creneau = planningEJB.update(creneau);
        return "planning.xhtml";
    }
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getGroupeID() {
        return groupeID;
    }

    public void setGroupeID(Long groupeID) {
        this.groupeID = groupeID;
        creneau.setGroupe(groupeEJB.findByID(groupeID));
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau c) {
        this.creneau = c;
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