/*
 * Esta clase se encarga de controlar las funciones de la ventana Login
 */
package controller;

import Conexion.BaseDeDatos;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AdministradorVentanas;
import model.FuncionesUsuario;
import model.PermisoUsuario;
import model.TipoUsuario;
import view.Login;
import view.Menu;

/**
 *
 * @author Bernardo
 */
public class ControlLogIn {

    public static ControlLogIn instancia = new ControlLogIn();
    private Login ventanaLogin;
    private int pidUsuario;

    public ControlLogIn() {

    }

    /**
     * Este metodo inicializa la clase y agrega el evento al boton de Login
     */
    public void inicializar() {
        try {
            ventanaLogin = AdministradorVentanas.instancia.getVentana(Login.class);
            ventanaLogin.getBotonLogin().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    iniciarSesion();
                }
            });
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ControlLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este metodo verifica si existe el usuario en la Base de datos e inicia
     * sesion
     */
    private void iniciarSesion() {
        String usuario = ventanaLogin.getNombreUsuario();
        String password = ventanaLogin.getPassword();
        int pid = BaseDeDatos.instancia.getUsuarios().getPid(usuario, password);
        if (pid != 0) {
            pidUsuario = pid;
            System.out.println("Sesion iniciada " + pid);
            AdministradorVentanas.instancia.abrirVentana(Menu.class);
        }
    }

    /**
     * @return devuelve el nombre del usuario registrado
     */
    public String getNombreUsuario() {
        String nombre = "";
        if (pidUsuario != 0) {
            int idUsuario = BaseDeDatos.instancia.getUsuarios().getIdUser(pidUsuario);
            nombre = BaseDeDatos.instancia.getUsuarios().getNombreUsuario(idUsuario);
        }
        return nombre;
    }

    /**
     * @return devuelve el Tipo de Usuario del usuario registrado
     */
    public TipoUsuario getTipoUsuario() {
        TipoUsuario tipo = null;
        if (pidUsuario != 0) {
            int idUsuario = BaseDeDatos.instancia.getUsuarios().getIdUser(pidUsuario);
            tipo = BaseDeDatos.instancia.getUsuarios().getTipoUsuario(idUsuario);
        }
        return tipo;
    }

    /**
     * @return devuelve true si el usuario contiene el permiso
     * @param permiso es el permiso a comparar
     */
    public boolean verificarPermisos(PermisoUsuario permiso) {
        boolean permitido = false;
        if (pidUsuario != 0) {
            int idUsuario = BaseDeDatos.instancia.getUsuarios().getIdUser(pidUsuario);
            ArrayList<PermisoUsuario> permisos = BaseDeDatos.instancia.getUsuarios().getPermisosUsuario(idUsuario);
            permitido = permisos.contains(permiso);
        }
        return permitido;
    }

    public boolean usuarioActivo() {
        return pidUsuario != 0;
    }
}
