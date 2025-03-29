package pe.datasys.courier21.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.datasys.courier21.model.Tarifario;

import java.util.List;

public interface ITarifarioRepo extends IGenericRepo<Tarifario, Long> {

    @Query("FROM Tarifario t WHERE t.clienteProveedor.idClienteProveedor IS NULL")
    List<Tarifario> getTarifasGenerales();

    @Query("FROM Tarifario t WHERE t.clienteProveedor.idClienteProveedor = :idClienteProveedor")
    List<Tarifario> getTarifasCliente(@Param("idClienteProveedor") Long idClienteProveedor);


}
