package com.myurl.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.myurl.dao.MaestroDAO;
import com.myurl.model.Maestro;

@ManagedBean(name = "maestroBean")					//nombre que se le dara al objeto desde las vistas
@RequestScoped
public class MaestroBean {

	public String nuevo() {
		Maestro c = new Maestro();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("maestro", c);
		return "/faces/nuevoMaestro.xhtml";
	}

	public String guardar(Maestro maestro) {

		MaestroDAO maestroDAO = new MaestroDAO();
		maestroDAO.insertar(maestro);
		return "/faces/index.xhtml";		//aqui se pone la vista hacia donde dirigirse
	}

	/**
	 * Metodo que usa el DAO para obtener todos los Maestros
	 * 
	 * @return lista de todos los Maestros registrados
	 */
	public List<Maestro> obtenerMaestro() {
		MaestroDAO maestroDAO = new MaestroDAO();
		return maestroDAO.obtenerTodosLosMaestros();
	}

	/**
	 * Metodo que usa el DAO para buscar y editar un Maestro
	 * 
	 * @param id del Maestro a buscar y editar
	 * @return
	 */
	public String editar(Long id) {
		MaestroDAO maestroDAO = new MaestroDAO();
		Maestro m = new Maestro();
		m = maestroDAO.buscarMaestro(id);
		System.out.println("******************************************");
		System.out.println(m);
		
		//Se crea un contexto en donde se guardara el objeto maestro para posteriormente enviarlo a la vista editar
		//tendra un alcance de session
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//aqui le damos el alias del objeto y el objeto
		
		sessionMap.put("maestro", m);
		return "/faces/editarMaestro.xhtml";
	}
	
	/**
	 * Medoto que actualiza los datos de un maestro
	 * @param maestro que va a ser actualizado
	 * @return la pagina que se va a redireccionar
	 */

	public String actualizar(Maestro maestro) {
		MaestroDAO maestroDAO = new MaestroDAO();
		maestroDAO.editar(maestro);
		return "/faces/crud_Maestro.xhtml";
	}

	/**
	 * Metodo que busca y elimina un maestro
	 * @param id del maestro a eliminar
	 * @return
	 */
	public String eliminar(Long id) {
		MaestroDAO maestroDAO = new MaestroDAO();
		maestroDAO.eliminarMaestro(id);
		System.out.println("Maestro eliminado con EXITO!!!");
		return "/faces/crud_Maestro.xhtml";
	}

}
