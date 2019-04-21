package com.myurl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.myurl.dao.MaestroDAO;
import com.myurl.model.Clase;
import com.myurl.model.Maestro;

@ManagedBean(name = "maestroBean") // nombre que se le dara al objeto desde las vistas
@SessionScoped
public class MaestroBean {

	@ManagedProperty(value = "#{seguridadBean.maestro}")
	private Maestro maestro;

	private List<Clase> clases;

	private Clase clase;

	@PostConstruct
	public void init() {
		// lista las clases del Maestro
		MaestroDAO maestroDAO = new MaestroDAO();
		clases = maestroDAO.buscarClasesPorMaestro(maestro);
	}

	public String nuevo() {
		Maestro c = new Maestro();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("maestro", c);
		return "/faces/nuevoMaestro.xhtml";
	}

	public String irCrudClase() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("clase", clase);
		return "/faces/crud_clase.xhtml";
	}

	public String guardar(Maestro maestro) {

		MaestroDAO maestroDAO = new MaestroDAO();
		maestroDAO.insertar(maestro);
		return "/faces/index.xhtml"; // aqui se pone la vista hacia donde dirigirse
	}

	/**
	 * Metodo que usa el DAO para obtener todos los Maestros
	 * 
	 * @return lista de todos los Maestros registrados
	 */
	public List<Maestro> obtenerMaestros() {
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

		// Se crea un contexto en donde se guardara el objeto maestro para
		// posteriormente enviarlo a la vista editar
		// tendra un alcance de session
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		// aqui le damos el alias del objeto y el objeto

		sessionMap.put("maestro", m);
		return "/faces/editarMaestro.xhtml";
	}

	public String editarClase(String nombreClase) {
		MaestroDAO maestroDAO = new MaestroDAO();
		List<Clase> clases = maestroDAO.buscarClasesPorMaestro(maestro);

		clase = buscarUnaClase(clases, nombreClase);

		System.out.println("******************** CLASE A EDITAR **********************");
		System.out.println(clase.getNombreClase());

		// Se crea un contexto en donde se guardara el objeto maestro para
		// posteriormente enviarlo a la vista editar
		// tendra un alcance de session
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		// aqui le damos el alias del objeto y el objeto

		sessionMap.put("clase", clase);
		return "/faces/crud_clase.xhtml";
	}

	private Clase buscarUnaClase(List<Clase> clases2, String nombreClase) {
		for (Clase c : clases2) {
			if (c.getNombreClase().equals(nombreClase))
			return c;
		}
		return null;
	}

	/**
	 * Medoto que actualiza los datos de un maestro
	 * 
	 * @param maestro que va a ser actualizado
	 * @return la pagina que se va a redireccionar
	 */

	public String actualizar() {
		MaestroDAO maestroDAO = new MaestroDAO();
		maestroDAO.editar(maestro);
		return "/faces/crud_Maestro.xhtml";
	}

	/**
	 * Metodo que busca y elimina un maestro
	 * 
	 * @param id del maestro a eliminar
	 * @return
	 */
	public String eliminar(Long id) {
		MaestroDAO maestroDAO = new MaestroDAO();
		maestroDAO.eliminarMaestro(id);
		System.out.println("Maestro eliminado con EXITO!!!");
		return "/faces/crud_Maestro.xhtml";
	}

	public void onRowSelect(SelectEvent event) {
		clase = (Clase) event.getObject();
		FacesMessage msg = new FacesMessage("Clase Seleccionada: " + String.valueOf(clase.getNombreClase()));
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void onRowUnselect(UnselectEvent event) {

		FacesMessage msg = new FacesMessage("Clase No seccionada: " + String.valueOf(clase.getNombreClase()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * @return the clases
	 */
	public List<Clase> getClases() {
		return clases;
	}

	/**
	 * @param clases the clases to set
	 */
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	/**
	 * @return the clase
	 */
	public Clase getClase() {
		return clase;
	}

	/**
	 * @param clase the clase to set
	 */
	public void setClase(Clase clase) {
		this.clase = clase;
	}

	/**
	 * @return the maestro
	 */
	public Maestro getMaestro() {
		return maestro;
	}

	/**
	 * @param maestro the maestro to set
	 */
	public void setMaestro(Maestro maestro) {
		this.maestro = maestro;
	}

}
