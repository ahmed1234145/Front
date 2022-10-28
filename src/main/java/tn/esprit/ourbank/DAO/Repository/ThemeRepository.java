package tn.esprit.ourbank.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.ourbank.DAO.Entities.Post;
import tn.esprit.ourbank.DAO.Entities.Theme;

import java.util.List;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {

}
