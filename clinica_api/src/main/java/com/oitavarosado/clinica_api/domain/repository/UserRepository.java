package com.oitavarosado.clinica_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.oitavarosado.clinica_api.domain.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	UserDetails findByEmail(String email);

}
