package org.servlet.springassign;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findBookByIsbn(String isbn);
}
