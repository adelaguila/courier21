package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.TipoServicioDTO;
import pe.datasys.courier21.model.TipoServicio;

import java.util.List;

public interface ITipoServicioService extends ICRUD<TipoServicio, Integer>{
    Page<TipoServicioDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);
}

