package com.concesionaria.igu;

import com.concesionaria.logica.Controladora;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroAutomovil extends JFrame {

    Controladora control = new Controladora();
    private JPanel panel1;
    private JTextField txtModelo;
    private JButton btnLimpiar;
    private JButton btnAgregar;
    private JTextField txtMarca;
    private JTextField txtMotor;
    private JTextField txtColor;
    private JTextField txtPlaca;
    private JTextField txtCantPuertas;

    public RegistroAutomovil(){
        setTitle("Panel de Registro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String modelo = txtModelo.getText();
                String marca = txtMarca.getText();
                String motor = txtMotor.getText();
                String color = txtColor.getText();
                String placa = txtPlaca.getText();

                try {
                    int cantPuertas = Integer.parseInt(txtCantPuertas.getText());
                    control.agregarAutomovil(modelo, marca, motor, color, placa, cantPuertas);


                    Mensaje.mostrar("Guardado con éxito", "Info", "Registro Exitoso");


                } catch (NumberFormatException ex) {
                    Mensaje.mostrar(   "La cantidad de puertas debe ser un número entero", "Error", "Error de datos");
                }
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
}
