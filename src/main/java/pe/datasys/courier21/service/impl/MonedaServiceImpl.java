package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.Moneda;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IMonedaRepo;
import pe.datasys.courier21.service.IMonedaService;

@Service
@RequiredArgsConstructor
public class MonedaServiceImpl extends CRUDImpl<Moneda, String> implements IMonedaService {
    
    private final IMonedaRepo repo;
    
    @Override
    protected IGenericRepo<Moneda, String> getRepo() {
        return repo;
    }
}
