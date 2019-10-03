package com.metodos.formales.sensortrafico.controller;

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

import com.metodos.formales.sensortrafico.dto.SensorTraficoDto;
import com.metodos.formales.sensortrafico.entity.SensorTraficoEntity;
import com.metodos.formales.sensortrafico.service.SensorTraficoService;

@Controller
public class SensorTraficoController {

	@Autowired
	private SensorTraficoService service;
	
	@GetMapping("/sensorTrafico/all")
	@ResponseBody
	public ResponseEntity<List<SensorTraficoEntity>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

	@DeleteMapping("/sensorTrafico/{id}")
	public void deleteSensor(@PathVariable("id") long id) {
		SensorTraficoEntity sensor = this.service.findById(id);
		if (sensor != null) {
			this.service.delete(sensor);
		}
	}
	
	@PutMapping("/sensorTrafico/{id}")
	public ResponseEntity<SensorTraficoEntity> updateSensor(@PathVariable("id") long id, SensorTraficoDto dto){
		SensorTraficoEntity sensor = this.service.findById(id);
		if(sensor == null) {
			return new ResponseEntity<SensorTraficoEntity>(HttpStatus.NOT_FOUND);
		} else {
			sensor.setDatos(dto.getDatos());
		}
		return new ResponseEntity<>(this.service.save(sensor), HttpStatus.OK);
	}
	
	@PostMapping("/sensorTrafico/create")
	public ResponseEntity<SensorTraficoEntity> createVia(@RequestBody SensorTraficoDto dto){
		SensorTraficoEntity sensor = new SensorTraficoEntity();
		sensor.setDatos(dto.getDatos());
		return new ResponseEntity<>(this.service.save(sensor), HttpStatus.CREATED);
	}
}
