package com.materialEducativo.micro.materialEducativo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.materialEducativo.micro.materialEducativo.model.Material; 

public interface MaterialRepository extends JpaRepository<Material, Long> {
}


