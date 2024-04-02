package org.servlet.springassign;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.PrintStream;
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
    private int editionNumber;
    private int copyright;
//    private List<Author> authorList;


    /**
     * Book Constructor
     * @param isbn
     * @param title
     * @param editionNumber
     * @param copyright
     */
//    public Book(String isbn, String title, int editionNumber, int copyright, List<Author> authorList) {
//        this.isbn = isbn;
//        this.title = title;
//        this.editionNumber = editionNumber;
//        this.copyright = copyright;
//        this.authorList = authorList;
//    }

    public Book(String isbn, String title, int editionNumber, int copyright) {
        this.isbn = isbn;
        this.title = title;
        this.editionNumber = editionNumber;
        this.copyright = copyright;
    }


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
        return editionNumber;
    }

    /**
     * Setter EditionNumber
     * @param editionNumber
     */
    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
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
     * Getter for AuthorList
     * @return
     */
//    public List<Author> getAuthorList() {
//        return authorList;
//    }

    /**
     * Setter for AuthorList
     * @param authorList
     */
//    public void setAuthorList(List<Author> authorList) {
//        this.authorList = authorList;
//    }

    /**
     * Print out the book information
     */
    public void printBookInformation(PrintStream printStream){
        printStream.printf("\nISBN: %s \t\t Title: %-80s \t\t Edition #: %d \t\t Copyright: %s",
                this.getIsbn(), this.getTitle(), this.getEditionNumber(), this.getCopyright());
        //TODO Add the Authors - traverse the list
    }
}


