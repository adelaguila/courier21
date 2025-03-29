package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.TipoEnvioDTO;
import pe.datasys.courier21.model.TipoEnvio;

import java.util.List;

public interface ITipoEnvioService extends ICRUD<TipoEnvio, Integer>{
    Page<TipoEnvioDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);
}

