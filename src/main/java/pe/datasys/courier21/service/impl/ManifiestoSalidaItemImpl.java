package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ManifiestoSalidaItem;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IManifiestoSalidaItemRepo;
import pe.datasys.courier21.service.IManifiestoSalidaItemService;

@Service
@RequiredArgsConstructor
public class ManifiestoSalidaItemImpl extends CRUDImpl<ManifiestoSalidaItem, Long> implements IManifiestoSalidaItemService {
    
    private final IManifiestoSalidaItemRepo repo;
    
    @Override
    protected IGenericRepo<ManifiestoSalidaItem, Long> getRepo() {
        return repo;
    }
}
