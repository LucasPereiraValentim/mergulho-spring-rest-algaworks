package com.algaworks.algalog.domain.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	
	List<Cliente> findByNome(String nome);
	
	List<Cliente> findByNomeContaining(String nome);
}
