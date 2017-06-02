/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Conexion.BaseDeDatos;
import Conexion.FuncionesBaseDeDatos;
import java.util.ArrayList;
import model.FuncionesUsuario;
import model.PermisoUsuario;
import model.TipoUsuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bernardo
 */
public class TestFuncionesUsuario {
    
    FuncionesUsuario funcionesUsuario;
    
    @Before
    public void setUp() {
        funcionesUsuario = BaseDeDatos.instancia.getUsuarios();
    }
    
    @Test
    public void testGetPid(){
        assertEquals(funcionesUsuario.getPid("admin", "123") != 0, true);
        assertEquals(funcionesUsuario.getPid("admin", "") == 0, true);
        assertEquals(funcionesUsuario.getPid("admin", "1234") == 0, true);
        assertEquals(funcionesUsuario.getPid("hola", "123") == 0, true);      
    }
    
    @Test
    public void testGetIdUser(){
        int pid = funcionesUsuario.getPid("admin", "123");
        assertEquals(funcionesUsuario.getIdUser(0), -1);
        assertEquals(funcionesUsuario.getIdUser(pid) != -1, true);
    }
    
    @Test
    public void testGetNombreUsuario(){
        int pid = funcionesUsuario.getPid("admin", "123");
        int idUsuario = funcionesUsuario.getIdUser(pid);
        assertEquals(funcionesUsuario.getNombreUsuario(idUsuario), "admin");
        assertEquals(funcionesUsuario.getNombreUsuario(0), null);
    }
    
    @Test
    public void testGetPasswordUsuario(){
        int pid = funcionesUsuario.getPid("admin", "123");
        int idUsuario = funcionesUsuario.getIdUser(pid);
        assertEquals(funcionesUsuario.getPasswordUsuario(idUsuario), "123");
        assertEquals(funcionesUsuario.getPasswordUsuario(0), null);
    }
    
    @Test
    public void testGetTipoUsuario(){
        int pid = funcionesUsuario.getPid("admin", "123");
        int idUsuario = funcionesUsuario.getIdUser(pid);
        assertEquals(funcionesUsuario.getTipoUsuario(idUsuario), TipoUsuario.Administrador);
        assertEquals(funcionesUsuario.getTipoUsuario(0), null);
    }
    
    @Test
    public void testGetPermisosUsuario(){
        int pid = funcionesUsuario.getPid("admin", "123");
        int idUsuario = funcionesUsuario.getIdUser(pid);
        
        ArrayList<PermisoUsuario> permisos = funcionesUsuario.getPermisosUsuario(idUsuario);
        PermisoUsuario[] valores = PermisoUsuario.values();
        for(int i=0;i<valores.length;i++){
            assertEquals(permisos.get(i), valores[i]);
        }
        assertEquals(funcionesUsuario.getPermisosUsuario(0) == null, true);
    }
    
    @Test
    public void testVerificarPassword(){
        int idUsuario = funcionesUsuario.getIdUser(funcionesUsuario.getPid("admin", "123"));
        assertEquals(funcionesUsuario.verificarPassword("123", idUsuario), true);
        assertEquals(funcionesUsuario.verificarPassword("1234", idUsuario), false);
        assertEquals(funcionesUsuario.verificarPassword("hkejf", idUsuario), false);
        assertEquals(funcionesUsuario.verificarPassword("123", 0), false);
    }
    
    @Test
    public void testCambiarPassword(){
        int pid = funcionesUsuario.getPid("admin", "123");
        int idUsuario = funcionesUsuario.getIdUser(pid);
        funcionesUsuario.cambiarPassword("abc", idUsuario);
        assertEquals(funcionesUsuario.getPasswordUsuario(idUsuario).equals("123"), false);
        assertEquals(funcionesUsuario.getPasswordUsuario(idUsuario).equals("abc"), true);
        funcionesUsuario.cambiarPassword("123", idUsuario);
        assertEquals(funcionesUsuario.getPasswordUsuario(idUsuario).equals("abc"), false);
        assertEquals(funcionesUsuario.getPasswordUsuario(idUsuario).equals("123"), true);
        funcionesUsuario.cambiarPassword("abc", 0);
        assertEquals(funcionesUsuario.getPasswordUsuario(idUsuario).equals("abc"), false);
    }
}
