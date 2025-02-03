package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.GuiaEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IGuiaRepo;
import pe.datasys.courier21.service.IGuiaService;

@Service
@RequiredArgsConstructor
public class GuiaServiceImpl extends CRUDImpl<GuiaEntity, Long> implements IGuiaService {
    
    private final IGuiaRepo repo;
    
    @Override
    protected IGenericRepo<GuiaEntity, Long> getRepo() {
        return repo;
    }
}
