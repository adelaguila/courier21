package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.TipoOrdenServicioDTO;
import pe.datasys.courier21.model.TipoOrdenServicio;

import java.util.List;

public interface ITipoOrdenServicioService extends ICRUD<TipoOrdenServicio, Integer>{
    Page<TipoOrdenServicioDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);
}

