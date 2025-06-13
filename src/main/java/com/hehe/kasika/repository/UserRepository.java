package com.hehe.kasika.repository;

import com.hehe.kasika.model.Users;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {


    @EntityGraph(attributePaths = "roles")
    Optional<Users> findByUsername(String username);

    boolean existsByUsername(String username);
}
