package tn.esprit.ourbank.DAO.Repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ourbank.DAO.Entities.ERole;
import tn.esprit.ourbank.DAO.Entities.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
