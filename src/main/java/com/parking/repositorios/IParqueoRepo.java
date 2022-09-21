package com.parking.repositorios;

/**
 *
 * @author franc
 */
import com.parking.entidades.Parqueo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParqueoRepo extends JpaRepository<Parqueo, Integer>{
    
    public List<Parqueo> findByNombreContainigOrDocumentoContaining(String c1, String c2);
    public List<Parqueo> findByVehiculoNombreIs(String vehiculo);        
}
