package com.parking;

import com.parking.entidades.Vehiculo;
import com.parking.servicios.VehiculoServi;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ParkingApplicationTests {

    @Autowired
    private VehiculoServi servicio;
            
    @Test
    @Disabled
    void probarNuevoVehiculo() {
        Vehiculo v = new Vehiculo("Moto", "WER54G");
        Vehiculo registrado = servicio.crearNuevoVehiculo(v);
        Assertions.assertTrue(registrado.getId() > 0, "ERROR, No se guardó el nuevo objeto");
    }
    
    @Test
    @Disabled
    void pruebaDeConsulta () {
        List<Vehiculo> lista = servicio.consultarVehiculo("Moto");
        Assertions.assertTrue(lista.size() > 0, "ERROR, No se encontró el vehículo con el nombre Moto");
    }
}
