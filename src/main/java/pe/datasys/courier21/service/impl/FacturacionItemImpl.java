package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.FacturacionItem;
import pe.datasys.courier21.repository.IFacturacionItemRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IFacturacionItemService;

@Service
@RequiredArgsConstructor
public class FacturacionItemImpl extends CRUDImpl<FacturacionItem, Long> implements IFacturacionItemService {
    
    private final IFacturacionItemRepo repo;
    
    @Override
    protected IGenericRepo<FacturacionItem, Long> getRepo() {
        return repo;
    }
}
