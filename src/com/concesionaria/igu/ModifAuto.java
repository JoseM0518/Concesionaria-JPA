package com.concesionaria.igu;

import com.concesionaria.logica.Automovil;
import com.concesionaria.logica.Controladora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifAuto extends JFrame  {

    Controladora control = new Controladora();
    Automovil auto = new Automovil();
    private JPanel panel1;
    private JTextField txtMarca;
    private JTextField txtMotor;
    private JTextField txtColor;
    private JTextField txtPlaca;
    private JTextField txtCantPuertas;
    private JTextField txtModelo;
    private JButton btnModificar;
    private JButton btnLimpiar;

    public ModifAuto(Long idAuto) {

        setTitle("Panel modificar");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);

        cargarDatosAuto(idAuto);
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String modelo = txtModelo.getText();
                String nombreMarca = txtMarca.getText();
                String motor = txtMotor.getText();
                String color = txtColor.getText();
                String placa = txtPlaca.getText();

                try {
                    int cantPuertas = Integer.parseInt(txtCantPuertas.getText());
                    control.modificarAuto(auto, modelo, nombreMarca, motor, color, placa, cantPuertas);


                    Mensaje.mostrar("Guardado con éxito", "Info", "Edición Exitosa");
                    dispose();


                } catch (NumberFormatException ex) {
                    Mensaje.mostrar(   "La cantidad de puertas debe ser un número entero", "Error", "Error de datos");
                }

                ConsultaAutomovil consul = new ConsultaAutomovil();
                consul.setVisible(true);
                consul.setLocationRelativeTo(null);

            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtModelo.setText("");
                txtMarca.setText("");
                txtMotor.setText("");
                txtColor.setText("");
                txtPlaca.setText("");
                txtCantPuertas.setText("");
            }
        });
    }

    private void cargarDatosAuto(Long idAuto) {

        auto = control.traerAuto(idAuto);
        txtModelo.setText(auto.getModelo());
        txtMarca.setText(auto.getMarca().getNombre());
        txtMotor.setText(auto.getMotor());
        txtColor.setText(auto.getColor());
        txtPlaca.setText(auto.getPlaca());
        txtCantPuertas.setText(String.valueOf(auto.getCantPuertas()));

    }
}
