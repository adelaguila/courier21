package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TarifarioEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITarifarioRepo;
import pe.datasys.courier21.service.ITarifarioService;

@Service
@RequiredArgsConstructor
public class TarifarioServiceImpl extends CRUDImpl<TarifarioEntity, Long> implements ITarifarioService {
    
    private final ITarifarioRepo repo;
    
    @Override
    protected IGenericRepo<TarifarioEntity, Long> getRepo() {
        return repo;
    }
}
