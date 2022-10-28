package tn.esprit.ourbank.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ourbank.DAO.Entities.Post;
import tn.esprit.ourbank.DAO.Repository.PostRepository;
import tn.esprit.ourbank.Service.Interface.PostService;
import tn.esprit.ourbank.Service.Interface.SentimentService;

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    SentimentService sentimentService;

    @Override
    public List<Post> retrieveAllPosts(){
        return postRepository.findAll();
    }
    @Override
    public Post addPost(Post p) {
/*
        sentimentService.sentimentAnalysis(p.getId(),p);
*/
        p.setSetntimentValue(sentimentService.sentimentAnalysis(p.getId(),p));

        postRepository.save(p);
        return p;
    }
    @Override
    public void deletePost(int id) {
        postRepository.deleteById(id);
    }
    @Override
    public Post updatePost(Post p) {
        postRepository.save(p);
        return p;
    }
    @Override
    public Post retrievePost(int id) {
        return postRepository.findById(id).get();
    }

    @Override
   public List<Post> postsToTheme(String wording){
       return postRepository.retrievePostsByTheme(wording);
    }
   // @Override
   // public void delPosts(String wording){
    //    postRepository.deletePostSWithTheme(wording);
   // }


}
