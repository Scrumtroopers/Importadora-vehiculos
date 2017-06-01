package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends VentanaModelo {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JTextField textFieldPassword;
        private JButton btnLogin;
        
	public Login() {
            super("LogIn");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                contentPane.setBackground(colorFondo);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(fuenteTitulo);
		lblLogin.setBounds(107, 57, 67, 24);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(fuenteSubTitulo);
		lblPassword.setBounds(107, 153, 96, 24);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setFont(fuenteSubTitulo);
		lblNewLabel.setBounds(107, 118, 56, 24);
		contentPane.add(lblNewLabel);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(fuenteTextField);
		textFieldUsuario.setBounds(207, 121, 118, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(fuenteTextField);
		textFieldPassword.setBounds(207, 153, 118, 20);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(fuenteBotones);
                btnLogin.setBounds(174, 205, 89, 23);
		contentPane.add(btnLogin);
	}
        
        public JButton getBotonLogin(){
            return btnLogin;
        }
        
        public String getPassword(){
            return textFieldPassword.getText();
        }
        
        public String getNombreUsuario(){
            return textFieldUsuario.getText();
        }
}
