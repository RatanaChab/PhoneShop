package com.ratanaphoneshop.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ratanaphoneshop.phoneshop.dto.ModelDTO;
import com.ratanaphoneshop.phoneshop.entity.Brand;
import com.ratanaphoneshop.phoneshop.entity.Model;
import com.ratanaphoneshop.phoneshop.service.BrandService;

@Mapper(componentModel = "spring",uses = {BrandService.class})
public interface ModelMapper {
	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	
	@Mapping(target= "brand", source = "brandId")
	Model toModel(ModelDTO modelDTO);
	
	/*
	 * this method is never use while we have method that convert brandid to brand 
	 * from class brandservice ( getbyid ) 
	default Brand toBrand(Integer brId) {
		Brand brand = new Brand();
		brand.setId(brId);
		return brand;
	}
	*/
}
