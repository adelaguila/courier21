package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.AgenciaEntity;
import pe.datasys.courier21.repository.IAgenciaRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IAgenciaService;

@Service
@RequiredArgsConstructor
public class AgenciaServiceImpl extends CRUDImpl<AgenciaEntity, Integer> implements IAgenciaService {
    
    private final IAgenciaRepo repo;
    
    @Override
    protected IGenericRepo<AgenciaEntity, Integer> getRepo() {
        return repo;
    }
}
