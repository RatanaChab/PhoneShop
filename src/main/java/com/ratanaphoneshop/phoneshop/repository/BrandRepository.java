package com.ratanaphoneshop.phoneshop.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ratanaphoneshop.phoneshop.entity.Brand;

@Repository // new version no need to create anotation
public interface BrandRepository extends JpaRepository<Brand, Integer>,JpaSpecificationExecutor<Brand>{
	List<Brand> findByNameLike(String name);
	List<Brand> findByNameContaining(String name);
}
