package com.ratanaphoneshop.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ratanaphoneshop.phoneshop.dto.BrandDTO;
import com.ratanaphoneshop.phoneshop.entity.Brand;

@Mapper
public interface BrandMapper {
	BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
	
	Brand toBrand(BrandDTO dto); 
	
	BrandDTO toBrandDTO(Brand entity);
}
