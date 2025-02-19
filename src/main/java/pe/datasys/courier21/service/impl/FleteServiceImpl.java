package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.Flete;
import pe.datasys.courier21.repository.IFleteRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IFleteService;

@Service
@RequiredArgsConstructor
public class FleteServiceImpl extends CRUDImpl<Flete, Long> implements IFleteService {
    
    private final IFleteRepo repo;
    
    @Override
    protected IGenericRepo<Flete, Long> getRepo() {
        return repo;
    }
}
