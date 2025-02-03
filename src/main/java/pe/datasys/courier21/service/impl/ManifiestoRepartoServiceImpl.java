package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ManifiestoRepartoEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IManifiestoRepartoRepo;
import pe.datasys.courier21.service.IManifiestoRepartoService;

@Service
@RequiredArgsConstructor
public class ManifiestoRepartoServiceImpl extends CRUDImpl<ManifiestoRepartoEntity, Long> implements IManifiestoRepartoService {
    
    private final IManifiestoRepartoRepo repo;
    
    @Override
    protected IGenericRepo<ManifiestoRepartoEntity, Long> getRepo() {
        return repo;
    }
}
