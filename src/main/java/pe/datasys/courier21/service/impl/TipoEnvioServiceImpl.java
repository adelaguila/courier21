package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoEnvio;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoEnvioRepo;
import pe.datasys.courier21.service.ITipoEnvioService;

@Service
@RequiredArgsConstructor
public class TipoEnvioServiceImpl extends CRUDImpl<TipoEnvio, Integer> implements ITipoEnvioService {
    
    private final ITipoEnvioRepo repo;
    
    @Override
    protected IGenericRepo<TipoEnvio, Integer> getRepo() {
        return repo;
    }
}
