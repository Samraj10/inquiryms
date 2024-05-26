package com.infy.pr.mf.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.pr.mf.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
