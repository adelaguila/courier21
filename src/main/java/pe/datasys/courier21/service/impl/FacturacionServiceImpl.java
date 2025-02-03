package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.FacturacionEntity;
import pe.datasys.courier21.repository.IFacturacionRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IFacturacionService;

@Service
@RequiredArgsConstructor
public class FacturacionServiceImpl extends CRUDImpl<FacturacionEntity, Long> implements IFacturacionService {
    
    private final IFacturacionRepo repo;
    
    @Override
    protected IGenericRepo<FacturacionEntity, Long> getRepo() {
        return repo;
    }
}
