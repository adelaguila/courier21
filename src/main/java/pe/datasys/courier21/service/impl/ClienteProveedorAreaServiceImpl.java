package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ClienteProveedorArea;
import pe.datasys.courier21.repository.IClienteProveedorAreaRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IClienteProveedorAreaService;

@Service
@RequiredArgsConstructor
public class ClienteProveedorAreaServiceImpl extends CRUDImpl<ClienteProveedorArea, Long> implements IClienteProveedorAreaService {
    
    private final IClienteProveedorAreaRepo repo;
    
    @Override
    protected IGenericRepo<ClienteProveedorArea, Long> getRepo() {
        return repo;
    }
}
