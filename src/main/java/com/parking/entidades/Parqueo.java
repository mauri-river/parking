package com.parking.entidades;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author franc
 */

@Entity
@Table(name = "tparqueos")
public class Parqueo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombreUsuario", nullable = false, unique = true, length = 80)
    private String nombreUsuario;
    
    @Column(name = "documento", nullable = false, unique = true, length = 10)
    private String documento;
    
    @Column(name = "horaEntrada", nullable = false)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime horaEntrada;
    
    @Column(name = "horaSalida", nullable = false)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime horaSalida;
    
    @OneToOne()
    @JoinColumn(name = "tipoVeliculo")
    private Vehiculo tipoVehiculo;
    
    
    // Métodos constructores

    public Parqueo() {
    }

    public Parqueo(String nombreUsuario, String documento, LocalTime horaEntrada, LocalTime horaSalida, Vehiculo tipoVehiculo) {
        this.nombreUsuario = nombreUsuario;
        this.documento = documento;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Parqueo(int id, String nombreUsuario, String documento, LocalTime horaEntrada, LocalTime horaSalida, Vehiculo tipoVehiculo) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.documento = documento;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.tipoVehiculo = tipoVehiculo;
    }

    // GET
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Vehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(Vehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    
}
