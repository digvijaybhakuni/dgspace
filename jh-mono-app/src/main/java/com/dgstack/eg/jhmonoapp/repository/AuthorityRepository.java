package com.dgstack.eg.jhmonoapp.repository;

import com.dgstack.eg.jhmonoapp.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
