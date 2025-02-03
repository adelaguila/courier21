package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.LiquidacionClienteEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ILiquidacionClienteRepo;
import pe.datasys.courier21.service.ILiquidacionClienteService;

@Service
@RequiredArgsConstructor
public class LiquidacionClienteServiceImpl extends CRUDImpl<LiquidacionClienteEntity, Long> implements ILiquidacionClienteService {
    
    private final ILiquidacionClienteRepo repo;
    
    @Override
    protected IGenericRepo<LiquidacionClienteEntity, Long> getRepo() {
        return repo;
    }
}
