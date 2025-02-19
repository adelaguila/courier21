package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.DespachoValija;
import pe.datasys.courier21.repository.IDespachoValijaRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IDespachoValijaService;

@Service
@RequiredArgsConstructor
public class DespachoValijaServiceImpl extends CRUDImpl<DespachoValija, Long> implements IDespachoValijaService {
    
    private final IDespachoValijaRepo repo;
    
    @Override
    protected IGenericRepo<DespachoValija, Long> getRepo() {
        return repo;
    }
}
