package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.Tarifario;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITarifarioRepo;
import pe.datasys.courier21.service.ITarifarioService;

@Service
@RequiredArgsConstructor
public class TarifarioServiceImpl extends CRUDImpl<Tarifario, Long> implements ITarifarioService {
    
    private final ITarifarioRepo repo;
    
    @Override
    protected IGenericRepo<Tarifario, Long> getRepo() {
        return repo;
    }
}
