
package com.parking.servicios;

import com.parking.entidades.Parqueo;
import com.parking.repositorios.IParqueoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author franc
 */

public class ParqueoServi {
    
    @Autowired
    private IParqueoRepo parqueoRepo;
    
    public List<Parqueo> listarParqueos() {
        return parqueoRepo.findAll();
    }
    
    public List<Parqueo> listarParqueos(String criterio) {
        return parqueoRepo.findByNombreContainigOrDocumentoContaining(criterio, criterio);
    }
    
    public List<Parqueo> listarParqueosPorVehiculo(String vehiculo) {
        return parqueoRepo.findByVehiculoNombreIs(vehiculo);
    }
    
    public Parqueo guardarParqueo(Parqueo p) {
        return parqueoRepo.save(p);
    }
    
    public Parqueo getParqueo(int id) {
        return parqueoRepo.findById(id).orElse(null);
    }
    
    public boolean eliminarParqueo(int id) {
        Parqueo p = parqueoRepo.findById(id).orElse(null);
        if (p == null) {
            return false;
        }
        else {
            parqueoRepo.delete(p);
            return true;
        }
    }
}
