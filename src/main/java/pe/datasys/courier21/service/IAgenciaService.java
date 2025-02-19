package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.AgenciaDTO;
import pe.datasys.courier21.model.Agencia;

import java.util.List;


public interface IAgenciaService extends ICRUD<Agencia, Integer>{

    Agencia findOneByCodigo(String codigo);

    Page<AgenciaDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);

}
