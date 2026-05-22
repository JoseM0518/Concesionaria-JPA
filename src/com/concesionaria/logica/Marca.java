package com.concesionaria.logica;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "marcas")
public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    public Marca() {
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Marca(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
