package com.concesionaria.igu;

import com.concesionaria.logica.Automovil;
import com.concesionaria.logica.Controladora;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class ConsultaAutomovil extends JFrame {

    Controladora control = new Controladora();

    private JPanel panel1;
    private JTable tblAutos;
    private JButton btnModificar;
    private JButton btnEliminar;


    private DefaultTableModel modelo;

    public ConsultaAutomovil() {
        setTitle("Panel de Consulta");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panel1);


        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent e) {
                cargarTabla();
            }
        });

        pack();
        setLocationRelativeTo(null);

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tblAutos.getRowCount() > 0) {
                    if (tblAutos.getSelectedRow() != -1) {

                        long idAuto = Long.parseLong(String.valueOf(tblAutos.getValueAt(tblAutos.getSelectedRow(), 0)));
                        control.borrarAutos(idAuto);
                        Mensaje.mostrar("Auto borrado correctamente", "Info", "Borrado exitoso");
                        cargarTabla();
                    } else {

                        Mensaje.mostrar("No seleccionó un registro para eliminar", "Error", "Error al eliminar");
                    }
                } else {

                    Mensaje.mostrar("La tabla está vacía, no se puede eliminar ", "Error", "Error al eliminar");
                }
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tblAutos.getRowCount() > 0) {
                    if (tblAutos.getSelectedRow() != -1) {

                        long idAuto = Long.parseLong(String.valueOf(tblAutos.getValueAt(tblAutos.getSelectedRow(), 0)));
                        ModifAuto modif = new ModifAuto(idAuto);
                        modif.setVisible(true);
                        ConsultaAutomovil.this.dispose();


                    } else {
                        Mensaje.mostrar("No seleccionó un registro para modificar", "Error", "Error al modificar");
                    }
                } else {
                    Mensaje.mostrar("La tabla está vacía", "Error", "Error al modificar");
                }
            }
        });
    }

    private void cargarTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        String titulos[] = {"ID", "Modelo", "Marca", "Motor", "Color", "Placa", "Puertas"};
        modeloTabla.setColumnIdentifiers(titulos);

        List<Automovil> listaAutomoviles = control.traerAutos();
        if (listaAutomoviles != null) {

            for (Automovil auto : listaAutomoviles) {
                Object[] objeto = {auto.getId(), auto.getModelo(), auto.getMarca(), auto.getMotor(),
                        auto.getColor(), auto.getPlaca(), auto.getCantPuertas()};

                modeloTabla.addRow(objeto);
            }
        }


        tblAutos.setModel(modeloTabla);
        tblAutos.getTableHeader().setReorderingAllowed(false);
        tblAutos.getTableHeader().setResizingAllowed(false);
    }
}
