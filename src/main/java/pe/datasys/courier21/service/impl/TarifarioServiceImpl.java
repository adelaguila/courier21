package pe.datasys.courier21.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.TarifarioDTO;
import pe.datasys.courier21.dto.tables.TarifarioTableDTO;
import pe.datasys.courier21.model.Tarifario;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITarifarioRepo;
import pe.datasys.courier21.service.ITarifarioService;
import pe.datasys.courier21.util.PaginateUtil;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarifarioServiceImpl extends CRUDImpl<Tarifario, Long> implements ITarifarioService {
    
    private final ITarifarioRepo repo;
    private final EntityManager entityManager;
    
    @Override
    protected IGenericRepo<Tarifario, Long> getRepo() {
        return repo;
    }

    @Override
    public Page<TarifarioTableDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts) {
        PaginateUtil paginateUtil = new PaginateUtil();

        List<String> columnas = Arrays.asList("idTarifa", "clienteProveedor.nombreRazonSocial", "clienteProveedorArea.area",
                "origen.distrito", "destino.destino", "tipoServicio.nombreTipoServicio", "tipoEnvio.nombreTipoEnvio", "pesoCondicional", "pesoMinimo", "tarifaMinima", "tarifaExeso", "collect");

        String sqlFrom = " FROM Tarifario a ";

        String sqlCount = "SELECT count(a) " + sqlFrom + paginateUtil.getFilters(filters, columnas).toString();

        String sqlSelect = "SELECT new pe.datasys.courier21.dto.tables.TarifarioTableDTO(a.idTarifa, a.clienteProveedor.nombreRazonSocial, a.clienteProveedorArea.area, a.origen.distrito," +
                " a.destino.destino, a.tipoServicio.nombreTipoServicio, a.tipoEnvio.nombreTipoEnvio, a.pesoCondicional, a.pesoMinimo, a.tarifaMinima, a.tarifaExeso, a.collect) " + sqlFrom + paginateUtil.getFilters(filters, columnas).toString()
                + paginateUtil.getOrder(sorts, columnas).toString();

        Query queryCount = entityManager.createQuery(sqlCount);
        Query querySelect = entityManager.createQuery(sqlSelect);

        queryCount = paginateUtil.setParams(filters, queryCount, columnas);

        querySelect = paginateUtil.setParams(filters, querySelect, columnas);

        Long total = (long) queryCount.getSingleResult();

        querySelect.setFirstResult((page) * rowPage);
        querySelect.setMaxResults(rowPage);

        @SuppressWarnings("unchecked")
        List<TarifarioTableDTO> lista = querySelect.getResultList();

        PageRequest pageable = PageRequest.of(page, rowPage);

        Page<TarifarioTableDTO> rtnPage = new PageImpl<>(lista, pageable, total);
        return rtnPage;
    }

    @Override
    public List<Tarifario> getTarifasGeneral() {
        return repo.getTarifasGenerales();
    }

    @Override
    public List<Tarifario> getTarifasCliente(Long idClienteProveedor) {
        return repo.getTarifasCliente(idClienteProveedor);
    }


}
