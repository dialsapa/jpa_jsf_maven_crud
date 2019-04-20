package com.myurl.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity								//se indica que es una ENTIDAD
@Table(name="maestros")	
public class Maestro {
	@Id
	private Long id_maestro;
	
	@Column
	private String nombres;
	
	@Column
	private String apellidos;
	
	@Column
	private String email;
	
	@Column
	private String palabraSecreta;
	
	@Column
	private String usuario;
	
	@Column
	private String clave;
	
	@OneToMany(mappedBy = "maestro")
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
	 * @return the id_maestro
	 */
	public Long getId_maestro() {
		return id_maestro;
	}

	/**
	 * @param id_maestro the id_maestro to set
	 */
	public void setId_maestro(Long id_maestro) {
		this.id_maestro = id_maestro;
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
		return "Maestro [id_maestro=" + id_maestro + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email="
				+ email + ", palabraSecreta=" + palabraSecreta + ", usuario=" + usuario + ", clave=" + clave + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id_maestro == null) ? 0 : id_maestro.hashCode());
		result = prime * result + ((lstClases == null) ? 0 : lstClases.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
		result = prime * result + ((palabraSecreta == null) ? 0 : palabraSecreta.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Maestro other = (Maestro) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_maestro == null) {
			if (other.id_maestro != null)
				return false;
		} else if (!id_maestro.equals(other.id_maestro))
			return false;
		if (lstClases == null) {
			if (other.lstClases != null)
				return false;
		} else if (!lstClases.equals(other.lstClases))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		if (palabraSecreta == null) {
			if (other.palabraSecreta != null)
				return false;
		} else if (!palabraSecreta.equals(other.palabraSecreta))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}



	
}
