package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.CuentaBancariaEntity;
import pe.datasys.courier21.repository.ICuentaBancariaRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.ICuentaBancariaService;

@Service
@RequiredArgsConstructor
public class CuentaBancariaServiceImpl extends CRUDImpl<CuentaBancariaEntity, String> implements ICuentaBancariaService {
    
    private final ICuentaBancariaRepo repo;
    
    @Override
    protected IGenericRepo<CuentaBancariaEntity, String> getRepo() {
        return repo;
    }
}
