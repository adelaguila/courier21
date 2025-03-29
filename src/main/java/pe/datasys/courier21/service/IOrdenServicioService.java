package pe.datasys.courier21.service;

import org.springframework.data.domain.Page;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.tables.OrdenServicioTableDTO;
import pe.datasys.courier21.model.OrdenServicio;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrdenServicioService extends ICRUD<OrdenServicio, String>{
    OrdenServicio findOneByIdOrdenServicio(String numero);
    List<OrdenServicio> findByIdOrdenServicio(String numero);

    List<OrdenServicio> findByFechaHoraRegistroBetween(LocalDateTime inicio, LocalDateTime fin);

    Page<OrdenServicioTableDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts);
}
