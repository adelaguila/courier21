package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoEnvioEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoEnvioRepo;
import pe.datasys.courier21.service.ITipoEnvioService;

@Service
@RequiredArgsConstructor
public class TipoEnvioServiceImpl extends CRUDImpl<TipoEnvioEntity, Integer> implements ITipoEnvioService {
    
    private final ITipoEnvioRepo repo;
    
    @Override
    protected IGenericRepo<TipoEnvioEntity, Integer> getRepo() {
        return repo;
    }
}
