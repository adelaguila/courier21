package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.ReporteEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IReporteRepo;
import pe.datasys.courier21.service.IReporteService;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl extends CRUDImpl<ReporteEntity, Long> implements IReporteService {
    
    private final IReporteRepo repo;
    
    @Override
    protected IGenericRepo<ReporteEntity, Long> getRepo() {
        return repo;
    }
}
