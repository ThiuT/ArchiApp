/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.biblio.model;

import javax.persistence.Column;

/**
 *
 * @author root
 */
public class Livre {

 @Column(nullable = false)
    private String title;
 @Column(length = 2000)
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

public Livre(){
}



}
