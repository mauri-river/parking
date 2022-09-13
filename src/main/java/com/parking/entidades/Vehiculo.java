package com.parking.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author franc
 */
@Entity(name="tvehiculos")
public class Vehiculo {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;
    
    @Column(name = "placa", nullable = false, length = 30)
    private String placa;

    
    //Metodos constructores
    public Vehiculo() {
    }

    public Vehiculo(int id, String tipo, String placa) {
        this.id = id;
        this.tipo = tipo;
        this.placa = placa;
    }

    public Vehiculo(String tipo, String placa) {
        this.tipo = tipo;
        this.placa = placa;
    }

    
    
    //Metodos get() y set()
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
    
    
    
}
