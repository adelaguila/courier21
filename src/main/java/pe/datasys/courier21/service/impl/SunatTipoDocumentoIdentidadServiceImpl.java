package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.SunatTipoDocumentoIdentidad;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ISunatTipoDocumentoIdentidadRepo;
import pe.datasys.courier21.service.ISunatTipoDocumentoIdentidadService;

@Service
@RequiredArgsConstructor
public class SunatTipoDocumentoIdentidadServiceImpl extends CRUDImpl<SunatTipoDocumentoIdentidad, String> implements ISunatTipoDocumentoIdentidadService {
    
    private final ISunatTipoDocumentoIdentidadRepo repo;
    
    @Override
    protected IGenericRepo<SunatTipoDocumentoIdentidad, String> getRepo() {
        return repo;
    }
}
