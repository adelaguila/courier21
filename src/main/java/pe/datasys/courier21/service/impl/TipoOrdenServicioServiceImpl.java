package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoOrdenServicioEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoOrdenServicioRepo;
import pe.datasys.courier21.service.ITipoOrdenServicioService;

@Service
@RequiredArgsConstructor
public class TipoOrdenServicioServiceImpl extends CRUDImpl<TipoOrdenServicioEntity, Integer> implements ITipoOrdenServicioService {
    
    private final ITipoOrdenServicioRepo repo;
    
    @Override
    protected IGenericRepo<TipoOrdenServicioEntity, Integer> getRepo() {
        return repo;
    }
}
