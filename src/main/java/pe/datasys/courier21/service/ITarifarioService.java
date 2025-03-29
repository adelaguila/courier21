package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.tables.TarifarioTableDTO;
import pe.datasys.courier21.model.Tarifario;

import java.util.List;

public interface ITarifarioService extends ICRUD<Tarifario, Long>{
    Page<TarifarioTableDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);

    List<Tarifario> getTarifasGeneral();
    List<Tarifario> getTarifasCliente(Long idClienteProveedor);

}

