package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.MetodoPagoEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IMetodoPagoRepo;
import pe.datasys.courier21.service.IMetodoPagoService;

@Service
@RequiredArgsConstructor
public class MetodoPagoServiceImpl extends CRUDImpl<MetodoPagoEntity, Integer> implements IMetodoPagoService {
    
    private final IMetodoPagoRepo repo;
    
    @Override
    protected IGenericRepo<MetodoPagoEntity, Integer> getRepo() {
        return repo;
    }
}
