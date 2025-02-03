package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ClienteProveedorDireccionEntity;
import pe.datasys.courier21.repository.IClienteProveedorDireccionRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IClienteProveedorDireccionService;

@Service
@RequiredArgsConstructor
public class ClienteProveedorDireccionServiceImpl extends CRUDImpl<ClienteProveedorDireccionEntity, Long> implements IClienteProveedorDireccionService {
    
    private final IClienteProveedorDireccionRepo repo;
    
    @Override
    protected IGenericRepo<ClienteProveedorDireccionEntity, Long> getRepo() {
        return repo;
    }
}
