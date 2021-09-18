package com.example.tiendaConcesionario.api;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;  
import com.example.tiendaConcesionario.dao.UsuariosDAO; 
import com.example.tiendaConcesionario.model.Usuarios;  

@RestController //esta es una clase REST 
@RequestMapping("usuarios") 

public class UsuariosAPI {
	
	@Autowired //inyecta la dependencia de todos los métodos del JPA para usuarioDAO  
	private UsuariosDAO usuariosDAO;    
	
	@PostMapping("/guardar")//Request convierte en un objeto Java desde un JSon 
	public void guardar(@RequestBody Usuarios usuarios) {   
		usuariosDAO.save(usuarios);  
	}    
	
	@GetMapping("/listar")  
	public List<Usuarios> listar(){   
		return usuariosDAO.findAll();  
	}    
	
	@DeleteMapping("/eliminar/{id}")  
	public void eliminar(@PathVariable("id") Integer id) {  
		usuariosDAO.deleteById(id);  
	}    
	
	
	@PutMapping("/actualizar")  
	public void actualizar(@RequestBody Usuarios usuarios) {   
		usuariosDAO.save(usuarios);  
	} 

}
