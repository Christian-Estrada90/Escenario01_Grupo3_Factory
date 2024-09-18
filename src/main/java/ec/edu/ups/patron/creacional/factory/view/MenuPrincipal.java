package ec.edu.ups.patron.creacional.factory.view;

import ec.edu.ups.patron.creacional.factory.controller.VehiculoFactory;
import ec.edu.ups.patron.creacional.factory.model.Vehiculo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * @author Grupo 3
 */
public class MenuPrincipal extends javax.swing.JFrame {

    private Vector<Vehiculo> vehiculos;

    public MenuPrincipal() {
        initComponents();
        vehiculos = new Vector<>();

        // Acción para el botón "Agregar Vehiculo"
        btnAgregarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarVehiculo();
            }
        });

        // Ajustar el tamaño del JComboBox
        cmbTipoVehiculo.setPreferredSize(new java.awt.Dimension(200, cmbTipoVehiculo.getPreferredSize().height));
    }

    private void agregarVehiculo() {
        try {
            String tipoVehiculo = (String) cmbTipoVehiculo.getSelectedItem();
            String marca = txtMarca.getText();
            String modelo = txtModelo.getText();
            String placa = txtPlaca.getText();
            int cilindraje = Integer.parseInt(txtCilindraje.getText());
            double avaluo = Double.parseDouble(txtAvaluo.getText());
            double impuesto = Double.parseDouble(txtImpuesto.getText());

            // Creación del vehículo utilizando la fábrica
            VehiculoFactory vehiculoFactory = new VehiculoFactory();
            Vehiculo vehiculo = vehiculoFactory.crearVehiculoFactory(tipoVehiculo);
            vehiculo.setMarca(marca);
            vehiculo.setModelo(modelo);
            vehiculo.setPlaca(placa);
            vehiculo.setCilindraje(cilindraje);
            vehiculo.setAvaluo(avaluo);
            vehiculo.setImpuesto(impuesto);
            vehiculos.add(vehiculo);

            // Actualizar la tabla con los vehículos añadidos
            actualizarTabla();

            // Limpiar los campos de texto
            txtMarca.setText("");
            txtModelo.setText("");
            txtPlaca.setText("");
            txtCilindraje.setText("");
            txtAvaluo.setText("");
            txtImpuesto.setText("");

            JOptionPane.showMessageDialog(this, "Vehículo agregado exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos en todos los campos numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar la tabla

        for (Vehiculo vehiculo : vehiculos) {
            // Obtener el costo de la matrícula y el tipo de vehículo
            double costoMatricula = vehiculo.costoMatricula();
            String tipoVehiculo = vehiculo.getClass().getSimpleName(); // Obtiene el tipo de vehículo

            // Añade una fila a la tabla con el costo de matrícula y el tipo de vehículo
            model.addRow(new Object[]{vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getPlaca(), vehiculo.getCilindraje(), vehiculo.getAvaluo(), vehiculo.getImpuesto(), costoMatricula, tipoVehiculo});
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        cmbTipoVehiculo = new javax.swing.JComboBox<>();
        lblTipoVehiculo = new javax.swing.JLabel();
        btnAgregarVehiculo = new javax.swing.JButton();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblCilindraje = new javax.swing.JLabel();
        txtCilindraje = new javax.swing.JTextField();
        lblAvaluo = new javax.swing.JLabel();
        txtAvaluo = new javax.swing.JTextField();
        lblImpuesto = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "auto", "camioneta", "camion" }));

        lblTipoVehiculo.setText("Tipo Vehiculo:");

        btnAgregarVehiculo.setText("Agregar Vehiculo");

        lblMarca.setText("Marca:");

        lblModelo.setText("Modelo:");

        lblPlaca.setText("Placa:");

        lblCilindraje.setText("Cilindraje:");

        lblAvaluo.setText("Avalúo:");

        lblImpuesto.setText("Impuesto:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Marca", "Modelo", "Placa", "Cilindraje", "Avalúo", "Impuesto", "Costo Matrícula", "Tipo Vehículo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTipoVehiculo)
                                    .addComponent(lblMarca)
                                    .addComponent(lblModelo)
                                    .addComponent(lblPlaca)
                                    .addComponent(lblCilindraje)
                                    .addComponent(lblAvaluo)
                                    .addComponent(lblImpuesto))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbTipoVehiculo, 0, 200, Short.MAX_VALUE)
                                    .addComponent(txtMarca)
                                    .addComponent(txtModelo)
                                    .addComponent(txtPlaca)
                                    .addComponent(txtCilindraje)
                                    .addComponent(txtAvaluo)
                                    .addComponent(txtImpuesto)))
                            .addComponent(btnAgregarVehiculo))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoVehiculo)
                    .addComponent(cmbTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCilindraje)
                    .addComponent(txtCilindraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvaluo)
                    .addComponent(txtAvaluo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImpuesto)
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarVehiculo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }
                   
    private javax.swing.JButton btnAgregarVehiculo;
    private javax.swing.JComboBox<String> cmbTipoVehiculo;
    private javax.swing.JLabel lblTipoVehiculo;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JLabel lblCilindraje;
    private javax.swing.JTextField txtCilindraje;
    private javax.swing.JLabel lblAvaluo;
    private javax.swing.JTextField txtAvaluo;
    private javax.swing.JLabel lblImpuesto;
    private javax.swing.JTextField txtImpuesto;    
}