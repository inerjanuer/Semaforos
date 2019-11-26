package com.metodos.formales.usuario.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metodos.formales.usuario.dto.UsuarioDto;
import com.metodos.formales.usuario.entity.UsuarioEntity;
import com.metodos.formales.usuario.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final String GENERAL_FOLDER = "user/";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

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
	
	@GetMapping("/user/create")
	public String retriveData(Model model, RedirectAttributes redirectAttributes, Locale locale) {
		return GENERAL_FOLDER + "user";
	}
	
	@PostMapping("/user/create")
	public String createUser(UsuarioDto dto,  RedirectAttributes redirectAttributes, Locale locale, Model model){
		LOGGER.info("create: {}", dto);
		
		try {
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setNombre(dto.getNombre());
			usuario.setEmail(dto.getEmail());
			usuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));
			this.service.save(usuario);
			redirectAttributes.addFlashAttribute("messageerror","El usuario se creo correctamente");
			return "redirect:" +  "/";
		} catch (Exception e) {
			LOGGER.error("Error al crear: ", e);
			redirectAttributes.addFlashAttribute("dto", dto);
			redirectAttributes.addFlashAttribute("messageerror","No fue posible crear el usurio");
			return "redirect:" +  "/";
		}
	}
}
