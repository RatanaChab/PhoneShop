package com.ratanaphoneshop.phoneshop.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ratanaphoneshop.phoneshop.dto.BrandDTO;
import com.ratanaphoneshop.phoneshop.dto.PageDTO;
import com.ratanaphoneshop.phoneshop.entity.Brand;
import com.ratanaphoneshop.phoneshop.mapper.BrandMapper;
import com.ratanaphoneshop.phoneshop.service.BrandService;

@RestController
@RequestMapping("brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		brand = brandService.create(brand);
//		brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		return ResponseEntity.ok(brand);
//		return ResponseEntity.ok(brand);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandid){
		Brand brand = brandService.getById(brandid);
//		return ResponseEntity.ok(Mapper.toBrandDTO(brand));
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateOneBrand(@PathVariable("id") Integer brandid, @RequestBody BrandDTO brandDTO){
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand updateBrand = brandService.updateById(brandid, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updateBrand));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllBrands(@RequestParam Map<String, String> param){
//		Brand brand = brandService.getBrands();
//		List<BrandDTO> list = brandService.getBrand(param).stream()
//		.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
//		.collect(Collectors.toList());
		Page<Brand> brand = brandService.getBrand(param);
		PageDTO pageDTO = new PageDTO(brand);
		return ResponseEntity.ok(pageDTO);
	}
	
	
	// return from LIST
//	@GetMapping
//	public ResponseEntity<?> getAllBrands(@RequestParam Map<String, String> param){
////		Brand brand = brandService.getBrands();
//		List<BrandDTO> list = brandService.getBrand(param).stream()
//		.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
//		.collect(Collectors.toList());
//		return ResponseEntity.ok(list);
//	}
	
//	@GetMapping
//	public ResponseEntity<?> FilterBrands(@RequestParam("name") String name){
////		Brand brand = brandService.getBrands();
//		List<BrandDTO> list = brandService.getBrands(name).stream()
//		.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
//		.collect(Collectors.toList());
//		return ResponseEntity.ok(list);
//	}
}
