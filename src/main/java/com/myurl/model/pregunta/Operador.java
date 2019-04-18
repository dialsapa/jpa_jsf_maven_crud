/**
 * 
 */
package com.myurl.model.pregunta;

/**
 * @author DIEGO ALEJANDRO SANCHEZ
 * 
 *
 */
public enum Operador {
	

	PRODUCTO("multiplicacion","×"),
	DIVISION("division","÷"),
	ADICION("suma","+"),
	SUSTRACCION("resta","-");
	
	private final String descripcion;
	private final String simbolo;
	
	private Operador(String descripcion, String simbolo) {
		this.descripcion = descripcion;
		this.simbolo = simbolo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the simbolo
	 */
	public String getSimbolo() {
		return simbolo;
	}
	
	

}
