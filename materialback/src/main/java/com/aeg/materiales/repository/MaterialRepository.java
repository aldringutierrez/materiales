package com.aeg.materiales.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aeg.materiales.entidades.Material;

public interface MaterialRepository  extends JpaRepository<Material, Long> {
  List<Material> findByNombre(String nombre);
}
