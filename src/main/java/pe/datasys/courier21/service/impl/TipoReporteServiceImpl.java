package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.TipoReporte;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ITipoReporteRepo;
import pe.datasys.courier21.service.ITipoReporteService;

@Service
@RequiredArgsConstructor
public class TipoReporteServiceImpl extends CRUDImpl<TipoReporte, Integer> implements ITipoReporteService {
    
    private final ITipoReporteRepo repo;
    
    @Override
    protected IGenericRepo<TipoReporte, Integer> getRepo() {
        return repo;
    }
}
