package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.MotivoTrasladoEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IMotivoTrasladoRepo;
import pe.datasys.courier21.service.IMotivoTrasladoService;

@Service
@RequiredArgsConstructor
public class MotivoTrasladoServiceImpl extends CRUDImpl<MotivoTrasladoEntity, String> implements IMotivoTrasladoService {
    
    private final IMotivoTrasladoRepo repo;
    
    @Override
    protected IGenericRepo<MotivoTrasladoEntity, String> getRepo() {
        return repo;
    }
}
