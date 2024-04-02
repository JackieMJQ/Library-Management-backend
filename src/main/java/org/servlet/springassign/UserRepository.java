package org.servlet.springassign;

import org.springframework.data.repository.CrudRepository;

/**
 * User Repository for JPA
 *
 */


public interface UserRepository extends CrudRepository<User, Integer> {
}
