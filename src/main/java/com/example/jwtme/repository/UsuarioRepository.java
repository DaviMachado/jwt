package com.example.jwtme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jwtme.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	
	@Query("SELECT u FROM UsuarioEntity u WHERE id=(SELECT max(id) FROM UsuarioEntity)")
	UsuarioEntity consultaUltimoUsuarioCadastrado();
	
	UsuarioEntity findByEmail(String nome);
	
}
