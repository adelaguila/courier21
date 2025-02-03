package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ClienteProveedorEntity;
import pe.datasys.courier21.repository.IClienteProveedorRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IClienteProveedorService;

@Service
@RequiredArgsConstructor
public class ClienteProveedorServiceImpl extends CRUDImpl<ClienteProveedorEntity, Long> implements IClienteProveedorService {
    
    private final IClienteProveedorRepo repo;
    
    @Override
    protected IGenericRepo<ClienteProveedorEntity, Long> getRepo() {
        return repo;
    }
}
