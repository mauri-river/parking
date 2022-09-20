package com.parking;

import com.parking.entidades.Vehiculo;
import com.parking.servicios.VehiculoServi;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
class ParkingApplicationTests {

    @Autowired
    private VehiculoServi servicio;
    
    //----------PRUEBAS DE CREACIÓN-----------
    @Test
    @Disabled
    void probarNuevoVehiculo() {
        Vehiculo v = new Vehiculo("Carro", "YUI485");
        Assertions.assertDoesNotThrow(() -> {
            servicio.crearNuevoVehiculo(v); 
        }, "Error al guardar nuevo vehiculo. ");    
    }
    
    @Test
    @Disabled
    void probarSiNoSeCreaUnVehiculoRepetido() {
        Vehiculo v = new Vehiculo("Moto", "WER54G");
        Assertions.assertThrows(DataIntegrityViolationException.class,() -> {
            servicio.crearNuevoVehiculo(v); 
        }, "Se esperaba error de violación de integidad");    
    }
    
//   //----------PRUEBAS DE BÚSQUEDA-------------
    @Test
    @Disabled
    void pruebaDeConsulta () {
        List<Vehiculo> lista = servicio.consultarVehiculo();
        Assertions.assertTrue(lista.size() > 0, "ERROR, No se encontró el vehículo con el nombre Moto");
    }
    
    @Test
    @Disabled
    void pruebaSiSeEncuentraVehiculoEspecifico() {
        List<Vehiculo> lista = servicio.consultarVehiculo("Moto");
        Assertions.assertTrue(lista.size() > 0, "ERROR, No se encontró el vehículo con el nombre Moto");
    }
    
    @Test
    @Disabled
    void pruebaDeConsultaPorId() {
        Vehiculo encontrado = servicio.consultarVehiculo(1);
        Assertions.assertNotNull(encontrado, "ERROR, No se encontró el vehículo con el id 1");
    }
    
    @Test
    @Disabled
    void pruebaSiNoSeEncuentraVehiculoConId() {
        Vehiculo encontrado = servicio.consultarVehiculo(150000);
        Assertions.assertNull(encontrado, "ERROR, No existe el vehículo con el id 150000");
    }
    
    //-----------PRUEBA DE ACTUALIZACIÓN-----------------

    @Test
    @Disabled
    void probarSiNoActualizaUnVehiculoExistenteConDataInvalida() {
        Vehiculo encontrado = servicio.consultarVehiculo(1);
        encontrado.setPlaca(null);
        Assertions.assertThrows(DataIntegrityViolationException.class,() -> {
            servicio.actualizarVehiculo(encontrado);
        }, "Se esperaba error de violación de integridad de datos");
    }
}
