/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Conexion.BaseDeDatos;
import Conexion.FuncionesBaseDeDatos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AdministradorVentanas;
import model.TipoUsuario;
import view.Login;
import view.RegistroUsuario;

/**
 *
 * @author Bernardo
 */
public class ControlRegistroUsuario {
    public static ControlRegistroUsuario instancia = new ControlRegistroUsuario();
    private RegistroUsuario ventana;
    
    public void inicializar() {
        try {
            ventana = AdministradorVentanas.instancia.getVentana(RegistroUsuario.class);
            ventana.getBotonRegistrar().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    registrarUsuario();
                }
            });
            ventana.getBotonSalir().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AdministradorVentanas.instancia.Atras();
                }
            });
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ControlLogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void registrarUsuario(){
        String pass = ventana.getPassword();
        String user = ventana.getNombreUsuario();
        TipoUsuario tipo = ventana.getTipoUsuario();
        if(pass != null && !user.equals("")){
            if(!BaseDeDatos.instancia.getUsuarios().existeUsuario(user)){
                boolean reg = BaseDeDatos.instancia.getUsuarios().crearNuevoUsuario(user, pass, tipo);
                if(reg){
                    JOptionPane.showMessageDialog(ventana, "Usuario Registrado");
                    ventana.limpiarDatos();
                }
                else{
                    JOptionPane.showMessageDialog(ventana, "Error al registrar");
                }
            }
            else{
                JOptionPane.showMessageDialog(ventana, "El usuario que quiere registrar ya existe");
            }
        }
        else{
            JOptionPane.showMessageDialog(ventana, "Error en los Datos");
        }
    }
}
