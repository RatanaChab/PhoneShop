package com.ratanaphoneshop.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ratanaphoneshop.phoneshop.dto.BrandDTO;
import com.ratanaphoneshop.phoneshop.entity.Brand;
import com.ratanaphoneshop.phoneshop.service.BrandService;
import com.ratanaphoneshop.phoneshop.util.Mapper;

@RestController
@RequestMapping("brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
		Brand brand = Mapper.toBrand(brandDTO);
		brand = brandService.create(brand);
		return ResponseEntity.ok(Mapper.toBrandDTO(brand));
//		return ResponseEntity.ok(brand);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandid){
		Brand brand = brandService.getById(brandid);
		return ResponseEntity.ok(Mapper.toBrandDTO(brand));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateOneBrand(@PathVariable("id") Integer brandid, @RequestBody BrandDTO brandDTO){
		Brand brand = Mapper.toBrand(brandDTO);
		Brand updateBrand = brandService.updateById(brandid, brand);
		return ResponseEntity.ok(Mapper.toBrandDTO(updateBrand));
	}
}
