/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Conexion.BaseDeDatos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.AdministradorVentanas;
import model.Auto;
import view.AgregarProducto;

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
                    Auto auto;
                    auto = new Auto((String)datos[1], (String)datos[7], (String)datos[3], (String)datos[4], (String)datos[2], (String)datos[6], (int)datos[5], (String)datos[8], (double)datos[9], ((double)datos[9])*0.55);
                    BaseDeDatos.instancia.getInventario().agregarVehiculoInventario(auto, (String)datos[12], Integer.valueOf(datos[10].toString()), (String)datos[13]);
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
