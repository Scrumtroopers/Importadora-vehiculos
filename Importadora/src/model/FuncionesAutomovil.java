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
    public String getNrChasis(int id){
        return this.obtenerPrimerValorTabla("fabricante", new String[]{"nombre"}, "WHERE id='"+id+"'");
    }
    public String getModelo(int id){
        int idModelo = this.obtenerPrimerValorTabla("vehiculo", new String[]{"fabricante_id"}, "WHERE id='"+id+"'");
        return this.obtenerPrimerValorTabla("fabricante", new String[]{"nombre"}, "WHERE id='"+idModelo+"'");
    }
    public String getCombustible(int id){
        int idCombustible = this.obtenerPrimerValorTabla("vehiculo", new String[]{"fabricante_id"}, "WHERE id='"+id+"'");
        return this.obtenerPrimerValorTabla("fabricante", new String[]{"nombre"}, "WHERE id='"+idCombustible+"'");
    }
    public String getTipoCaja(int id){
        int idTipoCaja = this.obtenerPrimerValorTabla("vehiculo", new String[]{"fabricante_id"}, "WHERE id='"+id+"'");
        return this.obtenerPrimerValorTabla("fabricante", new String[]{"nombre"}, "WHERE id='"+idTipoCaja+"'");
    }
    public String getEstado(int id){
        int idEstado = this.obtenerPrimerValorTabla("vehiculo", new String[]{"fabricante_id"}, "WHERE id='"+id+"'");
        return this.obtenerPrimerValorTabla("fabricante", new String[]{"nombre"}, "WHERE id='"+idEstado+"'");
    }
    public String getDescripcion(int id){
        return this.obtenerPrimerValorTabla("fabricante", new String[]{"nombre"}, "WHERE id='"+id+"'");
    }
    
    public String getGarantia(int id){
        int idGarantia = this.obtenerPrimerValorTabla("vehiculo", new String[]{"fabricante_id"}, "WHERE id='"+id+"'");
        return this.obtenerPrimerValorTabla("fabricante", new String[]{"nombre"}, "WHERE id='"+idGarantia+"'");
    }
    
}
