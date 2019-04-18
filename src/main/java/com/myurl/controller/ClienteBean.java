package com.myurl.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.myurl.dao.ClienteDAO;
import com.myurl.model.Cliente;

@ManagedBean(name = "clienteBean")					//nombre que se le dara al objeto desde las vistas
@RequestScoped
public class ClienteBean {

	public String nuevo() {
		Cliente c = new Cliente();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("cliente", c);
		return "/faces/nuevo.xhtml";
	}

	public String guardar(Cliente cliente) {
		// guarda la fecha de registro
		Date fechaActual = new Date();
		cliente.setFregistro(new java.sql.Date(fechaActual.getTime()));

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.insertar(cliente);
		return "/faces/index.xhtml";		//aqui se pone la vista hacia donde dirigirse
	}

	/**
	 * Metodo que usa el DAO para obtener todos los clientes
	 * 
	 * @return lista de todos los clientes registrados
	 */
	public List<Cliente> obtenerClientes() {
		ClienteDAO clienteDAO = new ClienteDAO();
		return clienteDAO.obtenerTodosLosClientes();
	}

	/**
	 * Metodo que usa el DAO para buscar y editar un cliente
	 * 
	 * @param id del cliente a buscar y editar
	 * @return
	 */
	public String editar(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente c = new Cliente();
		c = clienteDAO.buscarCliente(id);
		System.out.println("******************************************");
		System.out.println(c);
		
		//Se crea un contexto en donde se guardara el objeto cliente para posteriormente enviarlo a la vista editar
		//tendra un alcance de session
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//aqui le damos el alias del objeto y el objeto
		
		sessionMap.put("cliente", c);
		return "/faces/editar.xhtml";
	}
	
	/**
	 * Medoto que actualiza los datos de un cliente
	 * @param cliente que va a ser actualizado
	 * @return la pagina que se va a redireccionar
	 */

	public String actualizar(Cliente cliente) {
		// guarda la fecha de actualizacion
		Date fechaActual = new Date();
		cliente.setFactualizar(new java.sql.Date(fechaActual.getTime()));

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.editar(cliente);
		return "/faces/index.xhtml";
	}

	/**
	 * Metodo que busca y elimina un cliente
	 * @param id del cliente a eliminar
	 * @return
	 */
	public String eliminar(Long id) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.eliminarCliente(id);
		System.out.println("Cliente eliminado con EXITO!!!");
		return "/faces/index.xhtml";
	}

}
