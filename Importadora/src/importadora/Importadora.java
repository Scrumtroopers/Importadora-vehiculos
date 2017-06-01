/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importadora;

import Conexion.BaseDeDatos;
import controller.ControlLogIn;
import model.AdministradorVentanas;
import view.Login;

/**
 *
 * @author Cristhian
 */
public class Importadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlLogIn.instancia.inicializar();
        AdministradorVentanas.instancia.abrirVentana(Login.class);
    }
    
}
