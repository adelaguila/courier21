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
import pe.datasys.courier21.dto.AgenciaDTO;
import pe.datasys.courier21.dto.TipoAgenciaDTO;
import pe.datasys.courier21.model.Agencia;
import pe.datasys.courier21.repository.IAgenciaRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IAgenciaService;
import pe.datasys.courier21.util.PaginateUtil;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenciaServiceImpl extends CRUDImpl<Agencia, Integer> implements IAgenciaService {
    
    private final IAgenciaRepo repo;
    private final EntityManager entityManager;

    @Override
    protected IGenericRepo<Agencia, Integer> getRepo() {
        return repo;
    }

    @Override
    public Agencia findOneByCodigo(String codigo) {
        return repo.findOneByCodigo(codigo);
    }

    @Override
    public Page<AgenciaDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts) {
        PaginateUtil paginateUtil = new PaginateUtil();

        List<String> columnas = Arrays.asList("idAgencia", "codigo", "nombreAgencia", "nombreAgente", "dniAgente",
                "direccion", "telefono", "correo", "latitud", "longitud", "tipoAgencia.nombreTipoAgencia", "activo");

        String sqlFrom = " FROM Agencia a ";

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
        List<AgenciaDTO> lista = querySelect.getResultList();

        PageRequest pageable = PageRequest.of(page, rowPage);

        Page<AgenciaDTO> rtnPage = new PageImpl<>(lista, pageable, total);
        return rtnPage;
    }
}
