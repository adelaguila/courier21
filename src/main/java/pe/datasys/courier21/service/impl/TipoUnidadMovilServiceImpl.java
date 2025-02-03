package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoUnidadMovilEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoUnidadMovilRepo;
import pe.datasys.courier21.service.ITipoUnidadMovilService;

@Service
@RequiredArgsConstructor
public class TipoUnidadMovilServiceImpl extends CRUDImpl<TipoUnidadMovilEntity, Integer> implements ITipoUnidadMovilService {
    
    private final ITipoUnidadMovilRepo repo;
    
    @Override
    protected IGenericRepo<TipoUnidadMovilEntity, Integer> getRepo() {
        return repo;
    }
}
