package org.servlet.springassign;

import jakarta.persistence.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Create a “Book” class which will represent the books from the “titles” table in the books database
 *
 */

@Entity(name = "titles")
public class Book {

    @Id
    private String isbn;
    private String title;
    private int edition_number;
    private int copyright;

    @ManyToMany
    @JoinTable(
            name = "authorISBN",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "authorID")
    )
    private List<Author> authorList = new ArrayList<>();


    /**
     * Getter for ISBN
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Setter for ISBN
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Getter for Title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for Title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for EditionNumber
     * @return
     */
    public int getEditionNumber() {
        return edition_number;
    }

    /**
     * Setter EditionNumber
     * @param edition_number
     */
    public void setEditionNumber(int edition_number) {
        this.edition_number = edition_number;
    }

    /**
     * Getter for CopyRight
     * @return
     */
    public int getCopyright() {
        return copyright;
    }

    /**
     * Setter for CopyRight
     * @param copyright
     */
    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    /**
     * Getter and Setter for authorList
     */
    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }


}


