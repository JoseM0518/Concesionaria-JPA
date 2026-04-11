package com.concesionaria.igu;

import com.concesionaria.persistencia.ControladoraPersistencia;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame{
    private JPanel panel1;
    private JButton btnConsulta;
    private JButton btnSalir;
    private JButton btnRegistroAuto;

    public Principal(){
        setTitle("Panel de Control");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        pack();
        setLocationRelativeTo(null);

        btnRegistroAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroAutomovil registro = new RegistroAutomovil();
                registro.setVisible(true);
            }
        });
        btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaAutomovil consulAuto = new ConsultaAutomovil();
                consulAuto.setVisible(true);
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ControladoraPersistencia.cerrarTodo();
                System.exit(0);
            }
        });
    }
}
