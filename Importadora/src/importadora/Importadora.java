/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package importadora;

import controller.ControlAgregarProducto;
import controller.ControlInventario;
import controller.ControlLogIn;
import controller.ControlMenuPrincipal;
import controller.ControlRegistroUsuario;
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
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        inicializarInstancias();
        AdministradorVentanas.instancia.abrirVentana(Login.class);
    }
    
    private static void inicializarInstancias() throws InstantiationException, IllegalAccessException{
        ControlLogIn.instancia.inicializar();
        ControlMenuPrincipal.instancia.inicializar();
        ControlInventario.instancia.inicializar();
        ControlAgregarProducto.instancia.inicializar();
        ControlRegistroUsuario.instancia.inicializar();
    }
    
}
