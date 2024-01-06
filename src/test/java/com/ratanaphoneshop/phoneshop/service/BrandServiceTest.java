package com.ratanaphoneshop.phoneshop.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ratanaphoneshop.phoneshop.entity.Brand;
import com.ratanaphoneshop.phoneshop.exception.ResourceNotFoundException;
import com.ratanaphoneshop.phoneshop.repository.BrandRepository;
import com.ratanaphoneshop.phoneshop.service.impl.BrandServiceImp;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {
	
	@Mock
	private BrandRepository brandRepository;
	
	private BrandService brandService;
	
	@BeforeEach
	public void setup(){
		brandService = new BrandServiceImp(brandRepository);
	}
	
	/*@Test
	public void testCreate() {
		//given 
		Brand brand = new Brand();
		brand.setName("Apple");
		brand.setId(1);
		//when 
		when(brandRepository.save(any(Brand.class))).thenReturn(brand);
		Brand brandreturn = brandService.create(brand);
		
		//then
		assertEquals(1,brandreturn.getId());
		assertEquals("Apple",brandreturn.getName());
	}
	*/
	@Test
	public void testCreate() {
		//given 
		Brand brand = new Brand();
		brand.setName("Apple");
		//when 
		brandService.create(brand);
		
		//then
		verify(brandRepository,times(1)).save(brand);	
//		verify(brandRepository,times(1)).delete(brand);	
	}
	@Test
	public void testgetByIdSuccess() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		brand.setId(1);
		
		//when
		when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
		Brand brandreturn = brandService.getById(1);
		
		//then
		assertEquals(1, brandreturn.getId());
		assertEquals("Apple", brandreturn.getName());
	}
	
	@Test
	public void testgetByIdThrow() { 
		// this test is using with assertThatThrowBy cuz of testing exception
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		brand.setId(1);
		
		//when
		when(brandRepository.findById(2)).thenReturn(Optional.empty());
		assertThatThrownBy( ()-> brandService.getById(2))
		.isInstanceOf(ResourceNotFoundException.class)
//		.hasMessage("Brand id = 2 not found");
//		.hasMessage("Brand id = %d not found".formatted(2));
		.hasMessageEndingWith("Brand id = %d not found".formatted(2));
		//then

	}
	@Test
	public void TestgetByname(){
		// given
		Brand brand = new Brand();
		brand.setId(1);
		brand.setName("App");
		List<Brand> brand1 = new ArrayList<Brand>();
		brand1.add(brand);
		
		// when
		when(brandRepository.findByNameContaining("Apple")).thenReturn(brand1);
		List<Brand> brands = brandService.getBrands("Apple");
		// then
		assertEquals(true, brands.contains(brand));
//		assertEquals("Apple", brands.);
	}
//	@Test
//	public void TestUpdatebyId() {
//		// given 
//		Brand brand = new Brand();
//		brand.setId(1);
//		brand.setName("Banana");
//		
//		// when
//		when(brandRepository.findById(1)).thenReturn(Optional.of(brand));
////		Brand getid = brandService.updateById(1, brand);
//		Brand brandreturn = brandService.getById(1);
//		brandreturn.setName("Apple");
//		Brand update = brandService.updateById(1, brandreturn);
//		System.out.println(update.getName());
//		// then 
////		verify(brandRepository,times(1)).save(update);
//	}
}
