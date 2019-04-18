package com.myurl.model;

public class Pregunta {
	private int id_pregunta;
	private String mensajePregunta;
	private boolean esCorrecta;
	private int valorPregunta;

	public Pregunta() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param mensajePregunta
	 * @param valorPregunta
	 */
	public Pregunta(String mensajePregunta, int valorPregunta) {
		super();
		this.mensajePregunta = mensajePregunta;
		this.esCorrecta = false;
		this.valorPregunta = valorPregunta;
	}


	/**
	 * @return the mensajePregunta
	 */
	public String getMensajePregunta() {
		return mensajePregunta;
	}

	/**
	 * @param mensajePregunta the mensajePregunta to set
	 */
	public void setMensajePregunta(String mensajePregunta) {
		this.mensajePregunta = mensajePregunta;
	}

	/**
	 * @return the valorPregunta
	 */
	public int getValorPregunta() {
		return valorPregunta;
	}

	/**
	 * @param valorPregunta the valorPregunta to set
	 */
	public void setValorPregunta(int valorPregunta) {
		this.valorPregunta = valorPregunta;
	}

	/**
	 * @return the esCorrecta
	 */
	public boolean isEsCorrecta() {
		return esCorrecta;
	}

	/**
	 * @param esCorrecta the esCorrecta to set
	 */
	public void setEsCorrecta(boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
	}

}
