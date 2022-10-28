package tn.esprit.ourbank.DAO.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.ourbank.DAO.Entities.Post;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("SELECT p FROM Post p WHERE p.theme.wording= :wording")
    List<Post> retrievePostsByTheme(@Param("wording") String wording);

   // @Modifying
   // @Query("DELETE FROM Post p WHERE Theme.wording= :wording")
   // int deletePostSWithTheme(@Param("wording") String wording);
}
