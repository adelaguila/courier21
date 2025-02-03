package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoServicioEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoServicioRepo;
import pe.datasys.courier21.service.ITipoServicioService;

@Service
@RequiredArgsConstructor
public class TipoServicioServiceImpl extends CRUDImpl<TipoServicioEntity, Integer> implements ITipoServicioService {
    
    private final ITipoServicioRepo repo;
    
    @Override
    protected IGenericRepo<TipoServicioEntity, Integer> getRepo() {
        return repo;
    }
}
