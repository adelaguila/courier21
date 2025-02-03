package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.SerieComprobanteEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ISerieComprobanteRepo;
import pe.datasys.courier21.service.ISerieComprobanteService;

@Service
@RequiredArgsConstructor
public class SerieComprobanteServiceImpl extends CRUDImpl<SerieComprobanteEntity, String> implements ISerieComprobanteService {
    
    private final ISerieComprobanteRepo repo;
    
    @Override
    protected IGenericRepo<SerieComprobanteEntity, String> getRepo() {
        return repo;
    }
}
