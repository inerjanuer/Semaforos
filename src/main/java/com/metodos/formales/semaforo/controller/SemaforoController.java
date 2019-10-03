package com.metodos.formales.semaforo.controller;

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

import com.metodos.formales.semaforo.dto.SemafaroDto;
import com.metodos.formales.semaforo.entity.SemaforoEntity;
import com.metodos.formales.semaforo.service.SemaforoService;

@Controller
public class SemaforoController {

	@Autowired
	private SemaforoService service;
	
	@GetMapping("/semaforo/all")
	@ResponseBody
	public ResponseEntity<List<SemaforoEntity>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

	@DeleteMapping("/semaforo/{id}")
	public void deleteSensor(@PathVariable("id") long id) {
		SemaforoEntity semaforo = this.service.findById(id);
		if (semaforo != null) {
			this.service.delete(semaforo);
		}
	}
	
	@PutMapping("/semaforo/{id}")
	public ResponseEntity<SemaforoEntity> updateSensor(@PathVariable("id") long id, SemafaroDto dto){
		SemaforoEntity semaforo = this.service.findById(id);
		if(semaforo == null) {
			return new ResponseEntity<SemaforoEntity>(HttpStatus.NOT_FOUND);
		} else {
			semaforo.setEstado(dto.getEstado());
			semaforo.setLatitud(dto.getLatitud());
			semaforo.setLongitud(dto.getLongitud());
			semaforo.setSensorTrafico(dto.getSensorTrafico());
			semaforo.setSensorVelocidad(dto.getSensorVelocidad());
			semaforo.setVia(dto.getVia());
		}
		return new ResponseEntity<>(this.service.save(semaforo), HttpStatus.OK);
	}
	
	@PostMapping("/semaforo/create")
	public ResponseEntity<SemaforoEntity> createVia(@RequestBody SemafaroDto dto){
		SemaforoEntity semaforo = new SemaforoEntity();
		semaforo.setEstado(dto.getEstado());
		semaforo.setLatitud(dto.getLatitud());
		semaforo.setLongitud(dto.getLongitud());
		semaforo.setSensorTrafico(dto.getSensorTrafico());
		semaforo.setSensorVelocidad(dto.getSensorVelocidad());
		semaforo.setVia(dto.getVia());
		return new ResponseEntity<>(this.service.save(semaforo), HttpStatus.CREATED);
	}
}
