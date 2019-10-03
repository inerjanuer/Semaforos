package com.metodos.formales.via.controller;

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

import com.metodos.formales.via.Service.ViaService;
import com.metodos.formales.via.dto.ViaDto;
import com.metodos.formales.via.entity.ViaEntity;

@Controller
public class ViaController {

	@Autowired
	private ViaService service;

	@GetMapping("/via/all")
	@ResponseBody
	public ResponseEntity<List<ViaEntity>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

	@DeleteMapping("/via/{id}")
	public void deleteVia(@PathVariable("id") long id) {
		ViaEntity via = this.service.findById(id);
		if (via != null) {
			this.service.delete(via);
		}

	}
	
	@PutMapping("/via/{id}")
	public ResponseEntity<ViaEntity> updateVia(@PathVariable("id") long id, ViaDto dto){
		ViaEntity via = this.service.findById(id);
		if(via == null) {
			return new ResponseEntity<ViaEntity>(HttpStatus.NOT_FOUND);
		} else {
			via.setCalle(dto.getCalle());
			via.setCarrera(dto.getCarrera());
			via.setEstado(dto.getEstado());
			via.setLatitud(dto.getLatitud());
			via.setLongitud(dto.getLongitud());
		}
		return new ResponseEntity<>(this.service.save(via), HttpStatus.OK);
	}
	
	@PostMapping("/via/create")
	public ResponseEntity<ViaEntity> createVia(@RequestBody ViaDto dto){
		ViaEntity via = new ViaEntity();
		via.setCalle(dto.getCalle());
		via.setCarrera(dto.getCarrera());
		via.setEstado(dto.getEstado());
		via.setLatitud(dto.getLatitud());
		via.setLongitud(dto.getLongitud());
		return new ResponseEntity<>(this.service.save(via), HttpStatus.CREATED);
	}
}
