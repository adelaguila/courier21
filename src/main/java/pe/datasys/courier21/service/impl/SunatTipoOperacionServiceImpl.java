package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.SunatTipoOperacion;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ISunatTipoOperacionRepo;
import pe.datasys.courier21.service.ISunatTipoOperacionService;

@Service
@RequiredArgsConstructor
public class SunatTipoOperacionServiceImpl extends CRUDImpl<SunatTipoOperacion, String> implements ISunatTipoOperacionService {
    
    private final ISunatTipoOperacionRepo repo;
    
    @Override
    protected IGenericRepo<SunatTipoOperacion, String> getRepo() {
        return repo;
    }
}
