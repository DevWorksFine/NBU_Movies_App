package com.coursework.movies.repository;

import com.coursework.movies.domain.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity,Long> {
}
