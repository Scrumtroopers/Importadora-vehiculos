/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Conexion.FuncionesBaseDeDatos;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author ariel
 */
public class FuncionesInventario extends FuncionesBaseDeDatos {

    private FuncionesAutomovil funcionAuto;

    public FuncionesInventario(Connection conexion, Statement statement) {
        super(conexion, statement);
        funcionAuto = new FuncionesAutomovil(conexion, statement);
    }

    /* public boolean agregarVehiculoInventario(String fabricante, String combustible, String tipo_caja, String modelo, String estado_vehiculo,
                                            String color, double precio, int nr_chasis, String descripcion, double garantia){
        
    }*/
    public boolean agregarVehiculoInventario(Auto auto, String almacen, int cantidad, String observaciones) {
        boolean valido = funcionAuto.registrarAuto(auto);
        boolean insertado = false;
        if (valido) {
            insertado = this.insertarEnTabla("inventario", new String[]{"almacen_id", "vehiculo_id", "cantidad", "observaciones"}, new Object[]{funcionAuto.getIdVehiculo(cantidad),
                                            1, cantidad, observaciones});
        }
        return insertado;
    }
}
