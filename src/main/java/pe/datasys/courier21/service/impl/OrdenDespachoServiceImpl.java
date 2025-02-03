package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.OrdenDespachoEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IOrdenDespachoRepo;
import pe.datasys.courier21.service.IOrdenDespachoService;

@Service
@RequiredArgsConstructor
public class OrdenDespachoServiceImpl extends CRUDImpl<OrdenDespachoEntity, Long> implements IOrdenDespachoService {
    
    private final IOrdenDespachoRepo repo;
    
    @Override
    protected IGenericRepo<OrdenDespachoEntity, Long> getRepo() {
        return repo;
    }
}
