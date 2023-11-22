package com.ratanaphoneshop.phoneshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratanaphoneshop.phoneshop.entity.Brand;
import com.ratanaphoneshop.phoneshop.repository.BrandRepository;
import com.ratanaphoneshop.phoneshop.service.BrandService;

@Service
public class BrandServiceImp implements BrandService{
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}
}
