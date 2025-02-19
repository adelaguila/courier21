package pe.datasys.courier21.repository;

import pe.datasys.courier21.model.Agencia;

public interface IAgenciaRepo extends IGenericRepo<Agencia, Integer> {
    Agencia findOneByCodigo(String codigo);
}
