package com.myurl.model.pregunta;

import com.myurl.model.Pregunta;

/**
 * Esta clase modela preguntas cuyo enunciado es real o fraccionario y solucion
 * (respuesta) puede ser real o fraccionario. Por ejemplo: simplificacion a
 * terminos reducidos de fraccionarios, pasar de decimal a fraccionario, pasar
 * de fraccionario a decimal, pasar de porcentaje a decimal y visceversa.
 * 
 * @author ALEJANDRO
 *
 */
public class PreguntaFraccionSimple extends Pregunta {
	private Fraccion preguntaFraccion;
	private double preguntaReal;

	private Fraccion solucionFraccion;
	private double solucionReal;

	private double respuestaReal;
	private Fraccion respuestaFraccion;

	/**
	 * Constructor para pregunta Fraccionario con solucion Fraccionario
	 * 
	 * @param preguntaFraccion
	 * @param solucionFraccion
	 * @param respuestaFraccion
	 */
	public PreguntaFraccionSimple(Fraccion preguntaFraccion, Fraccion solucionFraccion, Fraccion respuestaFraccion) {
		super();
		this.preguntaFraccion = preguntaFraccion;
		this.solucionFraccion = solucionFraccion;
		this.respuestaFraccion = respuestaFraccion;
	}

	/**
	 * Constructor para pregunta Fraccionario con solucion Real
	 * 
	 * @param preguntaFraccion
	 * @param solucionReal
	 * @param respuestaReal
	 */
	public PreguntaFraccionSimple(Fraccion preguntaFraccion, double solucionReal, double respuestaReal) {
		super();
		this.preguntaFraccion = preguntaFraccion;
		this.solucionReal = solucionReal;
		this.respuestaReal = respuestaReal;
	}

	/**
	 * Constructor para pregunta Real con solucion Fraccionario
	 * 
	 * @param preguntaReal
	 * @param solucionFraccion
	 * @param respuestaFraccion
	 */
	public PreguntaFraccionSimple(double preguntaReal, Fraccion solucionFraccion, Fraccion respuestaFraccion) {
		super();
		this.preguntaReal = preguntaReal;
		this.solucionFraccion = solucionFraccion;
		this.respuestaFraccion = respuestaFraccion;
	}

	/**
	 * 
	 * Constructor para pregunta Real con solucion Real
	 * 
	 * @param preguntaReal
	 * @param solucionReal
	 * @param respuestaReal
	 */
	public PreguntaFraccionSimple(double preguntaReal, double solucionReal, double respuestaReal) {
		super();
		this.preguntaReal = preguntaReal;
		this.solucionReal = solucionReal;
		this.respuestaReal = respuestaReal;
	}

	/**
	 * @return the preguntaFraccion
	 */
	public Fraccion getPreguntaFraccion() {
		return preguntaFraccion;
	}

	/**
	 * @param preguntaFraccion the preguntaFraccion to set
	 */
	public void setPreguntaFraccion(Fraccion preguntaFraccion) {
		this.preguntaFraccion = preguntaFraccion;
	}

	/**
	 * @return the preguntaReal
	 */
	public double getPreguntaReal() {
		return preguntaReal;
	}

	/**
	 * @param preguntaReal the preguntaReal to set
	 */
	public void setPreguntaReal(double preguntaReal) {
		this.preguntaReal = preguntaReal;
	}

	/**
	 * @return the solucionFraccion
	 */
	public Fraccion getSolucionFraccion() {
		return solucionFraccion;
	}

	/**
	 * @param solucionFraccion the solucionFraccion to set
	 */
	public void setSolucionFraccion(Fraccion solucionFraccion) {
		this.solucionFraccion = solucionFraccion;
	}

	/**
	 * @return the solucionReal
	 */
	public double getSolucionReal() {
		return solucionReal;
	}

	/**
	 * @param solucionReal the solucionReal to set
	 */
	public void setSolucionReal(double solucionReal) {
		this.solucionReal = solucionReal;
	}

	/**
	 * @return the respuestaReal
	 */
	public double getRespuestaReal() {
		return respuestaReal;
	}

	/**
	 * @param respuestaReal the respuestaReal to set
	 */
	public void setRespuestaReal(double respuestaReal) {
		this.respuestaReal = respuestaReal;
	}

	/**
	 * @return the respuestaFraccion
	 */
	public Fraccion getRespuestaFraccion() {
		return respuestaFraccion;
	}

	/**
	 * @param respuestaFraccion the respuestaFraccion to set
	 */
	public void setRespuestaFraccion(Fraccion respuestaFraccion) {
		this.respuestaFraccion = respuestaFraccion;
	}

}
