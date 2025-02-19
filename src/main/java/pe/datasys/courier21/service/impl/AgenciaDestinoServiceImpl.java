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
import pe.datasys.courier21.dto.AgenciaDestinoDTO;
import pe.datasys.courier21.dto.PaginateDTO;
import pe.datasys.courier21.dto.tables.AgenciaDestinoTableDTO;
import pe.datasys.courier21.model.AgenciaDestino;
import pe.datasys.courier21.repository.IAgenciaDestinoRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IAgenciaDestinoService;
import pe.datasys.courier21.util.PaginateUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenciaDestinoServiceImpl extends CRUDImpl<AgenciaDestino, Integer> implements IAgenciaDestinoService {

    private final IAgenciaDestinoRepo repo;
    private final EntityManager entityManager;

    @Override
    protected IGenericRepo<AgenciaDestino, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<AgenciaDestino> findByAgenciaIdAgencia(Integer idAgencia) {
        return repo.findByAgenciaIdAgencia(idAgencia);
    }

    @Override
    public Page<AgenciaDestinoTableDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts) {
        PaginateUtil paginateUtil = new PaginateUtil();

        List<String> columnas = Arrays.asList("idAgenciaDestino", "agencia.nombreAgencia", "destino", "adicionalEntrega", "adicionalRecojo", "aceptaCollec");

        String sqlFrom = " FROM AgenciaDestino a ";

        String sqlCount = "SELECT count(a) " + sqlFrom + paginateUtil.getFilters(filters, columnas).toString();

        String sqlSelect = "SELECT new pe.datasys.courier21.dto.tables.AgenciaDestinoTableDTO(a.idAgenciaDestino, a.agencia.nombreAgencia, a.destino, a.adicionalEntrega, a.adicionalRecojo, a.aceptaCollec) " + sqlFrom + paginateUtil.getFilters(filters, columnas).toString()
                + paginateUtil.getOrder(sorts, columnas).toString();

        Query queryCount = entityManager.createQuery(sqlCount);
        Query querySelect = entityManager.createQuery(sqlSelect);

        queryCount = paginateUtil.setParams(filters, queryCount, columnas);

        querySelect = paginateUtil.setParams(filters, querySelect, columnas);

        Long total = (long) queryCount.getSingleResult();

        querySelect.setFirstResult((page) * rowPage);
        querySelect.setMaxResults(rowPage);

        @SuppressWarnings("unchecked")
        List<AgenciaDestinoTableDTO> lista = querySelect.getResultList();

        PageRequest pageable = PageRequest.of(page, rowPage);

        Page<AgenciaDestinoTableDTO> rtnPage = new PageImpl<>(lista, pageable, total);
        return rtnPage;
    }
}
