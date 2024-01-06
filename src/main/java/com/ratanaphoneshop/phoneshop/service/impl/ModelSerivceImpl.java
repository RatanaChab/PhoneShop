package com.ratanaphoneshop.phoneshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratanaphoneshop.phoneshop.dto.ModelDTO;
import com.ratanaphoneshop.phoneshop.entity.Brand;
import com.ratanaphoneshop.phoneshop.entity.Model;
import com.ratanaphoneshop.phoneshop.mapper.ModelMapper;
import com.ratanaphoneshop.phoneshop.repository.ModelReposity;
import com.ratanaphoneshop.phoneshop.service.BrandService;
import com.ratanaphoneshop.phoneshop.service.ModelService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // for reuse autowired that more than 2
@Service
public class ModelSerivceImpl implements ModelService{
	
	private final ModelReposity modelReposity;
	private final ModelMapper modelMapper;
	
	@Override
	public Model save(ModelDTO modelDTO) { 
		Model model = modelMapper.toModel(modelDTO);
		return modelReposity.save(model);
	}
}
