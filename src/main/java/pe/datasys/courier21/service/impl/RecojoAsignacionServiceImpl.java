package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.RecojoAsignacionEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IRecojoAsignacionRepo;
import pe.datasys.courier21.service.IRecojoAsignacionService;

@Service
@RequiredArgsConstructor
public class RecojoAsignacionServiceImpl extends CRUDImpl<RecojoAsignacionEntity, Long> implements IRecojoAsignacionService {
    
    private final IRecojoAsignacionRepo repo;
    
    @Override
    protected IGenericRepo<RecojoAsignacionEntity, Long> getRepo() {
        return repo;
    }
}
