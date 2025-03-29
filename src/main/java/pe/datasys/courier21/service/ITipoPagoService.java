package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.TipoPagoDTO;
import pe.datasys.courier21.model.TipoPago;

import java.util.List;

public interface ITipoPagoService extends ICRUD<TipoPago, Integer>{
    Page<TipoPagoDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);
}

