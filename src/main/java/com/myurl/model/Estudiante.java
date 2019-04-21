package com.myurl.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 							// se indica que es una ENTIDAD
@Table(name = "estudiantes") 		// el nombre de la tabla es "clientes" en la BD
public class Estudiante implements Serializable{
	
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
	
	@ManyToOne
	private Clase clase;
	
	@ManyToMany(mappedBy = "lstEstudiantes")	//se crea la relacion muchos a muchos con la Clase
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((clase == null) ? 0 : clase.hashCode());
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((fecha_registro == null) ? 0 : fecha_registro.hashCode());
		result = prime * result + ((id_estudiante == null) ? 0 : id_estudiante.hashCode());
		result = prime * result + ((lstQuices == null) ? 0 : lstQuices.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
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
		Estudiante other = (Estudiante) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (clase == null) {
			if (other.clase != null)
				return false;
		} else if (!clase.equals(other.clase))
			return false;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (fecha_registro == null) {
			if (other.fecha_registro != null)
				return false;
		} else if (!fecha_registro.equals(other.fecha_registro))
			return false;
		if (id_estudiante == null) {
			if (other.id_estudiante != null)
				return false;
		} else if (!id_estudiante.equals(other.id_estudiante))
			return false;
		if (lstQuices == null) {
			if (other.lstQuices != null)
				return false;
		} else if (!lstQuices.equals(other.lstQuices))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}


	
	
	
	

}
