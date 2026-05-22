package com.concesionaria.persistencia;

import com.concesionaria.logica.Marca;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.concesionaria.logica.Automovil;
import java.util.List;

public class ControladoraPersistencia {


    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("AutoPU");

    private final AutomovilJpaController autoJpa;
    private final  MarcaJpaController marcaJpa;


    public ControladoraPersistencia() {
        autoJpa = new AutomovilJpaController(EMF);
        marcaJpa = new MarcaJpaController(EMF);
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

    public void crearMarca(Marca marca) {
        try {
            marcaJpa.create(marca);
        } catch (Exception e) {
            System.out.println("Error al crear la marca: " + e.getMessage());
        }
    }

    public List<Marca> listarMarcas() {
        return marcaJpa.findAll();
    }

    public Marca buscarMarca(Integer idMarca) {
        return marcaJpa.findById(idMarca);
    }

    public Marca buscarMarcaPorNombre(String nombreMarca) {
        List<Marca> todas = listarMarcas();
        for (Marca m : todas) {
            if (m.getNombre().equalsIgnoreCase(nombreMarca.trim())) {
                return m;
            }
        }
        return null;
    }

    public static void cerrarTodo() {
        if (EMF != null && EMF.isOpen()) {
            EMF.close();
        }
    }
}