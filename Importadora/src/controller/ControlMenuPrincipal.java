/*
 * Esta clase se encarga de controlar las funciones de la ventana del Menu principal
 */
package controller;

import Conexion.BaseDeDatos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.AdministradorVentanas;
import model.PermisoUsuario;
import view.Inventario;
import view.Menu;
import view.RegistroUsuario;

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
    
    /**
     * Este metodo inicializa los botones y los habilita segun el permiso del usuario
     */
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
                 if(valido){
                     AdministradorVentanas.instancia.abrirVentana(Inventario.class);
                 }
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
                 if(valido){
                     AdministradorVentanas.instancia.abrirVentana(RegistroUsuario.class);
                 }
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
        ventanaMenu.getBotonSalir().addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 boolean sesion = BaseDeDatos.instancia.getUsuarios().cerrarSesion();
                 if(sesion){
                    JOptionPane.showMessageDialog(ventanaMenu, "Sesion Cerrada.");
                    System.exit(0);
                 }
                 else
                     JOptionPane.showMessageDialog(ventanaMenu, "Error al cerrar Sesion.");
             }
         });
    }
    
    /**
     * @return devuelve true si el usuario cumple con alguno de los permisos
     * @param permisos es un arreglo de los permisos a verificar
     */
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
