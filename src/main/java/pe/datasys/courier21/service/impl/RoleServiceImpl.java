package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.Role;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IRoleRepo;
import pe.datasys.courier21.service.IRoleService;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends CRUDImpl<Role, Integer> implements IRoleService {
    
    private final IRoleRepo repo;
    
    @Override
    protected IGenericRepo<Role, Integer> getRepo() {
        return repo;
    }
}
