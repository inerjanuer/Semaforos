package com.metodos.formales.sensor.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metodos.formales.sensor.dto.SensorDto;
import com.metodos.formales.sensor.service.SensorService;
import com.metodos.formales.system.dto.SystemDto;
import com.metodos.formales.system.service.SystemService;

@Controller
public class SensorController {

	@Autowired
	private SensorService service;
	
	@Autowired
	private SystemService systemService;
	
	private static final String GENERAL_FOLDER = "sensor/";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SensorController.class);
	
	@GetMapping("/sensor")
	public String retriveData(Model model, RedirectAttributes redirectAttributes, Locale locale) {
		return GENERAL_FOLDER + "sensor";
	}
	
	@GetMapping("/sensor/{id}")
	@ResponseBody
	public ResponseEntity<SensorDto> getSensorId(@PathVariable("id") long id){
		SensorDto sensor = this.service.findById(id);
		return ResponseEntity.ok(sensor);
	}
	
	@GetMapping("/sensor/create")
	public String createGet(Model model, RedirectAttributes redirectAttributes, Locale locale) {
		addList(model);
		return GENERAL_FOLDER + "create-edit";
	}
	
	private void addList(Model model) {
		model.addAttribute("statuss", this.systemService.findByType("system.status"));
		model.addAttribute("types", this.systemService.findByType("system.type.sensor"));
	}

	@PostMapping("/sensor/create")
	public String createSensor(SensorDto dto, RedirectAttributes redirectAttributes, Locale locale, Model model){
		LOGGER.info("create: {}", dto);
		
		try {
			SystemDto status = this.systemService.findById(dto.getStatus().getId());
			SystemDto type = this.systemService.findById(dto.getTypeSensor().getId());
			dto.setStatus(status);
			dto.setTypeSensor(type);
			this.service.save(dto);
			redirectAttributes.addFlashAttribute("messageerror","El sensor se creo correctamente");
			return "redirect:" +  "/";
		} catch (Exception e) {
			LOGGER.error("Error al crear: ", e);
			redirectAttributes.addFlashAttribute("dto", dto);
			redirectAttributes.addFlashAttribute("messageerror","No fue posible crear el sensor");
			return "redirect:" +  "/";
		}
	}
}
