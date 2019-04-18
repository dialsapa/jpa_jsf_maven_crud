package com.myurl.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.myurl.dao.EstudianteDAO;
import com.myurl.model.Estudiante;

@ManagedBean(name = "estudianteBean")					//nombre que se le dara al objeto desde las vistas
@RequestScoped
public class EstudianteBean {
	
	public String guardar(Estudiante estudiante) {
		// guarda la fecha de registro
		Date fechaActual = new Date();
		estudiante.setFecha_registro(new java.sql.Date(fechaActual.getTime()));

		EstudianteDAO estudianteDAO = new EstudianteDAO();
		estudianteDAO.insertar(estudiante);
		return "/faces/index.xhtml";		//aqui se pone la vista hacia donde dirigirse
	}

	/**
	 * Metodo que usa el DAO para obtener todos los Estudiantes
	 * 
	 * @return lista de todos los Estudiantes registrados
	 */
	public List<Estudiante> obtenerEstudiantes() {
		EstudianteDAO estudianteDAO = new EstudianteDAO();
		return estudianteDAO.obtenerTodosLosEstudiantes();
	}

	/**
	 * Metodo que usa el DAO para buscar y editar un Estudiante
	 * 
	 * @param id del Estudiante a buscar y editar
	 * @return
	 */
	public String editar(Long id) {
		EstudianteDAO clienteDAO = new EstudianteDAO();
		Estudiante estudiante = new Estudiante();
		estudiante = clienteDAO.buscarEstudiante(id);
		System.out.println("******************************************");
		System.out.println(estudiante);
		
		//Se crea un contexto en donde se guardara el objeto cliente para posteriormente enviarlo a la vista editar
		//tendra un alcance de session
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//aqui le damos el alias del objeto y el objeto
		
		sessionMap.put("estudiante", estudiante);
		return "/faces/editar.xhtml";
	}
	
	/**
	 * Medoto que actualiza los datos de un Estudiante
	 * @param e que va a ser actualizado
	 * @return la pagina que se va a redireccionar
	 */

	public String actualizar(Estudiante e) {
		// guarda la fecha de actualizacion
		Date fechaActual = new Date();

		EstudianteDAO estudianteDAO = new EstudianteDAO();
		estudianteDAO.editar(e);
		return "/faces/index.xhtml";
	}

	/**
	 * Metodo que busca y elimina un Estudiante
	 * @param id del Estudiante a eliminar
	 * @return
	 */
	public String eliminar(Long id) {
		EstudianteDAO estudianteDAO = new EstudianteDAO();
		estudianteDAO.eliminarEstudiante(id);
		System.out.println("Estudiante eliminado con EXITO!!!");
		return "/faces/index.xhtml";
	}

	
}
