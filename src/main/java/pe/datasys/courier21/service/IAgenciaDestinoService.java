package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.tables.AgenciaDestinoTableDTO;
import pe.datasys.courier21.model.AgenciaDestino;

import java.util.List;

public interface IAgenciaDestinoService extends ICRUD<AgenciaDestino, Integer>{

    List<AgenciaDestino> findByAgenciaIdAgencia(Integer idAgencia);

    Page<AgenciaDestinoTableDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);

}
