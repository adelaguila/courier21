package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.GuiaItem;
import pe.datasys.courier21.repository.IGuiaItemRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IGuiaItemService;

@Service
@RequiredArgsConstructor
public class GuiaItemImpl extends CRUDImpl<GuiaItem, Long> implements IGuiaItemService {
    
    private final IGuiaItemRepo repo;
    
    @Override
    protected IGenericRepo<GuiaItem, Long> getRepo() {
        return repo;
    }
}
