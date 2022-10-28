package tn.esprit.ourbank.DAO.Repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ourbank.DAO.Entities.Stat;
import tn.esprit.ourbank.DAO.Entities.Stat2;
import tn.esprit.ourbank.DAO.Entities.Stat3;
import tn.esprit.ourbank.DAO.Entities.User;

import java.util.*;
import java.util.HashMap;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  Optional<User> findByUsername(String username);
  Optional<User> findByEmail(String email);
  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);
  @Query("SELECT " +
          "    new tn.esprit.ourbank.DAO.Entities.Stat(count(u), u.job) " +
          "FROM " +
          "    User u " +
          "GROUP BY " +
          "    u.job")
  public List<Stat> getStat();
  @Query("SELECT " +
          "    new tn.esprit.ourbank.DAO.Entities.Stat2(count(u),u.salary) " +
          "FROM " +
          "    User u " +
          "GROUP BY " +
          "    u.salary")
  public List<Stat2> getStat2();
  @Query("SELECT " +
          "    new tn.esprit.ourbank.DAO.Entities.Stat3(count(u), u.age) " +
          "FROM " +
          "    User u " +
          "GROUP BY " +
          "    u.age")
  public List<Stat3> getStat3();


}
