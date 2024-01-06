package com.ratanaphoneshop.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratanaphoneshop.phoneshop.entity.Model;

public interface ModelReposity extends JpaRepository<Model, Integer>{
	
}
