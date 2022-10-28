package tn.esprit.ourbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ourbank.DAO.Entities.Post;
import tn.esprit.ourbank.Service.Interface.PostService;

import java.util.List;
@RequestMapping("post/")
@CrossOrigin
@RestController

public class PostRestController {
    @Autowired
    PostService postService;


    @GetMapping("getAllPostNamesJPQL")
    public List<Post> getAllPostNamesJPQL(){
        return postService.retrieveAllPosts();
    }
    //urlhttp://localhost:8089/SpringMVC/add-post


    @GetMapping("retrieve-post/{postId}")
    public Post retrievePost(@PathVariable("postId") int postId) {
        return postService.retrievePost(postId);
    }


    // http://localhost:8089/SpringMVC/post/add-post
    @PostMapping("/add-post")
    @ResponseBody
    public Post addPost(@RequestBody Post t)
    {
        Post post = postService.addPost(t);
        return post;
    }


    // http://localhost:8089/SpringMVC/remove-post/{post-id}
    @DeleteMapping("/remove-post/{postId}")
    @ResponseBody
    public void removePost(@PathVariable("postId") int postId) {
        postService.deletePost(postId);
    }



    // http://localhost:8089/SpringMVC/update-post
    @PutMapping("update-post")
    @ResponseBody
    public Post updatePost(@RequestBody Post post) {
        return postService.updatePost(post);
    }


    @GetMapping("/retrievepostsbytheme/{word}")
   public List<Post> retrievepostsbytheme(@PathVariable("word") String wording){
     return postService.postsToTheme(wording);
  }
  //  @DeleteMapping("/delete-post/{text}")
  //  public void deletePost(@PathVariable("text") String wording){
     //   postService.delPosts(wording);
   // }
}
