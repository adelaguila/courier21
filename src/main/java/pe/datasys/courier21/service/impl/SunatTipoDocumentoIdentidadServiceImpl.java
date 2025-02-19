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
import pe.datasys.courier21.dto.SunatTipoDocumentoIdentidadDTO;
import pe.datasys.courier21.dto.TipoClienteProveedorDTO;
import pe.datasys.courier21.model.SunatTipoDocumentoIdentidad;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ISunatTipoDocumentoIdentidadRepo;
import pe.datasys.courier21.service.ISunatTipoDocumentoIdentidadService;
import pe.datasys.courier21.util.PaginateUtil;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SunatTipoDocumentoIdentidadServiceImpl extends CRUDImpl<SunatTipoDocumentoIdentidad, String> implements ISunatTipoDocumentoIdentidadService {
    
    private final ISunatTipoDocumentoIdentidadRepo repo;
    private final EntityManager entityManager;

    @Override
    protected IGenericRepo<SunatTipoDocumentoIdentidad, String> getRepo() {
        return repo;
    }

    @Override
    public Page<SunatTipoDocumentoIdentidadDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts) {
        PaginateUtil paginateUtil = new PaginateUtil();

        List<String> columnas = Arrays.asList("idSunatTipoDocumentoIdentidad", "nombreSunatTipoDocumentoIdentidad", "digitos");

        String sqlFrom = " FROM SunatTipoDocumentoIdentidad a ";

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
        List<SunatTipoDocumentoIdentidadDTO> lista = querySelect.getResultList();

        PageRequest pageable = PageRequest.of(page, rowPage);

        Page<SunatTipoDocumentoIdentidadDTO> rtnPage = new PageImpl<>(lista, pageable, total);
        return rtnPage;
    }
}
