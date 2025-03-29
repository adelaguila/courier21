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
import pe.datasys.courier21.dto.OrdenServicioDTO;
import pe.datasys.courier21.dto.TipoPagoDTO;
import pe.datasys.courier21.dto.tables.OrdenServicioTableDTO;
import pe.datasys.courier21.model.OrdenServicio;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IOrdenServicioRepo;
import pe.datasys.courier21.service.IOrdenServicioService;
import pe.datasys.courier21.util.PaginateUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdenServicioServiceImpl extends CRUDImpl<OrdenServicio, String> implements IOrdenServicioService {
    
    private final IOrdenServicioRepo repo;
    private final EntityManager entityManager;

    @Override
    protected IGenericRepo<OrdenServicio, String> getRepo() {
        return repo;
    }

    @Override
    public OrdenServicio findOneByIdOrdenServicio(String numero) {
        return repo.findOneByIdOrdenServicio(numero);
    }

    @Override
    public List<OrdenServicio> findByIdOrdenServicio(String numero) {
        return repo.findByIdOrdenServicio(numero);
    }

    @Override
    public List<OrdenServicio> findByFechaHoraRegistroBetween(LocalDateTime inicio, LocalDateTime fin) {
        return repo.findByFechaHoraRegistroBetween(inicio, fin);
    }

    @Override
    public Page<OrdenServicioTableDTO> paginate(Integer page, Integer rowPage, List<Filter> filters, List<SortModel> sorts) {
        String sqlCount = "SELECT count(a) " + getFrom().toString() + getFilters(filters).toString();

        String sqlSelect = getSelect().toString() + getFrom().toString() + getFilters(filters).toString()
                + getOrder(sorts).toString();

        Query queryCount = entityManager.createQuery(sqlCount);
        Query querySelect = entityManager.createQuery(sqlSelect);

        queryCount = this.setParams(filters, queryCount);

        querySelect = this.setParams(filters, querySelect);

        Long total = (long) queryCount.getSingleResult();

        querySelect.setFirstResult((page) * rowPage);
        querySelect.setMaxResults(rowPage);

        @SuppressWarnings("unchecked")
        List<OrdenServicioTableDTO> lista = querySelect.getResultList();

        PageRequest pageable = PageRequest.of(page, rowPage);

        Page<OrdenServicioTableDTO> rtnPage = new PageImpl<>(lista, pageable, total);
        return rtnPage;
    }

    public StringBuilder getSelect() {
//        StringBuilder sql = new StringBuilder("SELECT new pe.datasys.courier21.dto.tables.OrdenServicioTableDTO(a.idOrdenServicio, a.agenciaOrigen.nombreAgencia, a.origen.distrito, a.destino.distrito, " +
//                "a.cliente.nombreRazonSocial, a.area,  a.remitente, a.consignatario, a.idConsignatario, a.direccion, a.telefono, a.guia, a.referencia1, " +
//                "a.referencia2, a.referencia3, a.piezas, a.peso, a.adicionalTransferencia, a.total, a.tipoOrdenServicio, " +
//                "a.tipoPago, a.tipoEnvio, a.tipoServicio, a.idManifiestoSalida, a.idManifiestoReparto, " +
//                "a.idFacturacion, a.idLiquidacionCliente, a.idLiquidacionAgencia, a.fechaHoraRegistro, a.fechaHoraManifiestoSalida, a.fechaHoraDespacho, " +
//                "a.fechaHoraLlegada, a.fechaHoraReparto, a.fechaHoraEntrega, a.recepcionista, a.dniRecepcionista, a.podVirtual, a.estadoOperacion, a.estadoFacturacion) ");
        StringBuilder sql = new StringBuilder("SELECT new pe.datasys.courier21.dto.tables.OrdenServicioTableDTO(a.idOrdenServicio, a.origen.distrito, a.destino.distrito, " +
                "a.cliente.nombreRazonSocial, a.area, a.consignatario, a.guia, a.referencia1, " +
                "a.referencia2, a.referencia3, a.piezas, a.peso, a.total, a.idManifiestoSalida, a.idManifiestoReparto, " +
                "a.idFacturacion, a.idLiquidacionCliente, a.fechaHoraRegistro, a.estadoOperacion, a.estadoFacturacion) ");
        return sql;
    }

    public StringBuilder getFrom() {
        StringBuilder sql = new StringBuilder(" FROM OrdenServicio a ");
        return sql;
    }

    public StringBuilder getFilters(List<Filter> filters) {

        StringBuilder sql = new StringBuilder("where 1=1 ");

        for (Filter filtro : filters) {
            if (filtro.getField().equals("idOrdenServicio")) { sql.append(getFiltersColumns("a.idOrdenServicio", filtro.getMatchMode(), ":idOrdenServicio"));}
            if (filtro.getField().equals("nombreAgenciaOrigen")) { sql.append(getFiltersColumns("a.agenciaOrigen.nombreAgencia", filtro.getMatchMode(), ":nombreAgencia"));}
            if (filtro.getField().equals("origen")) { sql.append(getFiltersColumns("a.origen.distrito", filtro.getMatchMode(), ":origen"));}
            if (filtro.getField().equals("destino")) { sql.append(getFiltersColumns("a.destino.distrito", filtro.getMatchMode(), ":destino"));}
            if (filtro.getField().equals("nombreRazonSocial")) { sql.append(getFiltersColumns("a.cliente.nombreRazonSocial", filtro.getMatchMode(), ":nombreRazonSocial"));}
            if (filtro.getField().equals("area")) { sql.append(getFiltersColumns("a.area", filtro.getMatchMode(), ":area"));}
            if (filtro.getField().equals("remitente")) { sql.append(getFiltersColumns("a.remitente", filtro.getMatchMode(), ":remitente"));}
            if (filtro.getField().equals("consignatario")) { sql.append(getFiltersColumns("a.consignatario", filtro.getMatchMode(), ":consignatario"));}
            if (filtro.getField().equals("idConsignatario")) { sql.append(getFiltersColumns("a.idConsignatario", filtro.getMatchMode(), ":idConsignatario"));}
            if (filtro.getField().equals("guia")) { sql.append(getFiltersColumns("a.guia", filtro.getMatchMode(), ":guia"));}
            if (filtro.getField().equals("referencia1")) { sql.append(getFiltersColumns("a.referencia1", filtro.getMatchMode(), ":referencia1"));}
            if (filtro.getField().equals("referencia2")) { sql.append(getFiltersColumns("a.referencia2", filtro.getMatchMode(), ":referencia2"));}
            if (filtro.getField().equals("referencia3")) { sql.append(getFiltersColumns("a.referencia3", filtro.getMatchMode(), ":referencia3"));}
            if (filtro.getField().equals("idManifiestoSalida")) { sql.append(getFiltersColumns("a.idManifiestoSalida", filtro.getMatchMode(), ":idManifiestoSalida"));}
            if (filtro.getField().equals("idManifiestoReparto")) { sql.append(getFiltersColumns("a.idManifiestoReparto", filtro.getMatchMode(), ":idManifiestoReparto"));}
            if (filtro.getField().equals("idFacturacion")) { sql.append(getFiltersColumns("a.idFacturacion", filtro.getMatchMode(), ":idFacturacion"));}
            if (filtro.getField().equals("idLiquidacionCliente")) { sql.append(getFiltersColumns("a.idLiquidacionCliente", filtro.getMatchMode(), ":idLiquidacionCliente"));}
            if (filtro.getField().equals("fechaHoraRegistro")) { sql.append(getFiltersColumns("a.fechaHoraRegistro", filtro.getMatchMode(), ":fechaHoraRegistro"));}
            if (filtro.getField().equals("estadoOperacion")) {sql.append(getFiltersColumns("a.estadoOperacion", filtro.getMatchMode(), ":estadoOperacion"));}
            if (filtro.getField().equals("estadoFacturacion")) {sql.append(getFiltersColumns("a.estadoFacturacion", filtro.getMatchMode(), ":estadoFacturacion"));}
        }

        return sql;
    }

    public StringBuilder getOrder(List<SortModel> sorts) {

        String preSql = "";

        for (SortModel sort : sorts) {
            if (sort.getField().equals("idOrdenServicio")) { preSql = " ORDER BY a.idOrdenServicio " + sort.getSort();}
            if (sort.getField().equals("nombreAgenciaOrigen")) { preSql = " ORDER BY a.agenciaOrigen.nombreAgencia " + sort.getSort();}
            if (sort.getField().equals("origen")) { preSql = " ORDER BY a.origen.distrito " + sort.getSort();}
            if (sort.getField().equals("destino")) { preSql = " ORDER BY a.destino.distrito " + sort.getSort();}
            if (sort.getField().equals("nombreRazonSocial")) { preSql = " ORDER BY a.cliente.nombreRazonSocial " + sort.getSort();}
            if (sort.getField().equals("area")) { preSql = " ORDER BY a.area " + sort.getSort();}
            if (sort.getField().equals("remitente")) { preSql = " ORDER BY a.remitente " + sort.getSort();}
            if (sort.getField().equals("consignatario")) { preSql = " ORDER BY a.consignatario " + sort.getSort();}
            if (sort.getField().equals("idConsignatario")) { preSql = " ORDER BY a.idConsignatario " + sort.getSort();}
            if (sort.getField().equals("guia")) { preSql = " ORDER BY a.guia " + sort.getSort();}
            if (sort.getField().equals("referencia1")) { preSql = " ORDER BY a.referencia1 " + sort.getSort();}
            if (sort.getField().equals("referencia2")) { preSql = " ORDER BY a.referencia2 " + sort.getSort();}
            if (sort.getField().equals("referencia3")) { preSql = " ORDER BY a.referencia3 " + sort.getSort();}
            if (sort.getField().equals("idManifiestoSalida")) { preSql = " ORDER BY a.idManifiestoSalida " + sort.getSort();}
            if (sort.getField().equals("idManifiestoReparto")) { preSql = " ORDER BY a.idManifiestoReparto " + sort.getSort();}
            if (sort.getField().equals("idFacturacion")) { preSql = " ORDER BY a.idFacturacion " + sort.getSort();}
            if (sort.getField().equals("idLiquidacionCliente")) { preSql = " ORDER BY a.idLiquidacionCliente " + sort.getSort();}
            if (sort.getField().equals("fechaHoraRegistro")) { preSql = " ORDER BY a.fechaHoraRegistro " + sort.getSort();}
            if (sort.getField().equals("estadoOperacion")) { preSql = " ORDER BY a.estadoOperacion " + sort.getSort();}
            if (sort.getField().equals("estadoFacturacion")) { preSql = " ORDER BY a.estadoFacturacion " + sort.getSort();}
        }

        StringBuilder sql = new StringBuilder(preSql);

        return sql;
    }

    public Query setParams(List<Filter> filters, Query query) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (Filter filtro : filters) {
            if (filtro.getField().equals("idOrdenServicio")) { query.setParameter("idOrdenServicio", filtro.getValue());}
            if (filtro.getField().equals("nombreAgenciaOrigen")) { query.setParameter("nombreAgenciaOrigen", filtro.getValue());}
            if (filtro.getField().equals("origen")) { query.setParameter("origen", filtro.getValue());}
            if (filtro.getField().equals("destino")) { query.setParameter("destino", filtro.getValue());}
            if (filtro.getField().equals("nombreRazonSocial")) { query.setParameter("nombreRazonSocial", filtro.getValue());}
            if (filtro.getField().equals("area")) { query.setParameter("area", filtro.getValue());}
            if (filtro.getField().equals("remitente")) { query.setParameter("remitente", filtro.getValue());}
            if (filtro.getField().equals("consignatario")) { query.setParameter("consignatario", filtro.getValue());}
            if (filtro.getField().equals("idConsignatario")) { query.setParameter("idConsignatario", filtro.getValue());}
            if (filtro.getField().equals("guia")) { query.setParameter("guia", filtro.getValue());}
            if (filtro.getField().equals("referencia1")) { query.setParameter("referencia1", filtro.getValue());}
            if (filtro.getField().equals("referencia2")) { query.setParameter("referencia2", filtro.getValue());}
            if (filtro.getField().equals("referencia3")) { query.setParameter("referencia3", filtro.getValue());}
            if (filtro.getField().equals("idManifiestoSalida")) { query.setParameter("idManifiestoSalida", filtro.getValue());}
            if (filtro.getField().equals("idManifiestoReparto")) { query.setParameter("idManifiestoReparto", filtro.getValue());}
            if (filtro.getField().equals("idFacturacion")) { query.setParameter("idFacturacion", filtro.getValue());}
            if (filtro.getField().equals("idLiquidacionCliente")) { query.setParameter("idLiquidacionCliente", filtro.getValue());}
            if (filtro.getField().equals("fechaHoraRegistro")) { query.setParameter("fechaHoraRegistro", LocalDateTime.parse(filtro.getValue(), formatter));}
            if (filtro.getField().equals("estadoOperacion")) { query.setParameter("estadoOperacion", filtro.getValue());}
            if (filtro.getField().equals("estadoFacturacion")) { query.setParameter("estadoFacturacion", filtro.getValue());}
        }

        return query;
    }


}
