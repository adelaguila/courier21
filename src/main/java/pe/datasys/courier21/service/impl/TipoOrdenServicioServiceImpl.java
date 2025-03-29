package pe.datasys.courier21.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.commons.Filter;
import pe.datasys.courier21.commons.SortModel;
import pe.datasys.courier21.dto.TipoOrdenServicioDTO;
import pe.datasys.courier21.dto.TipoOrdenServicioDTO;
import pe.datasys.courier21.model.TipoOrdenServicio;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoOrdenServicioRepo;
import pe.datasys.courier21.service.ITipoOrdenServicioService;
import pe.datasys.courier21.util.PaginateUtil;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoOrdenServicioServiceImpl extends CRUDImpl<TipoOrdenServicio, Integer> implements ITipoOrdenServicioService {
    
    private final ITipoOrdenServicioRepo repo;
    private final EntityManager entityManager;
    
    @Override
    protected IGenericRepo<TipoOrdenServicio, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<TipoOrdenServicioDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts) {
        PaginateUtil paginateUtil = new PaginateUtil();

        List<String> columnas = Arrays.asList("idTipoOrdenServicio", "nombreTipoOrdenServicio");

        String sqlFrom = " FROM TipoOrdenServicio a ";

        String sqlCount = "SELECT count(a) " + sqlFrom + paginateUtil.getFilters(filters, columnas).toString();

        String sqlSelect = "SELECT a " + sqlFrom + paginateUtil.getFilters(filters, columnas).toString()
                + paginateUtil.getOrder(sorts, columnas).toString();

        Query queryCount = entityManager.createQuery(sqlCount);
        Query querySelect = entityManager.createQuery(sqlSelect);

        queryCount = paginateUtil.setParams(filters, queryCount, columnas);

        querySelect = paginateUtil.setParams(filters, querySelect, columnas);

        Long total = (long) queryCount.getSingleResult();

        querySelect.setFirstResult((page) * rowPage);
        querySelect.setMaxResults(rowPage);

        @SuppressWarnings("unchecked")
        List<TipoOrdenServicioDTO> lista = querySelect.getResultList();

        PageRequest pageable = PageRequest.of(page, rowPage);

        Page<TipoOrdenServicioDTO> rtnPage = new PageImpl<>(lista, pageable, total);
        return rtnPage;
    }
}
