package com.ratanaphoneshop.phoneshop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.ratanaphoneshop.phoneshop.entity.Brand;
import com.ratanaphoneshop.phoneshop.exception.APIExecption;
import com.ratanaphoneshop.phoneshop.exception.ResourceNotFoundException;
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

	@Override
	public Brand getById(Integer id) {
//		Optional<Brand> findById = brandRepository.findById(id);
//		if(findById.isPresent()) {
//			return findById.get();
//		}
//		throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand id = %d not found".formatted(id));
		return brandRepository.findById(id)
//				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand id = %d not found".formatted(id)));
				.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	}

	@Override
	public Brand updateById(Integer id, Brand brandupdate) {
		Brand brand = getById(id);
		brand.setName(brandupdate.getName());
		return brandRepository.save(brand);
	}
	
	
}
