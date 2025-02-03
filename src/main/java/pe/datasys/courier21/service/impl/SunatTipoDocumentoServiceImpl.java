package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.SunatTipoDocumento;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ISunatTipoDocumentoRepo;
import pe.datasys.courier21.service.ISunatTipoDocumentoService;

@Service
@RequiredArgsConstructor
public class SunatTipoDocumentoServiceImpl extends CRUDImpl<SunatTipoDocumento, String> implements ISunatTipoDocumentoService {
    
    private final ISunatTipoDocumentoRepo repo;
    
    @Override
    protected IGenericRepo<SunatTipoDocumento, String> getRepo() {
        return repo;
    }
}
