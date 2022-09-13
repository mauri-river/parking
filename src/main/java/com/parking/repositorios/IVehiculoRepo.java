package com.parking.repositorios;

/**
 *
 * @author franc
 */
import com.parking.entidades.Vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepo extends JpaRepository<Vehiculo, Integer>{
    
    public List<Vehiculo> findByTipoContaining(String criterio);
    
}
