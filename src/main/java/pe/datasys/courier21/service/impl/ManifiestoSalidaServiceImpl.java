package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ManifiestoSalida;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IManifiestoSalidaRepo;
import pe.datasys.courier21.service.IManifiestoSalidaService;

@Service
@RequiredArgsConstructor
public class ManifiestoSalidaServiceImpl extends CRUDImpl<ManifiestoSalida, Long> implements IManifiestoSalidaService {
    
    private final IManifiestoSalidaRepo repo;
    
    @Override
    protected IGenericRepo<ManifiestoSalida, Long> getRepo() {
        return repo;
    }
}
