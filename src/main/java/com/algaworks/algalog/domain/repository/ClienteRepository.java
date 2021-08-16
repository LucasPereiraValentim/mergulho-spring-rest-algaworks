package com.algaworks.algalog.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query(value = "SELECT c FROM Cliente c WHERE c.email = :email")
	Optional<Cliente> findByEmail(@Param(value = "email") String email);
		
	
	
	
}
