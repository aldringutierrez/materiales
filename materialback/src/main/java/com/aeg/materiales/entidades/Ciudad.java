package com.aeg.materiales.entidades;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ciudad")
public class Ciudad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "departamento_id")
	private String departamentoId;
	
	
  @OneToMany(mappedBy="ciudad")
  private Set<Material> materiales;

  //@ManyToOne
  //@JoinColumn(name="departamento_id", nullable=false)
  //private Departamento departamento;    

}
