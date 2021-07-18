package com.rafaelnaranjo.pbb.users.repository;

import com.rafaelnaranjo.pbb.users.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByName(String name);

}
