package com.myurl.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que crea un Test Quiz
 * 
 * @author ALEJANDRO
 *
 */
@Entity // se indica que es una ENTIDAD
@Table(name = "quices") // el nombre de la tabla es "clientes" en la BD

public class Quiz {
	@Id
	private Long id_quiz;

	@Column
	private String nombreQuiz;
	
	@Column
	private String codigoQuiz;
	
	@Column
	private int cantidadPreguntas;
	
	@Column
	private int nivelQuiz;
	
	@Temporal(TemporalType.TIMESTAMP) // se indica que se va a guardar una fecha con hora
	private Date fechaCreado;
	
	@Temporal(TemporalType.TIMESTAMP) // se indica que se va a guardar una fecha con hora
	private Date fechaAsignado;
	
	@Column
	private boolean aleatorio;
	
	@Column
	private int duracionQuiz;
	
	@Temporal(TemporalType.TIMESTAMP) // se indica que se va a guardar una fecha con hora
	private Date fechaLimite;
	
	@OneToMany(mappedBy = "quiz")
	private List<Pregunta> lstPreguntas;
	
	@ManyToOne
	private Clase clase;
	
	@ManyToMany
	private List<Estudiante> lstEstudiantes;

	public Quiz() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombreQuiz
	 * @param codigoQuiz
	 * @param cantidadPreguntas
	 * @param nivelQuiz
	 * @param fechaCreado
	 * @param fechaAsignado
	 * @param duracionQuiz
	 * @param fechaLimite
	 * @param lstPreguntas
	 */
	public Quiz(String nombreQuiz, String codigoQuiz, int cantidadPreguntas, int nivelQuiz, Date fechaCreado,
			Date fechaAsignado, int duracionQuiz, Date fechaLimite, List<Pregunta> lstPreguntas) {
		super();
		this.nombreQuiz = nombreQuiz;
		this.codigoQuiz = codigoQuiz;
		this.cantidadPreguntas = cantidadPreguntas;
		this.nivelQuiz = nivelQuiz;
		this.fechaCreado = fechaCreado;
		this.fechaAsignado = fechaAsignado;
		this.duracionQuiz = duracionQuiz;
		this.fechaLimite = fechaLimite;
		this.lstPreguntas = lstPreguntas;
		this.aleatorio = true;
	}

	/**
	 * @param nombreQuiz
	 * @param codigoQuiz
	 * @param cantidadPreguntas
	 * @param nivelQuiz
	 * @param fechaCreado
	 * @param fechaAsignado
	 * @param duracionQuiz
	 * @param fechaLimite
	 */
	public Quiz(String nombreQuiz, String codigoQuiz, int cantidadPreguntas, int nivelQuiz, Date fechaCreado,
			Date fechaAsignado, int duracionQuiz, Date fechaLimite) {
		super();
		this.nombreQuiz = nombreQuiz;
		this.codigoQuiz = codigoQuiz;
		this.cantidadPreguntas = cantidadPreguntas;
		this.nivelQuiz = nivelQuiz;
		this.fechaCreado = fechaCreado;
		this.fechaAsignado = fechaAsignado;
		this.duracionQuiz = duracionQuiz;
		this.fechaLimite = fechaLimite;
		this.aleatorio = true;
	}

	/**
	 * @param nombreQuiz
	 * @param codigoQuiz
	 * @param cantidadPreguntas
	 * @param nivelQuiz
	 * @param fechaCreado
	 * @param fechaAsignado
	 */
	public Quiz(String nombreQuiz, String codigoQuiz, int cantidadPreguntas, int nivelQuiz, Date fechaCreado,
			Date fechaAsignado) {
		super();
		this.nombreQuiz = nombreQuiz;
		this.codigoQuiz = codigoQuiz;
		this.cantidadPreguntas = cantidadPreguntas;
		this.nivelQuiz = nivelQuiz;
		this.fechaCreado = fechaCreado;
		this.fechaAsignado = fechaAsignado;
		this.aleatorio = true;
	}

	/**
	 * @return the nombreQuiz
	 */
	public String getNombreQuiz() {
		return nombreQuiz;
	}

	/**
	 * @param nombreQuiz the nombreQuiz to set
	 */
	public void setNombreQuiz(String nombreQuiz) {
		this.nombreQuiz = nombreQuiz;
	}

	/**
	 * @return the codigoQuiz
	 */
	public String getCodigoQuiz() {
		return codigoQuiz;
	}

	/**
	 * @param codigoQuiz the codigoQuiz to set
	 */
	public void setCodigoQuiz(String codigoQuiz) {
		this.codigoQuiz = codigoQuiz;
	}

	/**
	 * @return the cantidadPreguntas
	 */
	public int getCantidadPreguntas() {
		return cantidadPreguntas;
	}

	/**
	 * @param cantidadPreguntas the cantidadPreguntas to set
	 */
	public void setCantidadPreguntas(int cantidadPreguntas) {
		this.cantidadPreguntas = cantidadPreguntas;
	}

	/**
	 * @return the nivelQuiz
	 */
	public int getNivelQuiz() {
		return nivelQuiz;
	}

	/**
	 * @param nivelQuiz the nivelQuiz to set
	 */
	public void setNivelQuiz(int nivelQuiz) {
		this.nivelQuiz = nivelQuiz;
	}

	/**
	 * @return the fechaCreado
	 */
	public Date getFechaCreado() {
		return fechaCreado;
	}

	/**
	 * @param fechaCreado the fechaCreado to set
	 */
	public void setFechaCreado(Date fechaCreado) {
		this.fechaCreado = fechaCreado;
	}

	/**
	 * @return the fechaAsignado
	 */
	public Date getFechaAsignado() {
		return fechaAsignado;
	}

	/**
	 * @param fechaAsignado the fechaAsignado to set
	 */
	public void setFechaAsignado(Date fechaAsignado) {
		this.fechaAsignado = fechaAsignado;
	}

	/**
	 * @return the duracionQuiz
	 */
	public int getDuracionQuiz() {
		return duracionQuiz;
	}

	/**
	 * @param duracionQuiz the duracionQuiz to set
	 */
	public void setDuracionQuiz(int duracionQuiz) {
		this.duracionQuiz = duracionQuiz;
	}

	/**
	 * @return the fechaLimite
	 */
	public Date getFechaLimite() {
		return fechaLimite;
	}

	/**
	 * @param fechaLimite the fechaLimite to set
	 */
	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	/**
	 * @return the aleatorio
	 */
	public boolean isAleatorio() {
		return aleatorio;
	}

	/**
	 * @param aleatorio the aleatorio to set
	 */
	public void setAleatorio(boolean aleatorio) {
		this.aleatorio = aleatorio;
	}

	/**
	 * @return the lstPreguntas
	 */
	public List<Pregunta> getLstPreguntas() {
		return lstPreguntas;
	}

	/**
	 * @param lstPreguntas the lstPreguntas to set
	 */
	public void setLstPreguntas(List<Pregunta> lstPreguntas) {
		this.lstPreguntas = lstPreguntas;
	}

}
