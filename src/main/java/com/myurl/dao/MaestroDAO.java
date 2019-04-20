package com.myurl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.myurl.model.Cliente;
import com.myurl.model.JPAUtil;
import com.myurl.model.Maestro;

public class MaestroDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	/**
	 * Metodo que usa la tecnologia Hibernate para insertar un Maestro en la BD
	 * 
	 * @param maestro
	 */
	public void insertar(Maestro maestro) {
		entity.getTransaction().begin();
		entity.persist(maestro);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para actualizar un Maestro en la BD
	 * 
	 * @param Maestro a editar
	 */
	public void editar(Maestro maestro) {
		entity.getTransaction().begin();
		entity.merge(maestro);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para buscar y retornar un Maestro en
	 * la BD, teniendo como criterio de cusqueda el id
	 * 
	 * @param id llave del Maestro a buscar
	 * @return Maestro cuyo id coincida con el mandado por parametro
	 */
	public Maestro buscarMaestro(Long id) {
		Maestro maestro = new Maestro();
		maestro = entity.find(Maestro.class, id); // busca un Maestro con llave igual a id
		return maestro;
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para buscar y retornar un Maestro en
	 * la BD, teniendo como criterio de busqueda el usuario y clave
	 * 
	 * @param id llave del Maestro a buscar
	 * @return Maestro cuyo id coincida con el mandado por parametro
	 */
	public Maestro buscarMaestroPorUsuarioClave(String usuario, String clave) {
		TypedQuery<Maestro> query = entity.createQuery("SELECT m FROM Maestro m WHERE m.usuario=:usua AND m.clave=:cla",
				Maestro.class);
		query.setParameter("usua", usuario);
		query.setParameter("cla", clave);
		if (query.getResultList().size() != 0)
			return query.getResultList().get(0);
		else
			return null;
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para obtener todos los Maestro de la
	 * BD
	 * 
	 * @return
	 */
	public List<Maestro> obtenerTodosLosMaestros() {
		List<Maestro> lstMaestros = new ArrayList<Maestro>();
		Query q = entity.createQuery("SELECT cli FROM Maestro cli"); // se usa el lenguaje JAQL. es parecido al SQL pero
																		// es gestionado por hibernate. Aqui la tabla se
																		// llama igual que la Entidad. "cli" es un alias
																		// que se usa solo para la consulta.
		lstMaestros = q.getResultList();
		return lstMaestros;
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para fuscar y eliminar un Maestro en
	 * la BD
	 * 
	 * @param id del Maestro a buscar y eliminar
	 */
	public void eliminarMaestro(Long id) {
		Maestro c = new Maestro();
		c = entity.find(Maestro.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();

	}

	public boolean validarPorPalabraSecreta(String usuario, String palabraSecreta) {
		TypedQuery<Maestro> query = entity
				.createQuery("SELECT u FROM Maestro u WHERE u.usuario=:usua AND u.palabraSecreta=:ps", Maestro.class);
		query.setParameter("usua", usuario);
		query.setParameter("ps", palabraSecreta);

		Maestro m = query.getSingleResult();

		if (m == null)
			return false;
		else
			return true;
	}

}
