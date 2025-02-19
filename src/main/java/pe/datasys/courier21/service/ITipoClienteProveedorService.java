package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.TipoClienteProveedorDTO;
import pe.datasys.courier21.model.TipoClienteProveedor;

import java.util.List;

public interface ITipoClienteProveedorService extends ICRUD<TipoClienteProveedor, Integer>{

    Page<TipoClienteProveedorDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);

}

