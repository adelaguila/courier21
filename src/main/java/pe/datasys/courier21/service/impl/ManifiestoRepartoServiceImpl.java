package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ManifiestoReparto;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IManifiestoRepartoRepo;
import pe.datasys.courier21.service.IManifiestoRepartoService;

@Service
@RequiredArgsConstructor
public class ManifiestoRepartoServiceImpl extends CRUDImpl<ManifiestoReparto, Long> implements IManifiestoRepartoService {
    
    private final IManifiestoRepartoRepo repo;
    
    @Override
    protected IGenericRepo<ManifiestoReparto, Long> getRepo() {
        return repo;
    }
}
