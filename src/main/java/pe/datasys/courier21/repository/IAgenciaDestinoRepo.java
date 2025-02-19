package pe.datasys.courier21.repository;

import pe.datasys.courier21.model.AgenciaDestino;

import java.util.List;

public interface IAgenciaDestinoRepo extends IGenericRepo<AgenciaDestino, Integer> {
    List<AgenciaDestino> findByAgenciaIdAgencia(Integer idAgencia);
}
