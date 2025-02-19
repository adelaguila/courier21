package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.Banco;
import pe.datasys.courier21.repository.IBancoRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IBancoService;

@Service
@RequiredArgsConstructor
public class BancoServiceImpl extends CRUDImpl<Banco, Integer> implements IBancoService {
    
    private final IBancoRepo repo;
    
    @Override
    protected IGenericRepo<Banco, Integer> getRepo() {
        return repo;
    }
}
