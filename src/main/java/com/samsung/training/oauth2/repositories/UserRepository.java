package com.samsung.training.oauth2.repositories;

import com.samsung.training.oauth2.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
