package com.myurl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.myurl.model.Estudiante;
import com.myurl.model.JPAUtil;

public class EstudianteDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	/**
	 * Metodo que usa la tecnologia Hibernate para insertar un estudiante en la BD
	 * 
	 * @param e
	 */
	public void insertar(Estudiante estudiante) {
		entity.getTransaction().begin();
		entity.persist(estudiante);
		entity.getTransaction().commit();
	}
	
	/**
	 * Metodo que usa la tecnologia Hibernate para actualizar un Estudiante en la BD
	 * 
	 * @param estudiante
	 */
	public void editar(Estudiante estudiante) {
		entity.getTransaction().begin();
		entity.merge(estudiante);
		entity.getTransaction().commit();
		
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para buscar y retornar un Estudiante en
	 * la BD, teniendo como criterio de cusqueda el id
	 * 
	 * @param id llave del Estudiante a buscar
	 * @return Estudiante cuyo id coincida con el mandado por parametro
	 */
	public Estudiante buscarEstudiante(Long id) {
		Estudiante c = new Estudiante();
		c = entity.find(Estudiante.class, id); 	// busca un Cliente con llave igual a id
		return c;
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para obtener todos los Estudiantes de la
	 * BD
	 * 
	 * @return
	 */
	public List<Estudiante> obtenerTodosLosEstudiantes() {
		List<Estudiante> lstEstudiante = new ArrayList<Estudiante>();
		Query q = entity.createQuery("SELECT e FROM Estudiante e"); // se usa el lenguaje JAQL. es parecido al SQL pero
																		// es gestionado por hibernate. Aqui la tabla se
																		// llama igual que la Entidad. "cli" es un alias
																		// que se usa solo para la consulta.
		lstEstudiante = q.getResultList();
		return lstEstudiante;
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para fuscar y eliminar un Estudiante en
	 * la BD
	 * 
	 * @param id del Estudiante a buscar y eliminar
	 */
	public void eliminarEstudiante(Long id) {
		Estudiante estudiante = new Estudiante();
		estudiante = entity.find(Estudiante.class, id);
		entity.getTransaction().begin();
		entity.remove(estudiante);
		entity.getTransaction().commit();

	}

}
