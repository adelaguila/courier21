package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.OrdenDespacho;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IOrdenDespachoRepo;
import pe.datasys.courier21.service.IOrdenDespachoService;

@Service
@RequiredArgsConstructor
public class OrdenDespachoServiceImpl extends CRUDImpl<OrdenDespacho, Long> implements IOrdenDespachoService {
    
    private final IOrdenDespachoRepo repo;
    
    @Override
    protected IGenericRepo<OrdenDespacho, Long> getRepo() {
        return repo;
    }
}
