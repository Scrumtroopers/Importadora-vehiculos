package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import model.PermisoUsuario;

public class Menu extends VentanaModelo {

	private JPanel contentPane;
        private JButton btnInventario;
        private JButton btnFacturacion;
        private JButton btnContabilidad;
        private JButton btnProveedores;
        private JButton btnUsuarios;
        private JButton btnTransporte;
        
	public Menu() {
            super("Menu Principal");
		setBounds(100, 100, 623, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                contentPane.setBackground(colorFondo);
		
                
		btnInventario = new JButton("Inventario");
		btnInventario.setFont(fuenteBotones);
		btnInventario.setBounds(29, 30, 162, 129);
		contentPane.add(btnInventario);
		
                
		btnFacturacion = new JButton("Facturacion");
		btnFacturacion.setFont(fuenteBotones);
		btnFacturacion.setBounds(216, 30, 162, 129);
		contentPane.add(btnFacturacion);
		
		btnContabilidad = new JButton("Contabilidad");
		btnContabilidad.setFont(fuenteBotones);
		btnContabilidad.setBounds(408, 30, 162, 129);
		contentPane.add(btnContabilidad);
		
		btnProveedores = new JButton("Proveedores");
		btnProveedores.setFont(fuenteBotones);
		btnProveedores.setBounds(29, 192, 162, 129);
		contentPane.add(btnProveedores);
		
		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setFont(fuenteBotones);
		btnUsuarios.setBounds(216, 192, 162, 129);
		contentPane.add(btnUsuarios);
		
		btnTransporte = new JButton("Transporte");
		btnTransporte.setFont(fuenteBotones);
		btnTransporte.setBounds(408, 192, 162, 129);
		contentPane.add(btnTransporte);
	}
        
        public JButton getBotonInventario(){
            return btnInventario;
        }
        
        public JButton getBotonUsuarios(){
            return btnUsuarios;
        }
        
        public JButton getBotonContabilidad(){
            return btnContabilidad;
        }
        
        public JButton getBotonFacturacion(){
            return btnFacturacion;
        }
        
        public JButton getBotonProveedores(){
            return btnProveedores;
        }
        
        public JButton getBotonTransporte(){
            return btnTransporte;
        }
}
