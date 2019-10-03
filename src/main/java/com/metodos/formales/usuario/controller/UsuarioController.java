package com.metodos.formales.usuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metodos.formales.usuario.dto.UsuarioDto;
import com.metodos.formales.usuario.entity.UsuarioEntity;
import com.metodos.formales.usuario.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping("/usuario/all")
	@ResponseBody
	public ResponseEntity<List<UsuarioEntity>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

	@DeleteMapping("/usuario/{id}")
	public void deleteUsuario(@PathVariable("id") long id) {
		UsuarioEntity usuario = this.service.findById(id);
		if (usuario != null) {
			this.service.delete(usuario);
		}
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<UsuarioEntity> updateUsuario(@PathVariable("id") long id, UsuarioDto dto){
		UsuarioEntity usuario = this.service.findById(id);
		if(usuario == null) {
			return new ResponseEntity<UsuarioEntity>(HttpStatus.NOT_FOUND);
		} else {
			usuario.setNombre(dto.getNombre());
			usuario.setEmail(dto.getEmail());
		}
		return new ResponseEntity<>(this.service.save(usuario), HttpStatus.OK);
	}
	
	@PostMapping("/usuario/create")
	public ResponseEntity<UsuarioEntity> createVia(@RequestBody UsuarioDto dto){
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setNombre(dto.getNombre());
		usuario.setEmail(dto.getEmail());
		return new ResponseEntity<>(this.service.save(usuario), HttpStatus.CREATED);
	}
}
