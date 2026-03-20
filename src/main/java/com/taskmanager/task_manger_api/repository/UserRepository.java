package com.taskmanager.task_manger_api.repository;


import com.taskmanager.task_manger_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  // Tells Spring: "this is a database-access component"
public interface UserRepository extends JpaRepository<User, Long> {

    // You don't write any code here — Spring writes it for you!
    // Just by declaring the method name, Spring knows what SQL to run.

    Optional<User> findByUsername(String username);
    // Spring sees "findByUsername" → runs: SELECT * FROM users WHERE username = ?

    Optional<User> findByEmail(String email);
    // Spring sees "findByEmail" → runs: SELECT * FROM users WHERE email = ?

    boolean existsByUsername(String username);
    // Spring sees "existsByUsername" → runs: SELECT COUNT(*) FROM users WHERE username = ?

    boolean existsByEmail(String email);
}
