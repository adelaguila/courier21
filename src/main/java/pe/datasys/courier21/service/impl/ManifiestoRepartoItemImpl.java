package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ManifiestoRepartoItemEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IManifiestoRepartoItemRepo;
import pe.datasys.courier21.service.IManifiestoRepartoItemService;

@Service
@RequiredArgsConstructor
public class ManifiestoRepartoItemImpl extends CRUDImpl<ManifiestoRepartoItemEntity, Long> implements IManifiestoRepartoItemService {
    
    private final IManifiestoRepartoItemRepo repo;
    
    @Override
    protected IGenericRepo<ManifiestoRepartoItemEntity, Long> getRepo() {
        return repo;
    }
}
