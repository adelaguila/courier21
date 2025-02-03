package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ManifiestoSalidaEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IManifiestoSalidaRepo;
import pe.datasys.courier21.service.IManifiestoSalidaService;

@Service
@RequiredArgsConstructor
public class ManifiestoSalidaServiceImpl extends CRUDImpl<ManifiestoSalidaEntity, Long> implements IManifiestoSalidaService {
    
    private final IManifiestoSalidaRepo repo;
    
    @Override
    protected IGenericRepo<ManifiestoSalidaEntity, Long> getRepo() {
        return repo;
    }
}
