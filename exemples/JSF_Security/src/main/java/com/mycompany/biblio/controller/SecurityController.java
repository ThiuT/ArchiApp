package com.mycompany.biblio.controller;

import com.mycompany.biblio.util.FacesUtil;
import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@ManagedBean
@RequestScoped
public class SecurityController implements Serializable {

    public final static String CONNECTED_USER_KEY = "connectedUser";
    public final static String SELECTED_COMPANY_KEY = "selectedCompany";

    public SecurityController() {
    }

    public String logout() {
        //String result = "/login?faces-redirect=true";
        String result = "success";

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.
                getExternalContext().getRequest();
        HttpSession session = (HttpSession)context.getExternalContext().getSession(false);
        try {
            if (session != null)
                session.invalidate();
            request.logout();
        } catch (ServletException ex) {
            Logger.getLogger(SecurityController.class.getName()).log(Level.SEVERE, null, ex);
            FacesUtil.addErrorMessage("Echec", ex.getMessage());
            result = "error";
        }

        return result;
    }

    public boolean isLoggedIn() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().
                getExternalContext().getRequest();

        Principal principal = request.getUserPrincipal();

        boolean loggedIn = false;
        if (principal != null) {
            loggedIn = true;
        }

        return loggedIn;
    }

    public String getConnectedUserid() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().
                getExternalContext().getRequest();

        Principal principal = request.getUserPrincipal();

        String userid = null;
        if (principal != null) {
            userid = principal.getName();
        }
        return userid;
    }

    public boolean isConnectedUserIsAdmin() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().
                getExternalContext().getRequest();

        return request.isUserInRole("ADMIN");
    }
}
