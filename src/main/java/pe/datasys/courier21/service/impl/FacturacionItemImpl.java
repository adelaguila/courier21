package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.FacturacionItemEntity;
import pe.datasys.courier21.repository.IFacturacionItemRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IFacturacionItemService;

@Service
@RequiredArgsConstructor
public class FacturacionItemImpl extends CRUDImpl<FacturacionItemEntity, Long> implements IFacturacionItemService {
    
    private final IFacturacionItemRepo repo;
    
    @Override
    protected IGenericRepo<FacturacionItemEntity, Long> getRepo() {
        return repo;
    }
}
