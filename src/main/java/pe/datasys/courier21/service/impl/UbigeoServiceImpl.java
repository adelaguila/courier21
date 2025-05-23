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
import pe.datasys.courier21.dto.UbigeoDTO;
import pe.datasys.courier21.model.Ubigeo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IUbigeoRepo;
import pe.datasys.courier21.service.IUbigeoService;
import pe.datasys.courier21.util.PaginateUtil;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UbigeoServiceImpl extends CRUDImpl<Ubigeo, Integer> implements IUbigeoService {
    
    private final IUbigeoRepo repo;
    private final EntityManager entityManager;

    @Override
    protected IGenericRepo<Ubigeo, Integer> getRepo() {
        return repo;
    }

    @Override
    public Ubigeo findOneByCodigo(String codigo) {
        return repo.findOneByCodigo(codigo);
    }

    @Override
    public List<Ubigeo> findByDistritoContains(String distrito) {
        return repo.findByDistritoContains(distrito);
    }

    @Override
    public List<Ubigeo> getAutocomplete(String term) {
        return repo.getAutocomplete("%" + term + "%");
    }

    @Override
    public Page<UbigeoDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts) {
        PaginateUtil paginateUtil = new PaginateUtil();

        List<String> columnas = Arrays.asList("idUbigeo", "codigo", "departamento", "provincia", "distrito", "agencia.nombreAgencia");

        String sqlFrom = " FROM Ubigeo a ";

        String sqlCount = "SELECT count(a) " + sqlFrom + paginateUtil.getFilters(filters, columnas).toString();

//        String sqlSelect = "SELECT a " + sqlFrom + paginateUtil.getFilters(filters, columnas).toString()
//                + paginateUtil.getOrder(sorts, columnas).toString();

        String sqlSelect = "SELECT new pe.datasys.courier21.dto.tables.UbigeoTableDTO(a.idUbigeo, a.codigo, a.departamento, a.provincia, a.distrito, a.nombreAgencia, a.adicionalEntrega, a.adicionalRecojo, a.aceptaCollec) " + sqlFrom + paginateUtil.getFilters(filters, columnas).toString()
                + paginateUtil.getOrder(sorts, columnas).toString();

        Query queryCount = entityManager.createQuery(sqlCount);
        Query querySelect = entityManager.createQuery(sqlSelect);

        queryCount = paginateUtil.setParams(filters, queryCount, columnas);

        querySelect = paginateUtil.setParams(filters, querySelect, columnas);

        Long total = (long) queryCount.getSingleResult();

        querySelect.setFirstResult((page) * rowPage);
        querySelect.setMaxResults(rowPage);

        @SuppressWarnings("unchecked")
        List<UbigeoDTO> lista = querySelect.getResultList();

        PageRequest pageable = PageRequest.of(page, rowPage);

        Page<UbigeoDTO> rtnPage = new PageImpl<>(lista, pageable, total);
        return rtnPage;
    }
}
