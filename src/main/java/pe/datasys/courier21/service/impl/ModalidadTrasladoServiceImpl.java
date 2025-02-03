package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ModalidadTrasladoEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IModalidadTrasladoRepo;
import pe.datasys.courier21.service.IModalidadTrasladoService;

@Service
@RequiredArgsConstructor
public class ModalidadTrasladoServiceImpl extends CRUDImpl<ModalidadTrasladoEntity, String> implements IModalidadTrasladoService {
    
    private final IModalidadTrasladoRepo repo;
    
    @Override
    protected IGenericRepo<ModalidadTrasladoEntity, String> getRepo() {
        return repo;
    }
}
