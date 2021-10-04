package com.example.tiendaConcesionario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tiendaConcesionario.model.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {	
	
}