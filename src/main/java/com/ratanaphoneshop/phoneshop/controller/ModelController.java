package com.ratanaphoneshop.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratanaphoneshop.phoneshop.dto.ModelDTO;
import com.ratanaphoneshop.phoneshop.entity.Model;
import com.ratanaphoneshop.phoneshop.mapper.ModelMapper;
import com.ratanaphoneshop.phoneshop.service.ModelService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	
	private final ModelService modelService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
		Model model = modelService.save(modelDTO);
		return ResponseEntity.ok(model);
	}
}
