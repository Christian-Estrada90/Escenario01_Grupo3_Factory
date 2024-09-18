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
        btn_Agregar_Vehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarVehiculo();
            }
        });

        // Ajustar el tamaño del JComboBox
        cmb_tipoVehiculo.setPreferredSize(new java.awt.Dimension(200, cmb_tipoVehiculo.getPreferredSize().height));
    }

    private void agregarVehiculo() {
        try {
            String tipoVehiculo = (String) cmb_tipoVehiculo.getSelectedItem();
            String marca = txt_marca.getText();
            String modelo = txt_modelo.getText();
            String placa = txt_placa.getText();
            int cilindraje = Integer.parseInt(txt_cilindraje.getText());
            double avaluo = Double.parseDouble(txt_avaluo.getText());
            double impuesto = Double.parseDouble(txt_impuesto.getText());

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
            txt_marca.setText("");
            txt_modelo.setText("");
            txt_placa.setText("");
            txt_cilindraje.setText("");
            txt_avaluo.setText("");
            txt_impuesto.setText("");

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

        cmb_tipoVehiculo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btn_Agregar_Vehiculo = new javax.swing.JButton();
        txt_marca = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_placa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbl_cilindraje = new javax.swing.JLabel();
        txt_cilindraje = new javax.swing.JTextField();
        lbl_avaluo = new javax.swing.JLabel();
        txt_avaluo = new javax.swing.JTextField();
        lbl_impuesto = new javax.swing.JLabel();
        txt_impuesto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmb_tipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "auto", "camioneta", "camion" }));

        jLabel1.setText("Tipo Vehiculo:");

        btn_Agregar_Vehiculo.setText("Agregar Vehiculo");

        jLabel2.setText("Marca:");

        jLabel3.setText("Modelo:");

        jLabel4.setText("Placa:");

        lbl_cilindraje.setText("Cilindraje:");

        lbl_avaluo.setText("Avalúo:");

        lbl_impuesto.setText("Impuesto:");

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
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(lbl_cilindraje)
                                    .addComponent(lbl_avaluo)
                                    .addComponent(lbl_impuesto))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmb_tipoVehiculo, 0, 200, Short.MAX_VALUE)
                                    .addComponent(txt_marca)
                                    .addComponent(txt_modelo)
                                    .addComponent(txt_placa)
                                    .addComponent(txt_cilindraje)
                                    .addComponent(txt_avaluo)
                                    .addComponent(txt_impuesto)))
                            .addComponent(btn_Agregar_Vehiculo))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmb_tipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_cilindraje)
                    .addComponent(txt_cilindraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_avaluo)
                    .addComponent(txt_avaluo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_impuesto)
                    .addComponent(txt_impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Agregar_Vehiculo)
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
                   
    private javax.swing.JButton btn_Agregar_Vehiculo;
    private javax.swing.JComboBox<String> cmb_tipoVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_placa;
    private javax.swing.JLabel lbl_cilindraje;
    private javax.swing.JTextField txt_cilindraje;
    private javax.swing.JLabel lbl_avaluo;
    private javax.swing.JTextField txt_avaluo;
    private javax.swing.JLabel lbl_impuesto;
    private javax.swing.JTextField txt_impuesto;    
}