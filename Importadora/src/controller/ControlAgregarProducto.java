/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AdministradorVentanas;
import view.AgregarProducto;
import view.Login;

/**
 *
 * @author Cristhian
 */
public class ControlAgregarProducto {
    public static ControlAgregarProducto instancia = new ControlAgregarProducto();
    private AgregarProducto ventanaAgregarProducto ;
    private Object[] datos;
            
    public ControlAgregarProducto(){
    }
    
    public void inicializar() {
        try {
            //boton guardar
            ventanaAgregarProducto = AdministradorVentanas.instancia.getVentana(AgregarProducto.class);
            ventanaAgregarProducto.getBotonGuardar().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    datos = ventanaAgregarProducto.getDatos();
                    System.out.println("guardar");
                }
            });
            //boton cancelar
            ventanaAgregarProducto.getBotonCancelar().addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    int resultado = JOptionPane.showConfirmDialog(null, "Esta Seguro?","Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
				  if (resultado == JOptionPane.YES_OPTION || resultado == JOptionPane.CANCEL_OPTION)
                                    AdministradorVentanas.instancia.Atras();
                }
            });
            
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ControlAgregarProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
