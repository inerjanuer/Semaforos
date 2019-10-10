package com.metodos.formales.roles.controller;

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

import com.metodos.formales.roles.dto.RolesDto;
import com.metodos.formales.roles.entity.RolesEntity;
import com.metodos.formales.roles.service.RolesService;

@Controller
public class RolesController {

	@Autowired
	private RolesService service;
	
	
	@GetMapping("/roles/all")
	@ResponseBody
	public ResponseEntity<List<RolesEntity>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

	@DeleteMapping("/roles/{id}")
	public void deleteVia(@PathVariable("id") long id) {
		RolesEntity role = this.service.findById(id);
		if (role != null) {
			this.service.delete(role);
		}
	}
	
	@PutMapping("/roles/{id}")
	public ResponseEntity<RolesEntity> updateVia(@PathVariable("id") long id, RolesDto dto){
		RolesEntity role = this.service.findById(id);
		if(role == null) {
			return new ResponseEntity<RolesEntity>(HttpStatus.NOT_FOUND);
		} else {
			role.setName(dto.getName());
		}
		return new ResponseEntity<>(this.service.save(role), HttpStatus.OK);
	}
	
	@PostMapping("/roles/create")
	public ResponseEntity<RolesEntity> createVia(@RequestBody RolesDto dto){
		RolesEntity role = new RolesEntity();
		role.setName(dto.getName());
		return new ResponseEntity<>(this.service.save(role), HttpStatus.CREATED);
	}
}
