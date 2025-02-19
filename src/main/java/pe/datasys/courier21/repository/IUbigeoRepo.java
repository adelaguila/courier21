package pe.datasys.courier21.repository;

import org.springframework.data.jpa.repository.Query;
import pe.datasys.courier21.model.Ubigeo;

import java.util.List;

public interface IUbigeoRepo extends IGenericRepo<Ubigeo, Integer> {
    Ubigeo findOneByCodigo(String codigo);

    List<Ubigeo> findByDistritoContains(String distrito);

    @Query("FROM Ubigeo u WHERE u.distrito LIKE :term ORDER BY u.departamento, u.provincia, u.distrito")
    List<Ubigeo> getAutocomplete(String term);

}
