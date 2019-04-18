package com.myurl.model;

import java.util.List;

public class Maestro {
	private String nombres;
	private String apellidos;
	private String email;
	private String palabraSecreta;
	private String usuario;
	private String clave;
	private List<Clase> lstClases;

	public Maestro() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombres
	 * @param apellidos
	 * @param email
	 * @param palabraSecreta
	 * @param usuario
	 * @param clave
	 */
	public Maestro(String nombres, String apellidos, String email, String palabraSecreta, String usuario,
			String clave) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.palabraSecreta = palabraSecreta;
		this.usuario = usuario;
		this.clave = clave;
	}

	/**
	 * @param nombres
	 * @param apellidos
	 * @param email
	 * @param palabraSecreta
	 * @param usuario
	 * @param clave
	 * @param lstClases
	 */
	public Maestro(String nombres, String apellidos, String email, String palabraSecreta, String usuario, String clave,
			List<Clase> lstClases) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.palabraSecreta = palabraSecreta;
		this.usuario = usuario;
		this.clave = clave;
		this.lstClases = lstClases;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the palabraSecreta
	 */
	public String getPalabraSecreta() {
		return palabraSecreta;
	}

	/**
	 * @param palabraSecreta the palabraSecreta to set
	 */
	public void setPalabraSecreta(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the lstClases
	 */
	public List<Clase> getLstClases() {
		return lstClases;
	}

	/**
	 * @param lstClases the lstClases to set
	 */
	public void setLstClases(List<Clase> lstClases) {
		this.lstClases = lstClases;
	}

	@Override
	public String toString() {
		return "Maestro [nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email + ", usuario=" + usuario
				+ "]";
	}

	
}
