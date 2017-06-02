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
    public double getPrecio(int id){
        return this.obtenerPrimerValorTabla("vehiculo", new String[]{"nombre"}, "WHERE id='"+id+"'");
    }
    
    public String getColor(int id){
        int idColor = this.obtenerPrimerValorTabla("vehiculo", new String[]{"fabricante_id"}, "WHERE id='"+id+"'");
        return this.obtenerPrimerValorTabla("fabricante", new String[]{"nombre"}, "WHERE id='"+idColor+"'");
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
    
}
