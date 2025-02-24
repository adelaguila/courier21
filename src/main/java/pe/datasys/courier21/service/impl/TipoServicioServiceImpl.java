package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoServicio;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoServicioRepo;
import pe.datasys.courier21.service.ITipoServicioService;

@Service
@RequiredArgsConstructor
public class TipoServicioServiceImpl extends CRUDImpl<TipoServicio, Integer> implements ITipoServicioService {
    
    private final ITipoServicioRepo repo;
    
    @Override
    protected IGenericRepo<TipoServicio, Integer> getRepo() {
        return repo;
    }
}
