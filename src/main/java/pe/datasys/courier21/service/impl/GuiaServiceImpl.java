package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.Guia;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IGuiaRepo;
import pe.datasys.courier21.service.IGuiaService;

@Service
@RequiredArgsConstructor
public class GuiaServiceImpl extends CRUDImpl<Guia, Long> implements IGuiaService {
    
    private final IGuiaRepo repo;
    
    @Override
    protected IGenericRepo<Guia, Long> getRepo() {
        return repo;
    }
}
