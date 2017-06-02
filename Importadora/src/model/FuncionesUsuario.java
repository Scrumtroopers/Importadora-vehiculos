/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Conexion.FuncionesBaseDeDatos;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bernardo
 */
public class FuncionesUsuario extends FuncionesBaseDeDatos {
    
    public FuncionesUsuario(Connection conexion, Statement statement){
        super(conexion, statement);
    }
    
    public int getPid(String name, String pass){
        return obtenerPrimerValorFuncion("pid", new Object[]{name, pass});
    }
    
    public int getIdUser(int pid){
        Object val = obtenerPrimerValorTabla("sesion", new String[]{"user_2_iduser"}, "WHERE pid='"+pid+"'");
        return val == null?-1:(int)val;
    }
    
    public String getNombreUsuario(int idUsuario){
        return this.obtenerPrimerValorTabla("user_2", new String[]{"nombre"}, "WHERE iduser='"+idUsuario+"'");
    }
    
    public String getPasswordUsuario(int idUsuario){
        return this.obtenerPrimerValorTabla("user_2", new String[]{"password_2"}, "WHERE iduser='"+idUsuario+"'");
    }
    
    public TipoUsuario getTipoUsuario(int idUsuario){
        Object valor = this.obtenerPrimerValorTabla("user_rol", new String[]{"rol_idrol"}, "WHERE user_2_iduser='"+idUsuario+"'");
        return valor == null?null:TipoUsuario.values()[((int)valor - 1)];
    }
    
    public ArrayList<PermisoUsuario> getPermisosUsuario(int idUsuario){
        TipoUsuario tipo = getTipoUsuario(idUsuario);
        ArrayList<PermisoUsuario> permisos = null;
        if(tipo!=null){
            ArrayList<Object[]> valores = obtenerDeTabla("rol_funcion", new String[]{"funcion_idfuncion"}, "WHERE rol_idrol='"+(tipo.ordinal()+1)+"'");
            permisos = new ArrayList<PermisoUsuario>();
            if(valores != null && !valores.isEmpty()){
                for(Object[] fila : valores){
                    permisos.add(PermisoUsuario.values()[((int)fila[0]) - 1]);
                }
            }
        }
        return permisos;
    }
    
    public boolean verificarPassword(String password, int idUsuario)
    {
        String actual = getPasswordUsuario(idUsuario);
        return actual == null?false:actual.equals(password);
    }
    
    public void cambiarPassword(String nuevo, int idUsuario){
        actualizarTabla("user_2", new String[]{"password_2"}, new Object[]{nuevo}, "WHERE iduser='"+idUsuario+"'");
    }
    
    public boolean crearNuevoUsuario(String nombre, String pass, TipoUsuario tipo){
        boolean creado = false;
        try{
            boolean insertado = this.insertarEnTabla("user_2", new String[]{"nombre", "password_2"}, new Object[]{nombre, pass});
            if(insertado){
                int pid = this.getPid(nombre, pass);
                int idUser = this.getIdUser(pid);
                boolean insertadoRol = this.insertarEnTabla("user_rol", new String[]{"user_2_iduser", "rol_idrol"}, new Object[]{idUser, (tipo.ordinal()+1)});
                if(insertadoRol)
                    creado = true;
                else
                    System.out.println("Error al Insertar ROL");
            }
            else
                System.out.println("Error al insertar USUARIO");
        }
        catch(Exception e){
            creado = false;
        }
        return creado;
    }
}
