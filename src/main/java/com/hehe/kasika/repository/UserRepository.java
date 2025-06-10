package com.hehe.kasika.repository;

import com.hehe.kasika.model.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, UUID> {

}
