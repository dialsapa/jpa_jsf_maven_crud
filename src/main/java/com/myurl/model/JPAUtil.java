package com.myurl.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * Clase que contiene el POOL de conexion con la Base de Datos. Las propiedades son tomadas del archivo persistence.xml
 * @author ALEJANDRO
 *
 */
public class JPAUtil {

	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE"; //se indica que las propiedades se toman del archivo con el nombre "PERSISTENCE" que esta en persistence.xml
	private static EntityManagerFactory factory;		//objeto que tiene las propiedades de la conexion con la BD

	/**
	 * Se crea la conexion con el archivo persistence.xml que contiene los datos de la conexion con la BD
	 * 
	 * @return
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory==null) {
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return factory;				
	}
	
	/**
	 * Metodo que se desconecta de la BD y del archivo persistence.xml
	 */
	public static void shutdown() {
		if (factory!=null) {
			factory.close();
		}		
}
}
