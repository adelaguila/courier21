package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.FacturacionPago;
import pe.datasys.courier21.repository.IFacturacionPagoRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IFacturacionPagoService;

@Service
@RequiredArgsConstructor
public class FacturacionPagoImpl extends CRUDImpl<FacturacionPago, Long> implements IFacturacionPagoService {
    
    private final IFacturacionPagoRepo repo;
    
    @Override
    protected IGenericRepo<FacturacionPago, Long> getRepo() {
        return repo;
    }
}
