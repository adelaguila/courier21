package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.Recojo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IRecojoRepo;
import pe.datasys.courier21.service.IRecojoService;

@Service
@RequiredArgsConstructor
public class RecojoServiceImpl extends CRUDImpl<Recojo, Long> implements IRecojoService {
    
    private final IRecojoRepo repo;
    
    @Override
    protected IGenericRepo<Recojo, Long> getRepo() {
        return repo;
    }
}
