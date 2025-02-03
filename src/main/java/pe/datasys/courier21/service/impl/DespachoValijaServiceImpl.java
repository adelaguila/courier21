package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.DespachoValijaEntity;
import pe.datasys.courier21.repository.IDespachoValijaRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IDespachoValijaService;

@Service
@RequiredArgsConstructor
public class DespachoValijaServiceImpl extends CRUDImpl<DespachoValijaEntity, Long> implements IDespachoValijaService {
    
    private final IDespachoValijaRepo repo;
    
    @Override
    protected IGenericRepo<DespachoValijaEntity, Long> getRepo() {
        return repo;
    }
}
