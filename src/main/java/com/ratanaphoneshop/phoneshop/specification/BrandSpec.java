package com.ratanaphoneshop.phoneshop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.ratanaphoneshop.phoneshop.entity.Brand;

import lombok.Data;

@Data
public class BrandSpec implements Specification<Brand>{
	
	private final BrandFilter brandFilter;
	List<Predicate> predicates = new ArrayList<>();
	
	@Override
	public Predicate toPredicate(Root<Brand> brand, CriteriaQuery<?> query, CriteriaBuilder cd) {
		if(brandFilter.getName() != null) {
//			Predicate name = brand.get("name").in(brandFilter.getName());
//			predicates.add(name);
			Predicate name = cd.like(cd.upper(brand.get("name")), "%"+ brandFilter.getName().toUpperCase() + "%");
			predicates.add(name);
		}
		
		if(brandFilter.getId() != null) {
			Predicate id = brand.get("id").in(brandFilter.getId());
			predicates.add(id);
		}
//		cd.and(predicates.toArray(new Predicate[0])) // 
		return cd.and(predicates.toArray(Predicate[]::new)); // java version 8
	}
}
