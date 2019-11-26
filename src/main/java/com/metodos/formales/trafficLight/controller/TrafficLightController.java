package com.metodos.formales.trafficLight.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metodos.formales.sensor.controller.SensorController;
import com.metodos.formales.system.dto.SystemDto;
import com.metodos.formales.system.service.SystemService;
import com.metodos.formales.trafficLight.dto.TrafficLightDto;
import com.metodos.formales.trafficLight.service.TrafficLightService;

@Controller
public class TrafficLightController {

	@Autowired
	private TrafficLightService service;
	
	@Autowired
	private SystemService systemService;
	
	private static final String GENERAL_FOLDER = "trafficLight/";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SensorController.class);
	
	@GetMapping("/traffic")
	public String retriveData(Model model, RedirectAttributes redirectAttributes, Locale locale) {
		return GENERAL_FOLDER + "trafficLight";
	}
	
	@GetMapping("/traffic/create/green")
	public String retriveDataGreen(Model model, RedirectAttributes redirectAttributes, Locale locale) {
		return GENERAL_FOLDER + "create-green";
	}
	
	@PostMapping("/traffic/create/green")
	public String retriveDataGreenValue(Long id, Model model, RedirectAttributes redirectAttributes, Locale locale) {
		LOGGER.info("create: {}", id);
		
		try {
			List<TrafficLightDto> dto = this.service.findByCalleCarrera(true);
			List<TrafficLightDto> dtotwo = this.service.findByCalleCarrera(false);
			if(id == 1) {
				for (TrafficLightDto trafficLightDto : dto) {
					trafficLightDto.setColor(true);
					this.service.save(trafficLightDto);
				}
				
				for (TrafficLightDto trafficLightDto : dtotwo) {
					trafficLightDto.setColor(false);
					this.service.save(trafficLightDto);
				}
			} else {
				for (TrafficLightDto trafficLightDto : dto) {
					trafficLightDto.setColor(false);
					this.service.save(trafficLightDto);
				}
				
				for (TrafficLightDto trafficLightDto : dtotwo) {
					trafficLightDto.setColor(true);
					this.service.save(trafficLightDto);
				}
			}
			
			redirectAttributes.addFlashAttribute("messageerror","El sensor se creo correctamente");
			return "redirect:" +  "/";
		} catch (Exception e) {
			LOGGER.error("Error al crear: ", e);
			redirectAttributes.addFlashAttribute("dto", id);
			redirectAttributes.addFlashAttribute("messageerror","No fue posible crear el sensor");
			return "redirect:" +  "/";
		}
		
	}
	
	
	@GetMapping("/traffic/all")
	@ResponseBody
	public ResponseEntity<List<TrafficLightDto>> getSensorId(){
		List<TrafficLightDto> traffic = this.service.findAll();
		return new ResponseEntity<List<TrafficLightDto>>(traffic, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/traffic/{id}")
	@ResponseBody
	public ResponseEntity<TrafficLightDto> getSensorId(@PathVariable("id") long id){
		TrafficLightDto traffic = this.service.findById(id);
		return ResponseEntity.ok(traffic);
	}
	
	@GetMapping("/traffic/create")
	public String createGet(Model model, RedirectAttributes redirectAttributes, Locale locale) {
		addList(model);
		return GENERAL_FOLDER + "create-edit";
	}
	
	private void addList(Model model) {
		model.addAttribute("statuss", this.systemService.findByType("system.status"));
	}

	@PostMapping("/traffic/create")
	public String createSensor(TrafficLightDto dto, RedirectAttributes redirectAttributes, Locale locale, Model model){
		LOGGER.info("create: {}", dto);
		
		try {
			SystemDto status = this.systemService.findById(dto.getStatus().getId());
			dto.setStatus(status);
			dto.setColor(true);
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
	
	@GetMapping("/traffic/edit/{id}")
	public String updateGet(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes, Locale locale) {
		try {
			TrafficLightDto dto = null;
			if(id != null && id > 0) {
				dto = this.service.findById(id);
				model.addAttribute("dto",dto);
			}
			addList(model);
			return GENERAL_FOLDER + "create-edit";
		} catch (Exception e) {
			LOGGER.error("Error al crear: ", e);
			redirectAttributes.addFlashAttribute("messageerror","Error");
			return "redirect:" + "/";
		}
	}

	@PostMapping("/traffic/edit/{id}")
	public String updateTraffic(@PathVariable("id") Long id, TrafficLightDto dto, RedirectAttributes redirectAttributes, Locale locale, Model model){
		LOGGER.info("create: {}", dto);
		
		try {
			TrafficLightDto dtoSave = null;
			if(id != null && id > 0) {
				dtoSave = this.service.findById(id);
				dtoSave = dto;
			}
			SystemDto status = this.systemService.findById(dto.getStatus().getId());
			dtoSave.setStatus(status);
			dtoSave.setColor(true);
			this.service.save(dtoSave);
			redirectAttributes.addFlashAttribute("messageerror","El sensor se creo correctamente");
			return "redirect:" +  "/";
		} catch (Exception e) {
			LOGGER.error("Error al crear: ", e);
			redirectAttributes.addFlashAttribute("dto", dto);
			redirectAttributes.addFlashAttribute("messageerror","No fue posible crear el sensor");
			return "redirect:" +  "/";
		}
	}
	
	@PostMapping("/traffic/delete/{id}")
	public ResponseEntity<TrafficLightDto> deleteTraffic(@PathVariable("id") Long id) {
		LOGGER.info("delete: {}", id);
		try {
			TrafficLightDto dto = this.service.findById(id);
			this.service.delete(dto);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error al crear: ", e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
