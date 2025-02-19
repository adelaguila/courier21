package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.TipoAgenciaDTO;
import pe.datasys.courier21.dto.TipoClienteProveedorDTO;
import pe.datasys.courier21.model.TipoAgencia;

import java.util.List;

public interface ITipoAgenciaService extends ICRUD<TipoAgencia, Integer>{

    Page<TipoAgenciaDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);


}

