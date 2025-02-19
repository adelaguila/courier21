package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ClienteProveedorDireccion;
import pe.datasys.courier21.repository.IClienteProveedorDireccionRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IClienteProveedorDireccionService;

@Service
@RequiredArgsConstructor
public class ClienteProveedorDireccionServiceImpl extends CRUDImpl<ClienteProveedorDireccion, Long> implements IClienteProveedorDireccionService {
    
    private final IClienteProveedorDireccionRepo repo;
    
    @Override
    protected IGenericRepo<ClienteProveedorDireccion, Long> getRepo() {
        return repo;
    }
}
