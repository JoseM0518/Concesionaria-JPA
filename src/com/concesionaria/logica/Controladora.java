package com.concesionaria.logica;

import com.concesionaria.persistencia.ControladoraPersistencia;

import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    public void agregarAutomovil(String modelo, String nombreMarca, String motor, String color, String placa, int cantPuertas) {

        Marca marcaFinal = controlPersis.buscarMarcaPorNombre(nombreMarca);
        if (marcaFinal == null) {
            marcaFinal = new Marca(nombreMarca);
            controlPersis.crearMarca(marcaFinal);
        }
        Automovil auto = new Automovil(modelo, marcaFinal, motor, color, placa, cantPuertas);
        controlPersis.agregarAutomovil(auto);
    }

    public List<Automovil> traerAutos() {

        return controlPersis.listar();

    }

    public void borrarAutos(Long idAuto) {

        controlPersis.eliminar(idAuto);
    }

    public Automovil traerAuto(Long idAuto) {

        return controlPersis.buscar(idAuto);
    }

    public void modificarAuto(Automovil auto, String modelo, String nombreMarca, String motor,String color, String placa, int cantPuertas) {

        auto.setColor(color);
        auto.setModelo(modelo);
        auto.setMotor(motor);
        auto.setPlaca(placa);
        auto.setCantPuertas(cantPuertas);

        Marca marcaFinal = controlPersis.buscarMarcaPorNombre(nombreMarca);
        if (marcaFinal == null) {
            marcaFinal = new Marca(nombreMarca);
            controlPersis.crearMarca(marcaFinal);
        }

        auto.setMarca(marcaFinal);
        controlPersis.editar(auto);
    }
}
