package com.myurl.model.pregunta;

import com.myurl.model.Pregunta;

public class PreguntaFraccionAritmetica extends Pregunta {

	private Fraccion fraccion1;
	private Fraccion fraccion2;
	private Operador operador;
	private Fraccion solucion;
	private Fraccion respuesta;

	/**
	 * @param fraccion1
	 * @param fraccion2
	 * @param operador
	 * @param solucion
	 */
	public PreguntaFraccionAritmetica(Fraccion fraccion1, Fraccion fraccion2, Operador operador, Fraccion solucion) {
		super();
		this.fraccion1 = fraccion1;
		this.fraccion2 = fraccion2;
		this.operador = operador;
		this.solucion = solucion;
	}

	/**
	 * @return the fraccion1
	 */
	public Fraccion getFraccion1() {
		return fraccion1;
	}

	/**
	 * @param fraccion1 the fraccion1 to set
	 */
	public void setFraccion1(Fraccion fraccion1) {
		this.fraccion1 = fraccion1;
	}

	/**
	 * @return the fraccion2
	 */
	public Fraccion getFraccion2() {
		return fraccion2;
	}

	/**
	 * @param fraccion2 the fraccion2 to set
	 */
	public void setFraccion2(Fraccion fraccion2) {
		this.fraccion2 = fraccion2;
	}

	/**
	 * @return the operador
	 */
	public Operador getOperador() {
		return operador;
	}

	/**
	 * @param operador the operador to set
	 */
	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	/**
	 * @return the solucion
	 */
	public Fraccion getSolucion() {
		return solucion;
	}

	/**
	 * @param solucion the solucion to set
	 */
	public void setSolucion(Fraccion solucion) {
		this.solucion = solucion;
	}

	/**
	 * @return the respuesta
	 */
	public Fraccion getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(Fraccion respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "PreguntaFracciones: " + fraccion1 + operador.getSimbolo() + fraccion2 + " = " + solucion + " : "
				+ respuesta;
	}
}
