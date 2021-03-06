package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Inventario extends VentanaModelo {

    private JPanel contentPane;
    private JTable table;
    private JButton btnEditar, btnEliminar, btnAgregar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Inventario frame = new Inventario();
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
    public Inventario() {
        super("Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 459);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnEditar = nuevoBoton(700, 386, "Editar");
        contentPane.add(btnEditar);

        btnEliminar = nuevoBoton(540, 386, "Eliminar");
        contentPane.add(btnEliminar);

        btnAgregar = nuevoBoton(380, 386, "Agregar");
        contentPane.add(btnAgregar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 930, 369);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "FECHA", "ESTADO", "COMBUSTIBLE", "TIPO DE CAJA", "NUM. CHASIS", "COLOR", "FABRICANTE", "DESCRIPCION", "COSTO UNITARIO", "CANTIDAD", "PROVEEDOR", "ALMACEN","OBSERVACIONES"
                }
        ));
        scrollPane.setViewportView(table);
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }
    
    public JButton getBtnEliminar() {
        return btnEliminar;
    }
    public JButton getBtnAgregar() {
        return btnAgregar;
    }
    
    
}
