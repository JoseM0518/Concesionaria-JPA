package com.concesionaria.persistencia;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.concesionaria.logica.Automovil;
import java.util.List;

public class ControladoraPersistencia {


    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("AutoPU");

    private final AutomovilJpaController autoJpa;


    public ControladoraPersistencia() {
        autoJpa = new AutomovilJpaController(EMF);
    }


    public void agregarAutomovil(Automovil auto) { autoJpa.create(auto); }
    public void eliminar(Long idAuto) {
        try {
            autoJpa.destroy(idAuto);
        } catch (Exception e) {
            System.out.println("Error al eliminar: El registro no existe.");
        }
    }
    public void editar(Automovil auto) {
        try {
            autoJpa.edit(auto);
        } catch (Exception e) {
            System.out.println("Error al editar: Auto no existe o datos inválidos");
        }
    }
    public List<Automovil> listar() { return autoJpa.findAll(); }
    public Automovil buscar(Long idAuto) { return autoJpa.findById(idAuto); }


    public static void cerrarTodo() {
        if (EMF != null && EMF.isOpen()) {
            EMF.close();
        }
    }
}