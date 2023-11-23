package com.ratanaphoneshop.phoneshop.service;

import com.ratanaphoneshop.phoneshop.entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand updateById(Integer id, Brand brand);
}
