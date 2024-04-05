package org.servlet.springassign;

import org.springframework.data.repository.CrudRepository;

/**
 * User Repository for JPA
 *
 */


public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
