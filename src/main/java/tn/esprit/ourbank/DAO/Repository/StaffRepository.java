package tn.esprit.ourbank.DAO.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ourbank.DAO.Entities.Staff;
@Repository
public interface StaffRepository extends CrudRepository<Staff,Integer> {
}
