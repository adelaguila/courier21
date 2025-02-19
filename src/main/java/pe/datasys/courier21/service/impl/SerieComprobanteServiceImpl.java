package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.SerieComprobante;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ISerieComprobanteRepo;
import pe.datasys.courier21.service.ISerieComprobanteService;

@Service
@RequiredArgsConstructor
public class SerieComprobanteServiceImpl extends CRUDImpl<SerieComprobante, String> implements ISerieComprobanteService {
    
    private final ISerieComprobanteRepo repo;
    
    @Override
    protected IGenericRepo<SerieComprobante, String> getRepo() {
        return repo;
    }
}
