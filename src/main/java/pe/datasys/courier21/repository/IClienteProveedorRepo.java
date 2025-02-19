package pe.datasys.courier21.repository;

import org.springframework.data.jpa.repository.Query;
import pe.datasys.courier21.model.ClienteProveedor;

import java.util.List;

public interface IClienteProveedorRepo extends IGenericRepo<ClienteProveedor, Long> {

    ClienteProveedor findOneByNumeroDocumentoIdentidad(String numeroDocumentoIdentidad);

    @Query("FROM ClienteProveedor c WHERE c.numeroDocumentoIdentidad LIKE :term OR c.nombreRazonSocial LIKE :term ORDER BY c.nombreRazonSocial")
    List<ClienteProveedor> getAutocomplete(String term);
}
