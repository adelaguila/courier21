package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.SunatTipoDocumentoIdentidadDTO;
import pe.datasys.courier21.dto.TipoClienteProveedorDTO;
import pe.datasys.courier21.model.SunatTipoDocumentoIdentidad;

import java.util.List;

public interface ISunatTipoDocumentoIdentidadService extends ICRUD<SunatTipoDocumentoIdentidad, String>{
    Page<SunatTipoDocumentoIdentidadDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);

}
