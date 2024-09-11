package com.aeg.materiales.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Material")
public class Material {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "descripcion")
  private String descripcion;

  @Column(name = "tipo")
  private String tipo;

  @Column(name = "precio")
  private BigDecimal precio;

  @Column(name = "fecha_compra")
  private LocalDate fechaCompra;

  @Column(name = "fecha_venta")
  private LocalDate fechaVenta;

  @Column(name = "estado")
  private String estado;    // activo, disponible, asignado

  @Column(name = "ciudad")
  private long ciudad;

  //@ManyToOne
  //@JoinColumn(name="ciudad_id", nullable=false)
  //private Ciudad ciudad;  

  
  public Material() {}

	public Material(long id, String nombre, String descripcion, String tipo, BigDecimal precio, LocalDate fechaCompra,
			LocalDate fechaVenta, String estado, long ciudad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.precio = precio;
		this.fechaCompra = fechaCompra;
		this.fechaVenta = fechaVenta;
		this.estado = estado;
		this.ciudad = ciudad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}



	public LocalDate getFechaCompra() {
		return fechaCompra;
	}




	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}




	public LocalDate getFechaVenta() {
		return fechaVenta;
	}




	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}




	public String getEstado() {
		return estado;
	}




	public void setEstado(String estado) {
		this.estado = estado;
	}




	public long getCiudad() {
		return ciudad;
	}

	public void setCiudad(long ciudad) {
		this.ciudad = ciudad;
	}


	@Override
	public String toString() {
		return "Material [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + ", precio="
				+ precio + ", fechaCompra=" + fechaCompra + ", fechaVenta=" + fechaVenta + ", estado=" + estado + "]";
	}




}
