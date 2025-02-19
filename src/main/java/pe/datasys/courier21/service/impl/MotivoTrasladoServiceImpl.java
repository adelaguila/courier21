package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.MotivoTraslado;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IMotivoTrasladoRepo;
import pe.datasys.courier21.service.IMotivoTrasladoService;

@Service
@RequiredArgsConstructor
public class MotivoTrasladoServiceImpl extends CRUDImpl<MotivoTraslado, String> implements IMotivoTrasladoService {
    
    private final IMotivoTrasladoRepo repo;
    
    @Override
    protected IGenericRepo<MotivoTraslado, String> getRepo() {
        return repo;
    }
}
