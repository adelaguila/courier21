package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.TipoEmbalajeDTO;
import pe.datasys.courier21.model.TipoEmbalaje;

import java.util.List;

public interface ITipoEmbalajeService extends ICRUD<TipoEmbalaje, Integer>{
    Page<TipoEmbalajeDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);
}

