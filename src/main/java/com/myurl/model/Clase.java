package com.myurl.model;

import java.util.List;

public class Clase {
	private String nombreClase;
	private List<Estudiante> lstEstudiantes;
	private List<Quiz> lstQuices;

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

}
