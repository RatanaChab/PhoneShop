package com.ratanaphoneshop.phoneshop.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.ratanaphoneshop.phoneshop.entity.Brand;
import com.ratanaphoneshop.phoneshop.exception.APIExecption;
import com.ratanaphoneshop.phoneshop.exception.ResourceNotFoundException;
import com.ratanaphoneshop.phoneshop.repository.BrandRepository;
import com.ratanaphoneshop.phoneshop.service.BrandService;
import com.ratanaphoneshop.phoneshop.service.util.PageUtil;
import com.ratanaphoneshop.phoneshop.specification.BrandFilter;
import com.ratanaphoneshop.phoneshop.specification.BrandSpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImp implements BrandService{
	
	@Autowired
	private final BrandRepository brandRepository;
	
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

//	@Override
//	public List<Brand> getBrand(Map<String, String> param) {
//		BrandFilter brandFilter = new BrandFilter();
//		
//		if(param.containsKey("name")) {
//			String name = param.get("name");
//			brandFilter.setName(name);
//		}
//		
//		if(param.containsKey("id")) {
//			String id = param.get("id");
//			brandFilter.setId(Integer.parseInt(id));
//		}
//		int pagelimit = 1;
//		if(param.containsKey(PageUtil.PAGE_LIMIT)) {
//			pagelimit = Integer.parseInt(param.get(PageUtil.PAGE_LIMIT));
//		}
//		
//		int pagenumber = 1;
//		if(param.containsKey(PageUtil.PAGE_LIMIT)) {
//			pagenumber = Integer.parseInt(param.get(PageUtil.PAGE_NUMBER));
//		}
//		
//		BrandSpec brandSpec = new BrandSpec(brandFilter);
//		Pageable pageable = PageUtil.getPageable(pagenumber, pagelimit);
//		
//		return brandRepository.findAll(pageable);
//	}
	
	@Override
	public Page<Brand> getBrand(Map<String, String> param) {
		BrandFilter brandFilter = new BrandFilter();
		
		if(param.containsKey("name")) {
			String name = param.get("name");
			brandFilter.setName(name);
		}
		
		if(param.containsKey("id")) {
			String id = param.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		int pagelimit = 1;
		if(param.containsKey(PageUtil.PAGE_LIMIT)) {
			pagelimit = Integer.parseInt(param.get(PageUtil.PAGE_LIMIT));
		}
		
		int pagenumber = 1;
		if(param.containsKey(PageUtil.PAGE_NUMBER)) {
			pagenumber = Integer.parseInt(param.get(PageUtil.PAGE_NUMBER));
		}
		
		BrandSpec brandSpec = new BrandSpec(brandFilter);
		Pageable pageable = PageUtil.getPageable(pagenumber, pagelimit);
		
		Page<Brand> page = brandRepository.findAll(brandSpec,pageable);
		return page;
	}

	@Override
	public List<Brand> getBrands(String name) {
		return brandRepository.findByNameContaining(name);
//		return brandRepository.findByNameLike("%"+name+"%");
	}
	
	
}
