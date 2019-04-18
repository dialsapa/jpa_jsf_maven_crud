package com.myurl.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 							// se indica que es una ENTIDAD
@Table(name = "estudiantes") 		// el nombre de la tabla es "clientes" en la BD
public class Estudiante {
	@Id 							// se indica que este atributo es la llave principal de la tabla
	@GeneratedValue(strategy = GenerationType.IDENTITY) // se indica que el id es autoincrementable
	private Long id_estudiante;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	private String usuario;
	@Column
	private String clave;
	@Temporal(TemporalType.TIMESTAMP)		//se indica que se va a guardar una fecha con hora
	private Date fecha_registro;
	
	private List<Quiz> lstQuices;
	
	/**
	 * CONSTRUCTOR estudiante sin el Id
	 * 
	 * @param nombres
	 * @param apellidos
	 * @param usuario
	 * @param clave
	 */
	public Estudiante(String nombres, String apellidos, String usuario, String clave) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.clave = clave;
	}

	public Estudiante() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id_estudiante;
	}

	public void setId(Long id) {
		this.id_estudiante = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	

	/**
	 * @return the lstQuices
	 */
	public List<Quiz> getLstQuices() {
		return lstQuices;
	}

	/**
	 * @param lstQuices the lstQuices to set
	 */
	public void setLstQuices(List<Quiz> lstQuices) {
		this.lstQuices = lstQuices;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id_estudiante + ", nombres=" + nombres + ", apellidos=" + apellidos + ", usuario=" + usuario
				+ ", clave=" + clave + ", fecha_registro=" + fecha_registro + "]";
	}


	
	
	
	

}
