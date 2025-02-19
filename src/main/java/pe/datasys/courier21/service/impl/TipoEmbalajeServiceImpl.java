package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoEmbalaje;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoEmbalajeRepo;
import pe.datasys.courier21.service.ITipoEmbalajeService;

@Service
@RequiredArgsConstructor
public class TipoEmbalajeServiceImpl extends CRUDImpl<TipoEmbalaje, Integer> implements ITipoEmbalajeService {
    
    private final ITipoEmbalajeRepo repo;
    
    @Override
    protected IGenericRepo<TipoEmbalaje, Integer> getRepo() {
        return repo;
    }
}
