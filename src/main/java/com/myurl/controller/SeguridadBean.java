package com.myurl.controller;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.myurl.dao.MaestroDAO;
import com.myurl.model.Maestro;

/**
 * 
 * Clase encargada de administrar la seguridad de la aplicacion.
 * 
 * @author Diego Alejandro Sanchez
 * @version 3.0
 * @since 2015-07-01
 * 
 */
@ManagedBean
@SessionScoped
public class SeguridadBean {
	/**
	 * Atributo que accede a los mensajes codificados en archivo externo de
	 * propiedades
	 */
	private static ResourceBundle rb = ResourceBundle.getBundle("resources.mensaje");
	private Maestro maestro = new Maestro();
	private Maestro maestroReg;
	private String palabraSecreta;
	private String nuevoPassword;
	private String passwordActual;
	private String nuevoPasswordConf;
	private String codigoQuiz;

	private boolean autenticado = false;
	private boolean usuarioValidado = false;
	private boolean validaRespuesta = false;
	private boolean esMaestro;

	/**
	 * Metodo que autentica que el usuario y contrasenia sean los registrados en la
	 * BD.
	 * 
	 */
	public String autenticar() {
		MaestroDAO maestroDAO = new MaestroDAO();

		maestroReg = maestroDAO.buscarMaestroPorUsuarioClave(maestro.getUsuario(), maestro.getClave());
		if (maestroReg == null) {
			enviarMensaje(rb.getString("bean.seguridadBean.noAutenticado"));
			return "";
		} else {
			autenticado = true;
			esMaestro = true;
			maestro = maestroReg;
			System.out.println(maestro);
			return "Main.xhtml";
		}
		
	}

	/**
	 * Metodo para salir de la aplicacion. Cierra la sesion iniciada.
	 */
	public String salir() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		autenticado = false;
		palabraSecreta = "";
		maestroReg = null;
		maestro = new Maestro();
		return "faces/index.xhtml";
	}

	/**
	 * Metodo que valida si un usuario esta registrado. El parametro de busqueda es
	 * el numero de documento
	 */
	public void validarUsuario() {
		MaestroDAO maestroDAO = new MaestroDAO();
		maestroReg = maestroDAO.buscarMaestro(maestro.getId_maestro());
		if (maestroReg == null) {
			usuarioValidado = false;
			enviarMensaje(rb.getString("bean.seguridadBean.idnoencontrado"));

		} else {
			maestro = maestroReg;
			usuarioValidado = true;
		}
	}

	/**
	 * Metodo para verificar que la respuesta secreta sea la correcta. Metodo usado
	 * para la recuparacion de la contraseña. Se envia un email al usuario con
	 * informacion de la contraseña.
	 * 
	 * @return
	 */
	public String validarRespuesta() {
		MaestroDAO maestroDAO = new MaestroDAO();
		if (maestroDAO.validarPorPalabraSecreta(maestro.getUsuario(), palabraSecreta)) {
			validaRespuesta = true;
			maestro = new Maestro();
			validaRespuesta = false;

		} else {
			enviarMensaje(rb.getString("bean.seguridad.respuestaErrada"));
			return "";
		}
		return "index.jsf";
	}

	/**
	 * Metodo para cambiar la contraseña. Invoca al metodo modificar usuario.
	 * 
	 * @param passwordActual
	 * @return
	 */
	public String cambiarContrasenia() {
		if (passwordActual.equals(maestro.getClave())) {
			if (nuevoPassword.equals(nuevoPasswordConf)) {
				maestro.setClave(nuevoPassword);
				MaestroDAO maestroDao = new MaestroDAO();
				maestroDao.editar(maestro);
				enviarMensaje(rb.getString("bean.seguridadBean.confirmacionCambioContrasena"));
				return "Main.jsf";
			} else {
				enviarMensaje(rb.getString("bean.seguridadBean.contrasenasNoIguales"));
			}
		} else {
			enviarMensaje(rb.getString("bean.seguridadBean.contrasenasActualErrada"));
		}
		return "";
	}

	public String validarCodigoQuiz() {
		return "";
	}

	/**
	 * Metodo que envia mensajes a la pagina WEB
	 * 
	 * @param msj mensaje a enviar
	 */
	public void enviarMensaje(String msj) {
		FacesMessage mensaje = new FacesMessage(msj);
		FacesContext.getCurrentInstance().addMessage(null, mensaje);
	}

	/**
	 * Metodo para obtener el atributo respuestaSecreta
	 * 
	 * @return the respuestaSecreta
	 */
	public String getRespuestaSecreta() {
		return palabraSecreta;
	}

	/**
	 * Metodo para poner el valor en al atributo respuestaSecreta
	 * 
	 * @param palabraSecreta el/la respuestaSecreta a poner
	 */
	public void setRespuestaSecreta(String login) {
		this.palabraSecreta = login;
	}

	/**
	 * Metodo para obtener el atributo usuario
	 * 
	 * @return the usuario
	 */
	public Maestro getMaestro() {
		return maestro;
	}

	/**
	 * Metodo para poner el valor en al atributo usuario
	 * 
	 * @param usuario el/la usuario a poner
	 */
	public void setMaestro(Maestro usuario) {
		this.maestro = usuario;
	}

	/**
	 * Metodo para obtener el atributo autenticado
	 * 
	 * @return the autenticado
	 */
	public boolean isAutenticado() {
		return autenticado;
	}

	/**
	 * Metodo para poner el valor en al atributo autenticado
	 * 
	 * @param autenticado el/la autenticado a poner
	 */
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	/**
	 * @return the usuarioValidado
	 */
	public boolean isUsuarioValidado() {
		return usuarioValidado;
	}

	/**
	 * @param usuarioValidado the usuarioValidado to set
	 */
	public void setUsuarioValidado(boolean usuarioValidado) {
		this.usuarioValidado = usuarioValidado;
	}

	/**
	 * @return the validaRespuesta
	 */
	public boolean isValidaRespuesta() {
		return validaRespuesta;
	}

	/**
	 * @param validaRespuesta the validaRespuesta to set
	 */
	public void setValidaRespuesta(boolean validaRespuesta) {
		this.validaRespuesta = validaRespuesta;
	}

	/**
	 * @return the nuevoPassword
	 */
	public String getNuevoPassword() {
		return nuevoPassword;
	}

	/**
	 * @param nuevoPassword the nuevoPassword to set
	 */
	public void setNuevoPassword(String nuevoPassword) {
		this.nuevoPassword = nuevoPassword;
	}

	/**
	 * @return the passwordActual
	 */
	public String getPasswordActual() {
		return passwordActual;
	}

	/**
	 * @param passwordActual the passwordActual to set
	 */
	public void setPasswordActual(String passwordActual) {
		this.passwordActual = passwordActual;
	}

	/**
	 * @return the nuevoPasswordConf
	 */
	public String getNuevoPasswordConf() {
		return nuevoPasswordConf;
	}

	/**
	 * @param nuevoPasswordConf the nuevoPasswordConf to set
	 */
	public void setNuevoPasswordConf(String nuevoPasswordConf) {
		this.nuevoPasswordConf = nuevoPasswordConf;
	}

	/**
	 * @return the codigoQuiz
	 */
	public String getCodigoQuiz() {
		return codigoQuiz;
	}

	/**
	 * @param codigoQuiz the codigoQuiz to set
	 */
	public void setCodigoQuiz(String codigoQuiz) {
		this.codigoQuiz = codigoQuiz;
	}

	/**
	 * @return the esMaestro
	 */
	public boolean getEsMaestro() {
		return esMaestro;
	}

	/**
	 * @param esMaestro the esMaestro to set
	 */
	public void setEsMaestro(boolean esMaestro) {
		this.esMaestro = esMaestro;
	}

}
