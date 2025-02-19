package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.LiquidacionCliente;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ILiquidacionClienteRepo;
import pe.datasys.courier21.service.ILiquidacionClienteService;

@Service
@RequiredArgsConstructor
public class LiquidacionClienteServiceImpl extends CRUDImpl<LiquidacionCliente, Long> implements ILiquidacionClienteService {
    
    private final ILiquidacionClienteRepo repo;
    
    @Override
    protected IGenericRepo<LiquidacionCliente, Long> getRepo() {
        return repo;
    }
}
