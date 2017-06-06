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
public class FuncionesAutomovil extends FuncionesBaseDeDatos{
    public FuncionesAutomovil(Connection conexion, Statement statement){
        super(conexion, statement);
    }
    
    public String getFabricante(int id){
        int idFabricante = this.obtenerPrimerValorTabla("vehiculo", new String[]{"fabricante_id"}, "WHERE id='"+id+"'");
        return this.obtenerPrimerValorTabla("fabricante", new String[]{"nombre"}, "WHERE id='"+idFabricante+"'");
    }
    
    public long getIdAlmacen(String nombre){
        return this.obtenerPrimerValorTabla("almacen", new String[]{"id"}, "WHERE nombre='"+nombre+"'");
    }
    
    public long getIdVehiculo(int nr_chasis){
        return this.obtenerPrimerValorTabla("vehiculo",new String[]{"id"}, "WHERE nr_chasis='"+nr_chasis+"'");
    }
    public double getPrecio(int id){
        return this.obtenerPrimerValorTabla("vehiculo", new String[]{"nombre"}, "WHERE id='"+id+"'");
    }
    
    public String getColor(int id){
        int idColor = this.obtenerPrimerValorTabla("vehiculo", new String[]{"fabricante_id"}, "WHERE id='"+id+"'");
        return this.obtenerPrimerValorTabla("color", new String[]{"nombre"}, "WHERE id='"+idColor+"'");
    }
    public int getNrChasis(int id){
        return this.obtenerPrimerValorTabla("vehiculo", new String[]{"nr_chasis"}, "WHERE id='"+id+"'");
    }
    public String getModelo(int id){
        int idModelo = this.obtenerPrimerValorTabla("vehiculo", new String[]{"modelo_id"}, "WHERE id='"+id+"'");
        return this.obtenerPrimerValorTabla("modelo", new String[]{"nombre"}, "WHERE id='"+idModelo+"'");
    }
    public String getCombustible(int id){
        int idCombustible = this.obtenerPrimerValorTabla("vehiculo", new String[]{"combustible_id"}, "WHERE id='"+id+"'");
        return this.obtenerPrimerValorTabla("combustible", new String[]{"nombre"}, "WHERE id='"+idCombustible+"'");
    }
    public String getTipoCaja(int id){
        int idTipoCaja = this.obtenerPrimerValorTabla("vehiculo", new String[]{"tipo_caja_id"}, "WHERE id='"+id+"'");
        return this.obtenerPrimerValorTabla("tipo_caja", new String[]{"nombre"}, "WHERE id='"+idTipoCaja+"'");
    }
    public String getEstado(int id){
        int idEstado = this.obtenerPrimerValorTabla("vehiculo", new String[]{"estado_vehiculo_id"}, "WHERE id='"+id+"'");
        return this.obtenerPrimerValorTabla("estado_vehiculo", new String[]{"nombre"}, "WHERE id='"+idEstado+"'");
    }
    public String getDescripcion(int id){
        return this.obtenerPrimerValorTabla("vehiculo", new String[]{"descripcion"}, "WHERE id='"+id+"'");
    }
    
    public double getGarantia(int id){
        return this.obtenerPrimerValorTabla("vehiculo", new String[]{"garantia"}, "WHERE id='"+id+"'");
    }
    
    public long getIdFabricante(String nombre){
        return this.obtenerPrimerValorTabla("fabricante", new String[]{"id"}, "WHERE nombre='"+nombre+"'");
    }
    
    public long getIdColor(String nombre){
        return this.obtenerPrimerValorTabla("color", new String[]{"id"}, "WHERE nombre='"+nombre+"'");
    }
    
    public long getIdModelo(String nombre){
        return this.obtenerPrimerValorTabla("modelo", new String[]{"id"}, "WHERE nombre='"+nombre+"'");
    }
    
    public long getIdCombustible(String nombre){
        return this.obtenerPrimerValorTabla("combustible", new String[]{"id"}, "WHERE nombre='"+nombre+"'");
    }
    public long getIdTipoCaja(String nombre){
        return this.obtenerPrimerValorTabla("tipo_caja", new String[]{"id"}, "WHERE tipo='"+nombre+"'");
    }
    public long getIdEstado(String nombre){
        return this.obtenerPrimerValorTabla("estado_vehiculo", new String[]{"id"}, "WHERE nombre='"+nombre+"'");
    }    
    
    public boolean registrarAuto(Auto auto){
        return this.insertarEnTabla("vehiculo", new String[]{"fabricante_id", "combustible_id", "tipo_caja_id", "modelo_id", "estado_vehiculo_id","color_id",
                                                            "precio", "nr_chasis", "descripcion", "garantia"}, new Object[]{getIdFabricante(auto.getFabricante()),
                                                               getIdCombustible(auto.getCombustible()), getIdTipoCaja(auto.getTipo_caja()), getIdModelo(auto.getModelo()),
                                                                getIdEstado(auto.getEstado()), getIdColor(auto.getColor()), auto.getPrecioVenta(), auto.getNr_chasis(),
                                                                auto.getDescripcion(), auto.getGarantia()});
    }
}
