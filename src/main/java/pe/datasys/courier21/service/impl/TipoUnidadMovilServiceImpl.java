package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoUnidadMovil;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoUnidadMovilRepo;
import pe.datasys.courier21.service.ITipoUnidadMovilService;

@Service
@RequiredArgsConstructor
public class TipoUnidadMovilServiceImpl extends CRUDImpl<TipoUnidadMovil, Integer> implements ITipoUnidadMovilService {
    
    private final ITipoUnidadMovilRepo repo;
    
    @Override
    protected IGenericRepo<TipoUnidadMovil, Integer> getRepo() {
        return repo;
    }
}
