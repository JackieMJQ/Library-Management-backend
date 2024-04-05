package org.servlet.springassign;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Create an “Author” class which will represent the authors from the “authors” table in the books database.
 *
 */

@Entity(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorID;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authorList")
    @JsonBackReference
    private List<Book> bookList = new ArrayList<>();


    /**
     * Getters and setters for Author attributes
     */
    public Integer getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Integer authorID) {
        this.authorID = authorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    /**
     * Adds a book to the author's book list
     * @param book Book to add
     */
    public void addBook(Book book) {
        bookList.add(book);
    }
}