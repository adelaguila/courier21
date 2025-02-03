package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoAgenciaEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoAgenciaRepo;
import pe.datasys.courier21.service.ITipoAgenciaService;

@Service
@RequiredArgsConstructor
public class TipoAgenciaServiceImpl extends CRUDImpl<TipoAgenciaEntity, Integer> implements ITipoAgenciaService {
    
    private final ITipoAgenciaRepo repo;
    
    @Override
    protected IGenericRepo<TipoAgenciaEntity, Integer> getRepo() {
        return repo;
    }
}
