package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ventanaFactura extends VentanaModelo {
    private JPanel contentPane;
    private JTable table;
    private JLabel lblLogin;
    private JLabel lblNombreCliente;
    private JLabel lblDireccion;
    private JLabel lblTelefono;
    private JLabel lblfecha;        
    private JLabel lblIVA;
    private JLabel lbltotal;
    private JLabel lblValorNombreCliente;
    private JLabel lblValorDireccion;        
    private JLabel lblValorTelefono;
    private JLabel lblValorfecha;
    private JLabel lblValorIVA;
    private JLabel lblValortotal;        
            
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ventanaFactura frame = new ventanaFactura();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ventanaFactura() {
        super("Factura");
               
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 150, 870, 360);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
     
        lblLogin = new JLabel("Factura");
        lblLogin.setFont(fuenteTitulo);
	lblLogin.setBounds(380, 20, 100, 24);
	contentPane.add(lblLogin);
		
	lblNombreCliente = new JLabel("Nombre:");
	lblNombreCliente.setFont(fuenteSubTitulo);
	lblNombreCliente.setBounds(14, 40, 100, 24);
	contentPane.add(lblNombreCliente);
             
        lblDireccion = new JLabel("Direccion:");
	lblDireccion.setFont(fuenteSubTitulo);
	lblDireccion.setBounds(14, 70, 120, 24);
	contentPane.add(lblDireccion); 
        
        lblTelefono = new JLabel("Telefono:");
	lblTelefono.setFont(fuenteSubTitulo);
	lblTelefono.setBounds(14, 100, 100, 24);
	contentPane.add(lblTelefono); 
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 130, 830, 80);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "FECHA", "ESTADO", "COMBUSTIBLE", "TIPO DE CAJA", "NUM. CHASIS", "COLOR", "FABRICANTE", "PROVEEDOR", "COSTO UNITARIO", "GARANTIA"}
        ));
        scrollPane.setViewportView(table);
        
        lblfecha = new JLabel("Fecha:");
	lblfecha.setFont(fuenteSubTitulo);
	lblfecha.setBounds(18, 220, 100, 24);
	contentPane.add(lblfecha); 
        
        lblIVA = new JLabel("% IVA:");
	lblIVA.setFont(fuenteSubTitulo);
	lblIVA.setBounds(18, 250, 100, 24);
	contentPane.add(lblIVA); 
        
        lbltotal = new JLabel("TOTAL:");
	lbltotal.setFont(fuenteSubTitulo);
	lbltotal.setBounds(18, 280, 100, 24);
	contentPane.add(lbltotal); 
        
        //para mostrar los valores de la BD
        lblValorNombreCliente = new JLabel();
	lblValorNombreCliente.setFont(fuenteTextField);
	lblValorNombreCliente.setBounds(130, 40, 100, 24);
	contentPane.add(lblValorNombreCliente);
             
        lblValorDireccion = new JLabel();
	lblValorDireccion.setFont(fuenteTextField);
	lblValorDireccion.setBounds(130, 70, 120, 24);
	contentPane.add(lblValorDireccion); 
        
        lblValorTelefono = new JLabel();
	lblValorTelefono.setFont(fuenteTextField);
	lblValorTelefono.setBounds(130, 100, 100, 24);
	contentPane.add(lblValorTelefono);
        
        lblValorfecha = new JLabel();
	lblValorfecha.setFont(fuenteTextField);
	lblValorfecha.setBounds(130, 220, 100, 24);
	contentPane.add(lblValorfecha); 
        
        lblValorIVA = new JLabel();
	lblValorIVA.setFont(fuenteTextField);
	lblValorIVA.setBounds(130, 250, 100, 24);
	contentPane.add(lblValorIVA); 
        
        lblValortotal = new JLabel();
	lblValortotal.setFont(fuenteTextField);
	lblValortotal.setBounds(130, 280, 100, 24);
	contentPane.add(lblValortotal);
    }
    
    public void setValorNombreCliente(String val) { lblValorNombreCliente.setText(val); };
    public void setValorDireccionCliente(String val) { lblValorDireccion.setText(val); };
    public void setValorTelefonoCliente(String val) { lblValorTelefono.setText(val); };
    public void setValorFecha(String val) { lblValorfecha.setText(val); };
    public void setValorIVA(String val) { lblValorIVA.setText(val); };
    public void setValorTotal(String val) { lblValortotal.setText(val); };
        
}