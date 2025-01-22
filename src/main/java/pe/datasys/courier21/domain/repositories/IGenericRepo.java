package pe.datasys.courier21.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepo <T, ID> extends JpaRepository<T, ID> {
}
