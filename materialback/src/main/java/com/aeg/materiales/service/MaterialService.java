package com.aeg.materiales.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeg.materiales.entidades.Material;
import com.aeg.materiales.repository.MaterialRepository;

@Service
public class MaterialService {

	@Autowired
	MaterialRepository materialRepository;

	public List<Material> getAllMaterials(String nombre) {
		System.out.println("getAllMaterials 0");
		try {
			System.out.println("getAllMaterials 1");
			List<Material> materiales = new ArrayList<Material>();
			System.out.println("getAllMaterials 2");
			if (nombre == null) {
				System.out.println("getAllMaterials 3");
				materialRepository.findAll().forEach(materiales::add);
			}
			else {
				materialRepository.findByNombre(nombre).forEach(materiales::add);
				System.out.println("getAllMaterials 4");
			}
			return materiales;
		} catch (Exception e) {
			System.out.println("getall exc 5"+e.getMessage());
			return null;
		}
	}

	public Optional<Material> getMaterialById(long id) {
		Optional<Material> material = materialRepository.findById(id);
		return material;

	}

	public Material createMaterial(Material material) {
		try {
			Material material2 = materialRepository.save(material);
			return material2;
		} catch (Exception e) {
			return null;
		}
	}

	public Material editar( long id, Material material) {
		System.out.println("/editar");
		Optional<Material> materialData = materialRepository.findById(id);
		if (materialData.isPresent()) {
			Material _material = materialData.get();
			_material.setNombre(material.getNombre());
			_material.setDescripcion(material.getDescripcion());
			_material.setTipo(material.getTipo());
			_material.setPrecio(material.getPrecio());
			return materialRepository.save(_material);
		} else {
			return null;
		}
	}

	public boolean deleteMaterial(long id) {
		try {
			materialRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


}



