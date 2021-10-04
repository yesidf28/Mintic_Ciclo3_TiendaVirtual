package com.example.tiendaConcesionario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tiendaConcesionario.dao.UsuarioDao;
import com.example.tiendaConcesionario.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao usuariodao;
	
	
	@Override
	public Iterable<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuariodao.findAll();
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		// TODO Auto-generated method stub
		return usuariodao.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuariodao.save(usuario);
	}

	@Override
	public void delete(Long id) {
		usuariodao.deleteById(id);
		
	}
	
	
	
	
}
