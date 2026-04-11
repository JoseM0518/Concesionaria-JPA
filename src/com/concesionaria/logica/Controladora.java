package com.concesionaria.logica;

import com.concesionaria.persistencia.ControladoraPersistencia;

import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    public void agregarAutomovil(String modelo, String marca, String motor, String color, String placa, int cantPuertas) {

        Automovil auto = new Automovil();
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPlaca(placa);
        auto.setCantPuertas(cantPuertas);
        controlPersis.agregarAutomovil(auto);
    }

    public List<Automovil> traerAutos() {

        return controlPersis.listar();

    }

    public void borrarAutos(long idAuto) {

        controlPersis.eliminar(idAuto);
    }

    public Automovil traerAuto(long idAuto) {

        return controlPersis.buscar(idAuto);
    }

    public void modificarAuto(Automovil auto, String modelo, String marca, String motor,String color, String placa, int cantPuertas) {

        auto.setColor(color);
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setPlaca(placa);
        auto.setCantPuertas(cantPuertas);
        controlPersis.editar(auto);
    }
}
