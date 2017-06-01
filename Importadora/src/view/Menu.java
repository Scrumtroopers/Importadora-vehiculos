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

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Inventario");
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnNewButton.setBounds(29, 30, 162, 129);
		contentPane.add(btnNewButton);
		
		JButton btnFacturacion = new JButton("Facturacion");
		btnFacturacion.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnFacturacion.setBounds(216, 30, 162, 129);
		contentPane.add(btnFacturacion);
		
		JButton btnCopntabilidad = new JButton("Contabilidad");
		btnCopntabilidad.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnCopntabilidad.setBounds(408, 30, 162, 129);
		contentPane.add(btnCopntabilidad);
		
		JButton btnProveedores = new JButton("Proveedores");
		btnProveedores.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnProveedores.setBounds(29, 192, 162, 129);
		contentPane.add(btnProveedores);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnUsuarios.setBounds(216, 192, 162, 129);
		contentPane.add(btnUsuarios);
		
		JButton btnTransporte = new JButton("Transporte");
		btnTransporte.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnTransporte.setBounds(408, 192, 162, 129);
		contentPane.add(btnTransporte);
	}

}
