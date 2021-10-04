package com.example.tiendaConcesionario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tiendaConcesionario.model.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {

}