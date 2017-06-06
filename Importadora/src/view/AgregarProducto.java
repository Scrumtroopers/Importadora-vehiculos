package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.AdministradorVentanas;

public class AgregarProducto extends VentanaModelo {

	private JPanel contentPane;
	private JTextField tfDescripcion;
	private JTextField tfNumChasis;
	private JTextField tfObservaciones;
	private JTextField tfCostoUnitario;
	private JTextField tfCantidad;
	private JTextField tfProveedor;
	private JComboBox cbEstado;
	private JComboBox cbModelo;
	private JComboBox cbCombustible;
	private JComboBox cbTipoCaja; 
	private JComboBox cbColor; 
	private JComboBox cbFabricante; 
	private JComboBox cbAlmacen; 
        private JButton btnGuardar;
        private JButton btnCancelar;
        
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarProducto frame = new AgregarProducto();
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
	public AgregarProducto() {
		super("Agregar Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblModelo.setBounds(10, 11, 77, 24);
		contentPane.add(lblModelo);
		
		tfDescripcion = new JTextField();	
		tfDescripcion.setFont(new Font("Calibri", Font.PLAIN, 19));
		tfDescripcion.setBounds(10, 210, 593, 30);
		contentPane.add(tfDescripcion);
		
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblEstado.setBounds(312, 11, 77, 24);
		contentPane.add(lblEstado);
		
		tfNumChasis =new JTextField();	
		tfNumChasis.setFont(new Font("Calibri", Font.PLAIN, 19));
		tfNumChasis.setBounds(156, 98, 139, 30);
		contentPane.add(tfNumChasis);
		
		JLabel lblCombustible = new JLabel("Combustible:");
		lblCombustible.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblCombustible.setBounds(10, 54, 112, 24);
		contentPane.add(lblCombustible);
		
		JLabel lblTipoDeCaja = new JLabel("Tipo de caja:");
		lblTipoDeCaja.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblTipoDeCaja.setBounds(312, 54, 112, 24);
		contentPane.add(lblTipoDeCaja);
		
		JLabel lblNumeroDeChasis = new JLabel("Numero de chasis:");
		lblNumeroDeChasis.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblNumeroDeChasis.setBounds(10, 101, 150, 24);
		contentPane.add(lblNumeroDeChasis);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblColor.setBounds(312, 101, 77, 24);
		contentPane.add(lblColor);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblFabricante.setBounds(10, 146, 112, 24);
		contentPane.add(lblFabricante);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblDescripcion.setBounds(10, 186, 112, 24);
		contentPane.add(lblDescripcion);
		
		JLabel lblCostoUnitario = new JLabel("Costo Unitario:");
		lblCostoUnitario.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblCostoUnitario.setBounds(10, 259, 139, 24);
		contentPane.add(lblCostoUnitario);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblCantidad.setBounds(312, 259, 112, 24);
		contentPane.add(lblCantidad);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblProveedor.setBounds(10, 304, 112, 24);
		contentPane.add(lblProveedor);
		
		JLabel lblOpvservaciones = new JLabel("Observaciones:");
		lblOpvservaciones.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblOpvservaciones.setBounds(10, 341, 139, 24);
		contentPane.add(lblOpvservaciones);
		
		
                String[] modelos = {"Serie 1","Serie 3","Serie 4","Serie 5","Serie 6","Serie 7"};
                cbModelo = new JComboBox(modelos);
		cbModelo.setFont(new Font("Calibri", Font.PLAIN, 19));
		cbModelo.setBounds(117, 8, 178, 30);
		contentPane.add(cbModelo);             
                                
		String[] estados = {"Nuevo","Neminuevo"};
		cbEstado = new JComboBox(estados);
		cbEstado.setFont(new Font("Calibri", Font.PLAIN, 19));
		cbEstado.setBounds(425, 8, 178, 30);
		contentPane.add(cbEstado);
		
                String[] combustibles = {"Gasolina","Diesel"};                 
		cbCombustible = new JComboBox(combustibles);
		cbCombustible.setFont(new Font("Calibri", Font.PLAIN, 19));		
		cbCombustible.setBounds(117, 50, 177, 30);
		contentPane.add(cbCombustible);
		
                
                String[] tipoCajas = {"Mecanica","Automatica"};
		cbTipoCaja = new JComboBox(tipoCajas);
		cbTipoCaja.setFont(new Font("Calibri", Font.PLAIN, 19));
		cbTipoCaja.setBounds(426, 50, 177, 30);
		contentPane.add(cbTipoCaja);
		
                String[] colores ={"Rojo","Verde","Negro","Azul","Blanco"}; 
		cbColor = new JComboBox(colores);
		cbColor.setFont(new Font("Calibri", Font.PLAIN, 19));
		cbColor.setBounds(426, 98, 177, 30);
		contentPane.add(cbColor);
		
                
                String[] fabricantes = {"BMW","Toyota","Bugatti","Alfa romeo","Chevrolet","Cadilac","Ford","Isuzu" };
		cbFabricante = new JComboBox(fabricantes);
		cbFabricante.setFont(new Font("Calibri", Font.PLAIN, 19));
		cbFabricante.setBounds(117, 142, 177, 30);
		contentPane.add(cbFabricante);
		
		tfObservaciones = new JTextField();
		tfObservaciones.setFont(new Font("Calibri", Font.PLAIN, 19));
		tfObservaciones.setBounds(10, 368, 593, 30);
		contentPane.add(tfObservaciones);
		
		btnCancelar = nuevoBoton(450, 404, "Cancelar");
		contentPane.add(btnCancelar);
		
		
		
		btnGuardar = nuevoBoton(290, 404, "Guardar");				
		contentPane.add(btnGuardar);
		
		
		tfCostoUnitario = new JTextField();	
		tfCostoUnitario.setFont(new Font("Calibri", Font.PLAIN, 19));	
		tfCostoUnitario.setBounds(132, 256, 163, 30);
		contentPane.add(tfCostoUnitario);
		
		tfCantidad = new JTextField();	
		tfCantidad.setFont(new Font("Calibri", Font.PLAIN, 19));		
		tfCantidad.setBounds(436, 252, 163, 30);
		contentPane.add(tfCantidad);
		
		tfProveedor = new JTextField();	
		tfProveedor.setFont(new Font("Calibri", Font.PLAIN, 19));		
		tfProveedor.setBounds(134, 300, 163, 30);
		contentPane.add(tfProveedor);
		
		JLabel lblAlmacen = new JLabel("Almacen:");
		lblAlmacen.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblAlmacen.setBounds(312, 304, 112, 24);
		contentPane.add(lblAlmacen);
		
		
		String[] almacenes = {"Sacaba","Cercado","Quillacollo"}; 
		cbAlmacen = new JComboBox(almacenes);
		cbAlmacen.setFont(new Font("Calibri", Font.PLAIN, 19));
		cbAlmacen.setBounds(425, 298, 177, 30);
		contentPane.add(cbAlmacen);
		
		restringirCampos();
	}
	
	private void restringirCampos(){
		verificador.SDec(tfCostoUnitario);
		verificador.SInt(tfCantidad);	
	}
			
        
        public JButton getBotonGuardar(){
            return btnGuardar;
        } 
	       
        public JButton getBotonCancelar(){
            return btnCancelar;
        } 
        
	public Object[] getDatos(){
		Object[] datos = new Object[15];
		/*datos[0]=1;
		datos[1]= new Date();
		datos[2]= cbModelo.getSelectedItem().toString();
		datos[3]= (String)cbEstado.getSelectedItem();
		datos[4]= (String)cbCombustible.getSelectedItem();
		datos[5]= (String)cbTipoCaja.getSelectedItem();
		datos[6]= tfNumChasis.getText();
		datos[7]= (String)cbColor.getSelectedItem();
		datos[8]= (String)cbFabricante.getSelectedItem();
		datos[9]= tfDescripcion.getText();
		datos[10]= verificador.getDouble(tfCostoUnitario);
		datos[11]= verificador.getInt(tfCantidad);		
		datos[12]= tfProveedor.getText();
		datos[13]= (String)cbAlmacen.getSelectedItem();
		datos[14]= tfObservaciones.getText();*/
		datos[2]= (String)cbModelo.getSelectedItem();
		datos[3]= (String)cbEstado.getSelectedItem();
		datos[4]= (String)cbCombustible.getSelectedItem();
		datos[5]= (String)cbTipoCaja.getSelectedItem();
		datos[6]= tfNumChasis.getText();
		datos[7]= (String)cbColor.getSelectedItem();
		datos[8]= (String)cbFabricante.getSelectedItem();
		datos[9]= tfDescripcion.getText();
		datos[10]= verificador.getDouble(tfCostoUnitario);
		datos[11]= verificador.getInt(tfCantidad);		
		datos[12]= tfProveedor.getText();
		datos[13]= (String)cbAlmacen.getSelectedItem();
		datos[14]= tfObservaciones.getText();
		return datos;
	}
}
