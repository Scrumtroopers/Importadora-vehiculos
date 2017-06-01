/*
 * Esta clase se encarga de administrar las ventanas abiertas, maneja las instancias y es capaz de ir una ventana atras
 */
package model;

import view.VentanaModelo;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Login;

/**
 *
 * @author Bernardo
 */
public class AdministradorVentanas {
    
    public static AdministradorVentanas instancia = new AdministradorVentanas();
    
    private Stack<String> ventanasAnteriores;
    private Map<String, VentanaModelo> instancias;
    private String ventanaActual;
    
    public AdministradorVentanas(){
        ventanasAnteriores = new Stack<String>();
        instancias = new HashMap<String, VentanaModelo>() {};
        ventanaActual = "";
    }
    
    /**
     * @param clase esta variable se utiliza para crear una instancia de la ventana y abrirla
     */
    public <T extends VentanaModelo> void abrirVentana(Class<T> clase){
        try {
            VentanaModelo ventana;
            if(!ventanaActual.equals(clase.getName()))
            {
                cerrarVentanaActual();
                ventanasAnteriores.push(ventanaActual);
                ventanaActual = clase.getName();
                ventana = getVentana(clase);
                ventana.mostrarVentana();
            }
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(AdministradorVentanas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Este metodo cierra la ventana actual
     */
    public void cerrarVentanaActual(){
        if(!ventanaActual.equals(""))
            instancias.get(ventanaActual).ocultarVentana();
    }
    
    /**
     * Esta funcion crea una instancia de la ventana o la obtiene si ya fue creada
     * @return devuelve la ventana
     * @param clase esta variable se utiliza para crear una instancia de la ventana y abrirla
     */
    public <T extends VentanaModelo> T getVentana(Class<T> clase) throws InstantiationException, IllegalAccessException{
        T ventana;
        if(instancias.containsKey(clase.getName())){
                    ventana = (T)instancias.get(clase.getName());
                }
                else{
                    ventana = clase.newInstance();
                    instancias.put(clase.getName(), ventana);
               }
        return ventana;
    }
    
    /**
     * Este metodo abre una ventana anterior
     */
    public void Atras(){
        if(ventanasAnteriores.size() > 1){
            cerrarVentanaActual();
            ventanaActual = this.ventanasAnteriores.pop();
            VentanaModelo ventana = instancias.get(ventanaActual);
            ventana.mostrarVentana();
        }
    }
}
