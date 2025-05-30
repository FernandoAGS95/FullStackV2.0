package com.materialEducativo.micro.materialEducativo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.materialEducativo.micro.materialEducativo.model.Material;
import com.materialEducativo.micro.materialEducativo.repository.MaterialRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MaterialService {
    @Autowired
    private MaterialRepository materialrepository;

    public List<Material> findAll() {
        return materialrepository.findAll();
    }

    public Material findById(Long id) {
        return materialrepository.findById(id).get();
    }

    public Material save(Material material) {
        return materialrepository.save(material);
    }

    public void delete(Long id) {
        materialrepository.deleteById(id);
    }

}
