/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.TipoUsuario;

/**
 *
 * @author Bernardo
 */
public class RegistroUsuario extends VentanaModelo{

        private JPanel contentPane;
	private JTextField textFieldUsuario;
        private JPasswordField textFieldPassword;
        private JPasswordField textFieldPassword2;
        private JComboBox comboBoxTipo;
        private JButton btnRegistrar;
        private JButton btnSalir;
        
	public RegistroUsuario() {
            super("Registro Usuario");
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                contentPane.setBackground(colorFondo);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Registrar Nuevo Usuario");
		lblLogin.setFont(fuenteTitulo);
		lblLogin.setBounds(107, 57, 267, 24);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(fuenteSubTitulo);
		lblPassword.setBounds(107, 153, 96, 24);
		contentPane.add(lblPassword);
                
                JLabel lblPassword2 = new JLabel("Confirm:");
		lblPassword2.setFont(fuenteSubTitulo);
		lblPassword2.setBounds(107, 185, 96, 24);
		contentPane.add(lblPassword2);
                
                JLabel lblTipo = new JLabel("Cargo:");
		lblTipo.setFont(fuenteSubTitulo);
		lblTipo.setBounds(107, 217, 96, 24);
		contentPane.add(lblTipo);
		
		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setFont(fuenteSubTitulo);
		lblNewLabel.setBounds(107, 118, 56, 24);
		contentPane.add(lblNewLabel);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(fuenteTextField);
		textFieldUsuario.setBounds(207, 121, 118, 25);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setFont(fuenteTextField);
		textFieldPassword.setBounds(207, 153, 118, 25);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
                
                textFieldPassword2 = new JPasswordField();
		textFieldPassword2.setFont(fuenteTextField);
		textFieldPassword2.setBounds(207, 185, 118, 25);
		contentPane.add(textFieldPassword2);
		textFieldPassword2.setColumns(10);
               
                
                TipoUsuario[] valores = TipoUsuario.values();
                comboBoxTipo = new JComboBox(valores);
                comboBoxTipo.setFont(fuenteTextField);
                comboBoxTipo.setBounds(207, 217, 118, 25);
                contentPane.add(comboBoxTipo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(fuenteBotones);
                btnRegistrar.setBounds(114, 269, 89, 23);
		contentPane.add(btnRegistrar);
                
                btnSalir= new JButton("Salir");
		btnSalir.setFont(fuenteBotones);
                btnSalir.setBounds(234, 269, 89, 23);
		contentPane.add(btnSalir);
	}
        
        public void limpiarDatos(){
            textFieldUsuario.setText("");
            textFieldPassword.setText("");
            textFieldPassword2.setText("");
        }
        
        public JButton getBotonRegistrar(){
            return btnRegistrar;
        }
        
        public JButton getBotonSalir(){
            return btnSalir;
        }
        
        public String getPassword(){
            boolean iguales = textFieldPassword.getText().equals(textFieldPassword2.getText());
            return iguales?textFieldPassword.getText():null;
        }
        
        public String getNombreUsuario(){
            return textFieldUsuario.getText();
        }
        
        public TipoUsuario getTipoUsuario(){
            return (TipoUsuario)comboBoxTipo.getSelectedItem();
        }
}
