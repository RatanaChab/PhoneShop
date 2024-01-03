package com.ratanaphoneshop.phoneshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.ratanaphoneshop.phoneshop.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand updateById(Integer id, Brand brand);
//	List<Brand> getBrands();
	List<Brand> getBrands(String name);
//	List<Brand> getBrand(Map<String,String> param);
	Page<Brand> getBrand(Map<String,String> param);
}
