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

public class Menu extends VentanaModelo {

	private JPanel contentPane;
        
	public Menu() {
            super("Menu Principal");
		setBounds(100, 100, 623, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                contentPane.setBackground(colorFondo);
		
		JButton btnNewButton = new JButton("Inventario");
		btnNewButton.setFont(fuenteBotones);
		btnNewButton.setBounds(29, 30, 162, 129);
		contentPane.add(btnNewButton);
		
		JButton btnFacturacion = new JButton("Facturacion");
		btnFacturacion.setFont(fuenteBotones);
		btnFacturacion.setBounds(216, 30, 162, 129);
		contentPane.add(btnFacturacion);
		
		JButton btnCopntabilidad = new JButton("Contabilidad");
		btnCopntabilidad.setFont(fuenteBotones);
		btnCopntabilidad.setBounds(408, 30, 162, 129);
		contentPane.add(btnCopntabilidad);
		
		JButton btnProveedores = new JButton("Proveedores");
		btnProveedores.setFont(fuenteBotones);
		btnProveedores.setBounds(29, 192, 162, 129);
		contentPane.add(btnProveedores);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setFont(fuenteBotones);
		btnUsuarios.setBounds(216, 192, 162, 129);
		contentPane.add(btnUsuarios);
		
		JButton btnTransporte = new JButton("Transporte");
		btnTransporte.setFont(fuenteBotones);
		btnTransporte.setBounds(408, 192, 162, 129);
		contentPane.add(btnTransporte);
	}

}
