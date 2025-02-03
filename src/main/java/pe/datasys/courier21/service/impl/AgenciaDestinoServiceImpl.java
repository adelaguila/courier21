package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.AgenciaDestinoEntity;
import pe.datasys.courier21.repository.IAgenciaDestinoRepo;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.service.IAgenciaDestinoService;

@Service
@RequiredArgsConstructor
public class AgenciaDestinoServiceImpl extends CRUDImpl<AgenciaDestinoEntity, Integer> implements IAgenciaDestinoService {

    private final IAgenciaDestinoRepo repo;

    @Override
    protected IGenericRepo<AgenciaDestinoEntity, Integer> getRepo() {
        return repo;
    }
}
