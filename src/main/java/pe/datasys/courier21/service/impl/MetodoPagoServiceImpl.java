package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.MetodoPago;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IMetodoPagoRepo;
import pe.datasys.courier21.service.IMetodoPagoService;

@Service
@RequiredArgsConstructor
public class MetodoPagoServiceImpl extends CRUDImpl<MetodoPago, Integer> implements IMetodoPagoService {
    
    private final IMetodoPagoRepo repo;
    
    @Override
    protected IGenericRepo<MetodoPago, Integer> getRepo() {
        return repo;
    }
}
