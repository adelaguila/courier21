package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.RecojoEstado;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IRecojoEstadoRepo;
import pe.datasys.courier21.service.IRecojoEstadoService;

@Service
@RequiredArgsConstructor
public class RecojoEstadoServiceImpl extends CRUDImpl<RecojoEstado, Integer> implements IRecojoEstadoService {
    
    private final IRecojoEstadoRepo repo;
    
    @Override
    protected IGenericRepo<RecojoEstado, Integer> getRepo() {
        return repo;
    }
}
