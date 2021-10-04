package com.example.tiendaConcesionario.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tiendaConcesionario.model.Cliente;
import com.example.tiendaConcesionario.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

@Autowired
private ClienteService clienteService;

// *Crear un nuevo cliente

@PostMapping
public ResponseEntity<?> create(@RequestBody Cliente cliente) {

return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
}

// Leer un cliente
@GetMapping("/{id}")
public ResponseEntity<?> read(@PathVariable(value = "id") Long clienteid) {

Optional<Cliente> oUsuario = clienteService.findById(clienteid);

if (!oUsuario.isPresent()) {
return ResponseEntity.notFound().build();
}

return ResponseEntity.ok(oUsuario);

}

// Actualizar un cliente
@PutMapping("/{id}")
public ResponseEntity<?> update(@RequestBody Cliente clienteDetails, @PathVariable(value = "id") Long clienteid) {

Optional<Cliente> uCliente = clienteService.findById(clienteid);

if (!uCliente.isPresent()) {
return ResponseEntity.notFound().build();
}

// BeanUtils.copyProperties(usuarioDetails, uUsuario.get());
uCliente.get().setCedula(clienteDetails.getCedula());
uCliente.get().setNombre_completo(clienteDetails.getNombre_completo());
uCliente.get().setDireccion(clienteDetails.getDireccion());
uCliente.get().setTelefono(clienteDetails.getTelefono());
uCliente.get().setCorreo_electronico(clienteDetails.getCorreo_electronico());

return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(uCliente.get()));

}

// Borrar un cliente
@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable(value = "id") Long clienteId) {

if (!clienteService.findById(clienteId).isPresent()) {
return ResponseEntity.notFound().build();
}

clienteService.delete(clienteId);
return ResponseEntity.ok().build();

}

// Obtener todos los clientes
@GetMapping
public List<Cliente> readAll() {

List<Cliente> cliente = StreamSupport.stream(clienteService.findAll().spliterator(), false)
.collect(Collectors.toList());

return cliente;
}

}