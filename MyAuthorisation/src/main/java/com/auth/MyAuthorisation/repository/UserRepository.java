package com.auth.MyAuthorisation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.MyAuthorisation.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User getUserByUsername(String username);

}
