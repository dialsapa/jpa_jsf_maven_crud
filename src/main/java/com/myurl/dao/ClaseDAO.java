package com.myurl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.myurl.model.JPAUtil;
import com.myurl.model.Maestro;
import com.myurl.model.Clase;
import com.myurl.model.Estudiante;

public class ClaseDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	/**
	 * Metodo que usa la tecnologia Hibernate para insertar un Clase en la BD
	 * 
	 * @param clase
	 */
	public void insertar(Clase clase) {
		entity.getTransaction().begin();
		entity.persist(clase);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para actualizar un Clase en la BD
	 * 
	 * @param Clase a editar
	 */
	public void editar(Clase clase) {
		entity.getTransaction().begin();
		entity.merge(clase);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para buscar y retornar un Clase en la
	 * BD, teniendo como criterio de cusqueda el id
	 * 
	 * @param id llave del Clase a buscar
	 * @return Clase cuyo id coincida con el mandado por parametro
	 */
	public Clase buscarClase(Long id) {
		Clase clase = new Clase();
		clase = entity.find(Clase.class, id); // busca un Clase con llave igual a id
		return clase;
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para obtener todos los Clase de la BD
	 * 
	 * @return
	 */
	public List<Clase> obtenerTodasLasClases() {
		List<Clase> lstClases = new ArrayList<Clase>();
		Query q = entity.createQuery("SELECT cli FROM Clase cli"); // se usa el lenguaje JAQL. es parecido al SQL pero
																	// es gestionado por hibernate. Aqui la tabla se
																	// llama igual que la Entidad. "cli" es un alias
																	// que se usa solo para la consulta.
		lstClases = q.getResultList();
		return lstClases;
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para fuscar y eliminar un Clase en la
	 * BD
	 * 
	 * @param id del Clase a buscar y eliminar
	 */
	public void eliminarClase(Long id) {
		Clase c = new Clase();
		c = entity.find(Clase.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();

	}

	public List<Estudiante> buscarEstudiantesPorClase(Clase clase) {

		TypedQuery<Estudiante> query = entity.createQuery("SELECT os FROM Estudiante os WHERE os.clase.nombreClase=:id",
				Estudiante.class);
		query.setParameter("id", clase.getNombreClase());

		return query.getResultList();
	}

}
