/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import model.AdministradorVentanas;
import model.PermisoUsuario;
import view.Menu;

/**
 *
 * @author Bernardo
 */
public class ControlMenuPrincipal {
    
    public static ControlMenuPrincipal instancia = new ControlMenuPrincipal(); 
    
    private Menu ventanaMenu;
    
    public ControlMenuPrincipal(){
        try {
            ventanaMenu = AdministradorVentanas.instancia.getVentana(Menu.class);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ControlMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inicializar(){
        ventanaMenu.getBotonContabilidad().addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 boolean valido = (verificarPermiso(new PermisoUsuario[]
                 {
                     PermisoUsuario.ConsultarEstadoEconomico
                 }));
                 System.out.println(valido?"Acceso valido":"Acceso Denegado");
             }
         });
        ventanaMenu.getBotonFacturacion().addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 boolean valido = (verificarPermiso(new PermisoUsuario[]
                 {
                     PermisoUsuario.ConsultarFactura,
                     PermisoUsuario.Facturar
                 }));
                 System.out.println(valido?"Acceso valido":"Acceso Denegado");
             }
         });
        ventanaMenu.getBotonInventario().addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 boolean valido = (verificarPermiso(new PermisoUsuario[]
                 {
                     PermisoUsuario.AgregarProducto,
                     PermisoUsuario.ConsultarInventario,
                     PermisoUsuario.EliminarProducto
                 }));
                 System.out.println(valido?"Acceso valido":"Acceso Denegado");
             }
         });
        ventanaMenu.getBotonProveedores().addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 boolean valido = (verificarPermiso(new PermisoUsuario[]
                 {
                     PermisoUsuario.ConsultarProveedores
                 }));
                 System.out.println(valido?"Acceso valido":"Acceso Denegado");
             }
         });
        ventanaMenu.getBotonUsuarios().addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 boolean valido = (verificarPermiso(new PermisoUsuario[]
                 {
                     PermisoUsuario.AgregarUsuario,
                     PermisoUsuario.ConsultarUsuario,
                     PermisoUsuario.EliminarUsuario
                 }));
                 System.out.println(valido?"Acceso valido":"Acceso Denegado");
             }
         });
        ventanaMenu.getBotonTransporte().addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 boolean valido = (verificarPermiso(new PermisoUsuario[]
                 {
                     
                 }));
                 System.out.println(valido?"Acceso valido":"Acceso Denegado");
             }
         });
    }
    
    private boolean verificarPermiso(PermisoUsuario[] permisos){
        boolean valido = false;
        if(ControlLogIn.instancia.usuarioActivo()){
            int i=0;
            while(i<permisos.length && !valido){
                valido = ControlLogIn.instancia.verificarPermisos(permisos[i]);
                i++;
            }
        }
        return valido;
    }
}
