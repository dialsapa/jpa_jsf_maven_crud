package com.myurl.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity								//se indica que es una ENTIDAD
@Table(name="clases")				//el nombre de la tabla es "clientes" en la BD
public class Clase {
	@Id
	private String nombreClase;
	
	@OneToMany(mappedBy = "clase")
	private List<Estudiante> lstEstudiantes;
	
	@OneToMany(mappedBy = "clase")
	private List<Quiz> lstQuices;
	
	@ManyToOne
	private Maestro maestro;

	public Clase() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombreClase
	 * @param lstEstudiantes
	 */
	public Clase(String nombreClase, List<Estudiante> lstEstudiantes) {
		super();
		this.nombreClase = nombreClase;
		this.lstEstudiantes = lstEstudiantes;
	}

	/**
	 * @param nombreClase
	 * @param lstEstudiantes
	 * @param lstQuices
	 */
	public Clase(String nombreClase, List<Estudiante> lstEstudiantes, List<Quiz> lstQuices) {
		super();
		this.nombreClase = nombreClase;
		this.lstEstudiantes = lstEstudiantes;
		this.lstQuices = lstQuices;
	}

	/**
	 * @return the nombreClase
	 */
	public String getNombreClase() {
		return nombreClase;
	}

	/**
	 * @param nombreClase the nombreClase to set
	 */
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	/**
	 * @return the lstEstudiantes
	 */
	public List<Estudiante> getLstEstudiantes() {
		return lstEstudiantes;
	}

	/**
	 * @param lstEstudiantes the lstEstudiantes to set
	 */
	public void setLstEstudiantes(List<Estudiante> lstEstudiantes) {
		this.lstEstudiantes = lstEstudiantes;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lstEstudiantes == null) ? 0 : lstEstudiantes.hashCode());
		result = prime * result + ((lstQuices == null) ? 0 : lstQuices.hashCode());
		result = prime * result + ((maestro == null) ? 0 : maestro.hashCode());
		result = prime * result + ((nombreClase == null) ? 0 : nombreClase.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clase other = (Clase) obj;
		if (lstEstudiantes == null) {
			if (other.lstEstudiantes != null)
				return false;
		} else if (!lstEstudiantes.equals(other.lstEstudiantes))
			return false;
		if (lstQuices == null) {
			if (other.lstQuices != null)
				return false;
		} else if (!lstQuices.equals(other.lstQuices))
			return false;
		if (maestro == null) {
			if (other.maestro != null)
				return false;
		} else if (!maestro.equals(other.maestro))
			return false;
		if (nombreClase == null) {
			if (other.nombreClase != null)
				return false;
		} else if (!nombreClase.equals(other.nombreClase))
			return false;
		return true;
	}

}
