package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ModalidadTraslado;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IModalidadTrasladoRepo;
import pe.datasys.courier21.service.IModalidadTrasladoService;

@Service
@RequiredArgsConstructor
public class ModalidadTrasladoServiceImpl extends CRUDImpl<ModalidadTraslado, String> implements IModalidadTrasladoService {
    
    private final IModalidadTrasladoRepo repo;
    
    @Override
    protected IGenericRepo<ModalidadTraslado, String> getRepo() {
        return repo;
    }
}
