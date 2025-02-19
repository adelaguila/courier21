package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.tables.ClienteProveedorTableDTO;
import pe.datasys.courier21.model.ClienteProveedor;

import java.util.List;

public interface IClienteProveedorService extends ICRUD<ClienteProveedor, Long>{
    Page<ClienteProveedorTableDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);

    ClienteProveedor findOneByNumeroDocumentoIdentidad(String numeroDocumentoIdentidad);

    List<ClienteProveedor> getAutocomplete(String term);
}
