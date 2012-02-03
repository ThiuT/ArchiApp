package com.mycompany.biblio.controller;

import com.mycompany.biblio.business.BookEJB;
import com.mycompany.biblio.model.Book;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.ListDataModel;


@ManagedBean
@SessionScoped
public class BookController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private BookEJB bookEJB;

    private HtmlDataTable dataTable;

    private Book book = new Book();
    private ListDataModel bookList; // j'ai utilisé un ListDataModel et pas List parce que cela permet de retrouver l'élément sélectionné dans la liste (pour l'édition d'un livre)

    private void updateBookList() {
        bookList = new ListDataModel(bookEJB.findAll());
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNew() {
        book = new Book();
        return "newBook.xhtml";
    }

    public String doCreate() {
        book = bookEJB.create(book);
        return "listBooks.xhtml";
    }
    
    public String doCancel() {
        return "listBooks.xhtml";
    }

    public String doDelete() {
        List<Book> books = (List<Book>)bookList.getWrappedData();
        bookEJB.delete(onlySelected(books));
        updateBookList();
        return "listBooks.xhtml";
    }

    private List<Book> onlySelected(List<Book> list) {
        for (Iterator<Book> it = list.iterator(); it.hasNext(); ) {
            if (!(it.next().isSelected()))
                it.remove();
        }
        return list;
    }

    public String doEdit() {
        book = (Book)bookList.getRowData(); // Voici comment on trouve le livre sélectionné
        return "editBook.xhtml";
    }

    public String doSave() {
        book = bookEJB.update(book);
        return "listBooks.xhtml";
    }
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ListDataModel getBookList() {
        updateBookList();
        return bookList;
    }

    public void setBookList(ListDataModel bookList) {
        this.bookList = bookList;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    
}