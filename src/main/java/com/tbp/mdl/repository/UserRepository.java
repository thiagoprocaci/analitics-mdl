package com.tbp.mdl.repository;


import com.tbp.mdl.model.moodle.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
