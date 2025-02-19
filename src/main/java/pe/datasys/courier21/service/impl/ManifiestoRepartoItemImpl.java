package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ManifiestoRepartoItem;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IManifiestoRepartoItemRepo;
import pe.datasys.courier21.service.IManifiestoRepartoItemService;

@Service
@RequiredArgsConstructor
public class ManifiestoRepartoItemImpl extends CRUDImpl<ManifiestoRepartoItem, Long> implements IManifiestoRepartoItemService {
    
    private final IManifiestoRepartoItemRepo repo;
    
    @Override
    protected IGenericRepo<ManifiestoRepartoItem, Long> getRepo() {
        return repo;
    }
}
