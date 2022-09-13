package com.parking.servicios;

import com.parking.entidades.Vehiculo;
import com.parking.repositorios.IVehiculoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */

@Service
public class VehiculoServi {
    
    @Autowired
    private IVehiculoRepo rep;
    
    public Vehiculo crearNuevoVehiculo(Vehiculo v) {
        Vehiculo vehi= rep.save(v);
        return vehi;
    }
    
    public List<Vehiculo> consultarVehiculo() {
        List<Vehiculo> lista = rep.findAll();
        return lista;
    }
    
    public List<Vehiculo> consultarVehiculo(String criterio) {
        List<Vehiculo> lista = rep.findByTipoContaining(criterio);
        return lista;
    }
    
    public Vehiculo consultarVehiculo(int id) {
        Vehiculo v = rep.findById(id).get();
        return v;
    }
    
    public Vehiculo actualizarVehiculo(Vehiculo v) {
        Vehiculo vehi= rep.save(v);
        return vehi;
    }
    
    public void eliminarVehiculo(Vehiculo v) {
        rep.deleteById(v.getId());
    }
}
