package com.ratanaphoneshop.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ratanaphoneshop.phoneshop.entity.Brand;

@Repository // new version no need to use 
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
