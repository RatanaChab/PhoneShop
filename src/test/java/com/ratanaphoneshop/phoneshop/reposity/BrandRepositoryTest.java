package com.ratanaphoneshop.phoneshop.reposity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ratanaphoneshop.phoneshop.entity.Brand;
import com.ratanaphoneshop.phoneshop.repository.BrandRepository;

@DataJpaTest
public class BrandRepositoryTest {
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Test
	public void TestfindByNameLike() {
		// Given
		Brand brand = new Brand();
		brand.setName("Apple");
		
		Brand brand1 = new Brand();
		brand1.setName("Samsung");
		brandRepository.save(brand);
		brandRepository.save(brand1);
		// When
		List<Brand> brands = brandRepository.findByNameLike("%A%");
		
		// Then
		assertEquals(1, brands.size());
		assertEquals("Apple", brands.get(0).getName());
		assertEquals(1, brands.get(0).getId());
	}
}
