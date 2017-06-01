package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame {
	protected Verificador verificador;
	
	public Ventana(){
		verificador = Verificador.getVerificador();
	}
	
	protected TextField nuevoTextField(int x, int y){
		TextField campo = new TextField();
		campo.setBackground(new Color(245, 245, 245));
		campo.setFont(new Font("Calibri", Font.PLAIN, 19));
		campo.setBounds(x, y, 150, 30);
		return campo;
	}
	
	
	protected JButton nuevoBoton(int x, int y, String txt){
		JButton boton = new JButton(txt);
		boton.setBackground(new Color(245, 245, 245));
		boton.setFont(new Font("Calibri", Font.PLAIN, 18));
		boton.setBounds(x, y, 150, 30);
		return boton;
	}
	

}
