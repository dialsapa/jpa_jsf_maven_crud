package com.myurl.model;

public class TerminoFraccionario {
	private Long numerador;
	private Long denominador;
	public TerminoFraccionario(Long numerador, Long denominador) {
		super();
		this.numerador = numerador;
		this.denominador = denominador;
	}
	public Long getNumerador() {
		return numerador;
	}
	public void setNumerador(Long numerador) {
		this.numerador = numerador;
	}
	public Long getDenominador() {
		return denominador;
	}
	public void setDenominador(Long denominador) {
		this.denominador = denominador;
	}
	@Override
	public String toString() {
		return "TerminoFraccionario [ " + numerador + " / " + denominador + " ]";
	}
	
	

}
