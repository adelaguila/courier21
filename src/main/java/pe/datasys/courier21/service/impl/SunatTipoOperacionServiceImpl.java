package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.SunatTipoOperacionEntity;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.ISunatTipoOperacionRepo;
import pe.datasys.courier21.service.ISunatTipoOperacionService;

@Service
@RequiredArgsConstructor
public class SunatTipoOperacionServiceImpl extends CRUDImpl<SunatTipoOperacionEntity, String> implements ISunatTipoOperacionService {
    
    private final ISunatTipoOperacionRepo repo;
    
    @Override
    protected IGenericRepo<SunatTipoOperacionEntity, String> getRepo() {
        return repo;
    }
}
