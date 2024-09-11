package com.aeg.materiales.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aeg.materiales.entidades.Material;
import com.aeg.materiales.service.MaterialService;


@CrossOrigin(origins = {"localhost:4200","*"})
@RestController
@RequestMapping("/api")
public class MaterialController {
	
	@Autowired
	MaterialService materialService;
	
	@GetMapping("/material")
	public ResponseEntity<List<Material>> getAllMaterials(@RequestParam(required = false) String nombre) {
		System.out.println("/material");
		try {
			List<Material> materiales = materialService.getAllMaterials(nombre);

			if (materiales.isEmpty()) {
				System.out.println("/items empty");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			System.out.println("/items size "+materiales.size());

			return new ResponseEntity<>(materiales, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("/items exception");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/material/{id}")
	public ResponseEntity<Material> getMaterialById(@PathVariable("id") long id) {
		System.out.println("/material/id");
		try {
			Optional<Material> materialData = materialService.getMaterialById(id);
			if (materialData.isPresent()) {
				return new ResponseEntity<>(materialData.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.println("/items exception");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = {"localhost:4200","*"})
	@PostMapping("/material")
	public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
		System.out.println("post /material");
		try {
			Material material2 = materialService.createMaterial(material);
			return new ResponseEntity<>(material2, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/material/{id}")
	public ResponseEntity<Material> updateMaterial(@PathVariable("id") long id, @RequestBody Material material) {
		System.out.println("/items/id put");
		Material material2 = materialService.editar(id,material);

		if (material2!=null) {
			return new ResponseEntity<>(material2, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/material/{id}")
	public ResponseEntity<HttpStatus> deleteMaterial(@PathVariable("id") long id) {
			if (materialService.deleteMaterial(id))
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}


}
