/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public ControlLogIn(){
        
    }
    
    public void inicializar(){
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
    
    private void iniciarSesion(){
        String usuario = ventanaLogin.getNombreUsuario();
        String password = ventanaLogin.getPassword();
        int pid = BaseDeDatos.instancia.getUsuarios().getPid(usuario, password);
        if(pid != 0){
            pidUsuario = pid;
            System.out.println("Sesion iniciada "+pid);
            AdministradorVentanas.instancia.abrirVentana(Menu.class);
        }
    }
    
    public String getNombreUsuario(){
        String nombre = "";
        if(pidUsuario != 0){
            int idUsuario = BaseDeDatos.instancia.getUsuarios().getIdUser(pidUsuario);
            nombre = BaseDeDatos.instancia.getUsuarios().getNombreUsuario(idUsuario);
        }
        return nombre;
    }
    
    public TipoUsuario getTipoUsuario(){
        TipoUsuario tipo = null;
        if(pidUsuario != 0){
            int idUsuario = BaseDeDatos.instancia.getUsuarios().getIdUser(pidUsuario);
            tipo = BaseDeDatos.instancia.getUsuarios().getTipoUsuario(idUsuario);
        }
        return tipo;
    }
    
    public boolean verificarPermisos(PermisoUsuario permiso){
        boolean permitido = false;
        if(pidUsuario != 0){
            int idUsuario = BaseDeDatos.instancia.getUsuarios().getIdUser(pidUsuario);
            ArrayList<PermisoUsuario> permisos = BaseDeDatos.instancia.getUsuarios().getPermisosUsuario(idUsuario);
            permitido = permisos.contains(permiso);
        }
        return permitido;
    }
    
    public boolean usuarioActivo(){
        return pidUsuario != 0;
    }
}
