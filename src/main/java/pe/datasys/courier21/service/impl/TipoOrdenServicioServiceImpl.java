package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoOrdenServicio;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoOrdenServicioRepo;
import pe.datasys.courier21.service.ITipoOrdenServicioService;

@Service
@RequiredArgsConstructor
public class TipoOrdenServicioServiceImpl extends CRUDImpl<TipoOrdenServicio, Integer> implements ITipoOrdenServicioService {
    
    private final ITipoOrdenServicioRepo repo;
    
    @Override
    protected IGenericRepo<TipoOrdenServicio, Integer> getRepo() {
        return repo;
    }
}
