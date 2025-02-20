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
import pe.datasys.courier21.dto.ClienteProveedorDTO;
import pe.datasys.courier21.dto.UbigeoDTO;
import pe.datasys.courier21.dto.tables.ClienteProveedorTableDTO;
import pe.datasys.courier21.model.ClienteProveedor;
import pe.datasys.courier21.repository.IClienteProveedorRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IClienteProveedorService;
import pe.datasys.courier21.util.PaginateUtil;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteProveedorServiceImpl extends CRUDImpl<ClienteProveedor, Long> implements IClienteProveedorService {
    
    private final IClienteProveedorRepo repo;
    private final EntityManager entityManager;
    @Override
    protected IGenericRepo<ClienteProveedor, Long> getRepo() {
        return repo;
    }

    @Override
    public Page<ClienteProveedorTableDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts) {
        PaginateUtil paginateUtil = new PaginateUtil();

        List<String> columnas = Arrays.asList("idClienteProveedor", "tipoDocumentoIdentidad.idSunatTipoDocumentoIdentidad", "numeroDocumentoIdentidad", "nombreRazonSocial", "tipoClienteProveedor.nombreTipoClienteProveedor", "telefono", "correo", "activo");

        String sqlFrom = " FROM ClienteProveedor a ";

        String sqlCount = "SELECT count(a) " + sqlFrom + paginateUtil.getFilters(filters, columnas).toString();

        String sqlSelect = "SELECT new pe.datasys.courier21.dto.tables.ClienteProveedorTableDTO(a.idClienteProveedor, a.tipoDocumentoIdentidad.idSunatTipoDocumentoIdentidad, a.numeroDocumentoIdentidad, a.nombreRazonSocial, a.tipoClienteProveedor.nombreTipoClienteProveedor, a.telefono, a.correo, a.activo) " + sqlFrom + paginateUtil.getFilters(filters, columnas).toString()
                + paginateUtil.getOrder(sorts, columnas).toString();

        Query queryCount = entityManager.createQuery(sqlCount);
        Query querySelect = entityManager.createQuery(sqlSelect);

        queryCount = paginateUtil.setParams(filters, queryCount, columnas);

        querySelect = paginateUtil.setParams(filters, querySelect, columnas);

        Long total = (long) queryCount.getSingleResult();

        querySelect.setFirstResult((page) * rowPage);
        querySelect.setMaxResults(rowPage);

        @SuppressWarnings("unchecked")
        List<ClienteProveedorTableDTO> lista = querySelect.getResultList();

        PageRequest pageable = PageRequest.of(page, rowPage);

        Page<ClienteProveedorTableDTO> rtnPage = new PageImpl<>(lista, pageable, total);
        return rtnPage;
    }

    @Override
    public ClienteProveedor findOneByNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
        return repo.findOneByNumeroDocumentoIdentidad(numeroDocumentoIdentidad);
    }

    @Override
    public List<ClienteProveedor> getAutocomplete(String term) {
        return repo.getAutocomplete("%" + term + "%");
    }
}
