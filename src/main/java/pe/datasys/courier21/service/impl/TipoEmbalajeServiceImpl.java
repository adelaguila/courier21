package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoEmbalajeEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoEmbalajeRepo;
import pe.datasys.courier21.service.ITipoEmbalajeService;

@Service
@RequiredArgsConstructor
public class TipoEmbalajeServiceImpl extends CRUDImpl<TipoEmbalajeEntity, Integer> implements ITipoEmbalajeService {
    
    private final ITipoEmbalajeRepo repo;
    
    @Override
    protected IGenericRepo<TipoEmbalajeEntity, Integer> getRepo() {
        return repo;
    }
}
