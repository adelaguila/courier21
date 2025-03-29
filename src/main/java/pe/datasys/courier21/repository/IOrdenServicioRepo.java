package pe.datasys.courier21.repository;

import pe.datasys.courier21.model.OrdenServicio;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrdenServicioRepo extends IGenericRepo<OrdenServicio, String> {
    OrdenServicio findOneByIdOrdenServicio(String numero);
    List<OrdenServicio> findByIdOrdenServicio(String numero);
    List<OrdenServicio> findByFechaHoraRegistroBetween(LocalDateTime inicio, LocalDateTime fin);
}
