package com.myurl.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.myurl.model.Cliente;
import com.myurl.model.JPAUtil;

public class ClienteDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();

	/**
	 * Metodo que usa la tecnologia Hibernate para insertar un cliente en la BD
	 * 
	 * @param c
	 */
	public void insertar(Cliente c) {
		entity.getTransaction().begin();
		entity.persist(c);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para actualizar un cliente en la BD
	 * 
	 * @param c
	 */
	public void editar(Cliente c) {
		entity.getTransaction().begin();
		entity.merge(c);
		entity.getTransaction().commit();
		// JPAUtil.shutdown();
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para buscar y retornar un cliente en
	 * la BD, teniendo como criterio de cusqueda el id
	 * 
	 * @param id llave del cliente a buscar
	 * @return cliente cuyo id coincida con el mandado por parametro
	 */
	public Cliente buscarCliente(Long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id); // busca un Cliente con llave igual a id
		return c;
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para buscar y retornar un cliente en
	 * la BD, teniendo como criterio de cusqueda el id
	 * 
	 * @param id llave del cliente a buscar
	 * @return cliente cuyo id coincida con el mandado por parametro
	 */
	public Cliente buscarClientePorUsuarioClave(String usuario, String clave) {
		TypedQuery<Cliente> query = entity
				.createQuery(
						"SELECT u FROM Cliente u WHERE u.nombre=:usua AND u.apellido=:cla",
						Cliente.class);
		query.setParameter("usua", usuario);
		query.setParameter("cla", clave);

		return query.getSingleResult();
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para obtener todos los clientes de la
	 * BD
	 * 
	 * @return
	 */
	public List<Cliente> obtenerTodosLosClientes() {
		List<Cliente> lstCLientes = new ArrayList<Cliente>();
		Query q = entity.createQuery("SELECT cli FROM Cliente cli"); // se usa el lenguaje JAQL. es parecido al SQL pero
																		// es gestionado por hibernate. Aqui la tabla se
																		// llama igual que la Entidad. "cli" es un alias
																		// que se usa solo para la consulta.
		lstCLientes = q.getResultList();
		return lstCLientes;
	}

	/**
	 * Metodo que usa la tecnologia Hibernate para fuscar y eliminar un Cliente en
	 * la BD
	 * 
	 * @param id del CLiente a buscar y eliminar
	 */
	public void eliminarCliente(Long id) {
		Cliente c = new Cliente();
		c = entity.find(Cliente.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();

	}

}
