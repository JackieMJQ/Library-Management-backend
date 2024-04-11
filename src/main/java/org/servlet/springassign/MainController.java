package org.servlet.springassign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="api/v1") // This means URL's start with /demo (after Application path)
public class MainController {

    public static final String BOOK = "/books";
    public static final String AUTHORS = "/authors";

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    /**
     * Get all books
     * @return
     */
    @GetMapping(path  = BOOK)
    public @ResponseBody
    Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /**
     * get book by isbn
     * @param isbn
     * @return
     */
    @GetMapping(path = BOOK + "/{isbn}")
    public @ResponseBody
    Book getBookWithId(@PathVariable String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    /**
     * Create a new book
     * @param isbn
     * @param title
     * @param edition_number
     * @param copyright
     * @param author_id
     * @return
     */
    @PostMapping(path = BOOK)
    public @ResponseBody
    String addNewBook(@RequestParam String isbn, @RequestParam String title, @RequestParam int edition_number, @RequestParam int copyright, @RequestParam Integer author_id) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setEditionNumber(edition_number);
        book.setCopyright(copyright);

        Optional<Author> author = authorRepository.findById(author_id);
        if(author.isPresent()) {
            book.getAuthorList().add(author.get());
            bookRepository.save(book);
            return "saved";
        }
        return "Author not found";
    }

    /**
     * Update books for selected isbn
     * @param isbn
     * @param title
     * @param edition_number
     * @param copyright
     * @param author_id
     * @return
     */
    @PutMapping(path = BOOK + "/{isbn}")
    public @ResponseBody
    String updateBook(@PathVariable String isbn, @RequestParam String title, @RequestParam int edition_number, @RequestParam int copyright, @RequestParam Integer author_id) {
        Optional<Book> book = Optional.ofNullable(bookRepository.findBookByIsbn(isbn));
        if (book.isPresent()) {
            Book book1 = book.get();
            book1.setTitle(title);
            book1.setEditionNumber(edition_number);
            book1.setCopyright(copyright);
            // Fetch the author by id
            Optional<Author> optionalAuthor = authorRepository.findById(author_id);
            if (optionalAuthor.isPresent()) {
                Author author = optionalAuthor.get();
                // Add the fetched author to the book's authorList
                book1.getAuthorList().clear(); // Clear existing authors (if any)
                book1.getAuthorList().add(author);
                // Save the updated book
                bookRepository.save(book1);
                return "Updated";
            } else {
                return "Author not found";
            }
        } else {
            return "Book not found";
        }
    }

    /**
     * Delete the book by isbn
     * @param isbn
     * @return
     */
    @DeleteMapping(path = BOOK + "/{isbn}")
    public @ResponseBody
    String deleteBook(@PathVariable String isbn) {
        Optional<Book> book = Optional.ofNullable(bookRepository.findBookByIsbn(isbn));
        if (book.isPresent()) {
            bookRepository.delete(book.get());
            return "Deleted";
        }
        return "Book not found";
    }


    /**
     * Get all of authors
     * @return
     */
    @GetMapping(path = AUTHORS)
    public @ResponseBody
    Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    /**
     * Get author by ID
     * @param id
     * @return
     */
    @GetMapping(path = AUTHORS + "/{id}")
    public @ResponseBody
    Optional<Author> getUserWithId(@PathVariable Integer id) {
        return authorRepository.findById(id);
    }

    /**
     * Add an author
     * @param firstName
     * @param lastName
     * @return
     */
    @PostMapping(path=AUTHORS)
    public @ResponseBody String addNewAuthor (@RequestParam String firstName , @RequestParam String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.save(author);
        return "Saved";
    }


    /**
     * Update Author by ID
     * @param author_id
     * @param firstName
     * @param lastName
     * @return
     */
    @PutMapping(path = AUTHORS + "/{author_id}")
    public @ResponseBody
    String updateAuthor(@PathVariable Integer author_id, @RequestParam String firstName, @RequestParam String lastName) {
        Optional<Author> author = authorRepository.findById(author_id);
        if (author.isPresent()) {
            Author author1 = author.get();
            author1.setFirstName(firstName);
            author1.setLastName(lastName);
            authorRepository.save(author1);
            return "Updated";
        }
        return "Author not found";
    }

    /**
     * Delete Author By ID
     * @param author_id
     * @return
     */
    @DeleteMapping(path = AUTHORS + "/{author_id}")
    public @ResponseBody
    String deleteAuthor(@PathVariable Integer author_id) {
        Optional <Author> author = authorRepository.findById(author_id);
        if (author.isPresent()) {
            authorRepository.delete(author.get());
            return "Deleted";
        }
        return "Author not found";
    }

}