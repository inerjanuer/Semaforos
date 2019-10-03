package com.metodos.formales.sensorvelocidad.controller;

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

import com.metodos.formales.sensorvelocidad.dto.SensorVelocidadDto;
import com.metodos.formales.sensorvelocidad.entity.SensorVelocidadEntity;
import com.metodos.formales.sensorvelocidad.service.SensorVelocidadService;

@Controller
public class SensorVelocidadController {

	@Autowired
	private SensorVelocidadService service;
	
	@GetMapping("/sensorVelocidad/all")
	@ResponseBody
	public ResponseEntity<List<SensorVelocidadEntity>> findAll() {
		return ResponseEntity.ok(this.service.findAll());
	}

	@DeleteMapping("/sensorVelocidad/{id}")
	public void deleteSensor(@PathVariable("id") long id) {
		SensorVelocidadEntity sensor = this.service.findById(id);
		if (sensor != null) {
			this.service.delete(sensor);
		}
	}
	
	@PutMapping("/sensorVelocidad/{id}")
	public ResponseEntity<SensorVelocidadEntity> updateSensor(@PathVariable("id") long id, SensorVelocidadDto dto){
		SensorVelocidadEntity sensor = this.service.findById(id);
		if(sensor == null) {
			return new ResponseEntity<SensorVelocidadEntity>(HttpStatus.NOT_FOUND);
		} else {
			sensor.setDatos(dto.getDatos());
		}
		return new ResponseEntity<>(this.service.save(sensor), HttpStatus.OK);
	}
	
	@PostMapping("/sensorVelocidad/create")
	public ResponseEntity<SensorVelocidadEntity> createVia(@RequestBody SensorVelocidadDto dto){
		SensorVelocidadEntity sensor = new SensorVelocidadEntity();
		sensor.setDatos(dto.getDatos());
		return new ResponseEntity<>(this.service.save(sensor), HttpStatus.CREATED);
	}
}
