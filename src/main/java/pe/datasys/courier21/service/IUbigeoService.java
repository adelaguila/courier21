package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.UbigeoDTO;
import pe.datasys.courier21.model.Ubigeo;

import java.util.List;

public interface IUbigeoService extends ICRUD<Ubigeo, Integer>{

    Ubigeo findOneByCodigo(String codigo);

    List<Ubigeo> findByDistritoContains(String distrito);

    List<Ubigeo> getAutocomplete(String term);

    Page<UbigeoDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);

}

