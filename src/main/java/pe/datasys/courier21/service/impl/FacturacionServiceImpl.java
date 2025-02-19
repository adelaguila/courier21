package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.Facturacion;
import pe.datasys.courier21.repository.IFacturacionRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IFacturacionService;

@Service
@RequiredArgsConstructor
public class FacturacionServiceImpl extends CRUDImpl<Facturacion, Long> implements IFacturacionService {
    
    private final IFacturacionRepo repo;
    
    @Override
    protected IGenericRepo<Facturacion, Long> getRepo() {
        return repo;
    }
}
