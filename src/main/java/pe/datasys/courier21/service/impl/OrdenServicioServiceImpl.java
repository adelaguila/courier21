package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.OrdenServicioEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IOrdenServicioRepo;
import pe.datasys.courier21.service.IOrdenServicioService;

@Service
@RequiredArgsConstructor
public class OrdenServicioServiceImpl extends CRUDImpl<OrdenServicioEntity, Long> implements IOrdenServicioService {
    
    private final IOrdenServicioRepo repo;
    
    @Override
    protected IGenericRepo<OrdenServicioEntity, Long> getRepo() {
        return repo;
    }
}
