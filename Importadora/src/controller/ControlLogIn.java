/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Conexion.BaseDeDatos;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AdministradorVentanas;
import view.Login;
import view.Menu;

/**
 *
 * @author Bernardo
 */
public class ControlLogIn {
    
    public static ControlLogIn instancia = new ControlLogIn();
    private Login ventanaLogin;
    
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
            System.out.println("Sesion iniciada "+pid);
            AdministradorVentanas.instancia.abrirVentana(Menu.class);
        }
    }
}
