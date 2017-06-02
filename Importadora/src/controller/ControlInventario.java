/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.AdministradorVentanas;
import model.PermisoUsuario;
import view.AgregarProducto;
import view.Inventario;

/**
 *
 * @author ariel
 */
public class ControlInventario {

    public static ControlInventario instancia = new ControlInventario();
    private Inventario ventanaInventario;
    private int pidUsuario;

    public ControlInventario() {
    }

    public void inicializar() throws InstantiationException, IllegalAccessException {
        ventanaInventario = AdministradorVentanas.instancia.getVentana(Inventario.class);
        ventanaInventario.getBtnAgregar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdministradorVentanas.instancia.abrirVentana(AgregarProducto.class);
            }
        });
    }
}
