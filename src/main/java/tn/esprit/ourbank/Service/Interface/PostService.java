package tn.esprit.ourbank.Service.Interface;
import tn.esprit.ourbank.DAO.Entities.Post;

import java.util.List;

public interface PostService {
    List<Post> retrieveAllPosts();
    Post addPost(Post p);
    void deletePost(int id);
    Post updatePost(Post p);
    Post retrievePost(int id);

   List<Post> postsToTheme(String wording);

   // void delPosts(String wording);
}
