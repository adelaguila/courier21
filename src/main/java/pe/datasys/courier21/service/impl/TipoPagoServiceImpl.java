package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoPago;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoPagoRepo;
import pe.datasys.courier21.service.ITipoPagoService;

@Service
@RequiredArgsConstructor
public class TipoPagoServiceImpl extends CRUDImpl<TipoPago, Integer> implements ITipoPagoService {
    
    private final ITipoPagoRepo repo;
    
    @Override
    protected IGenericRepo<TipoPago, Integer> getRepo() {
        return repo;
    }
}
