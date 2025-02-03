package pe.datasys.courier21.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.datasys.courier21.model.User;
import pe.datasys.courier21.repository.IGenericRepo;
import pe.datasys.courier21.repository.IUserRepo;
import pe.datasys.courier21.service.IUserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, Integer> implements IUserService {
    
    private final IUserRepo repo;
    
    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }
}
