package tn.esprit.ourbank.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ourbank.DAO.Entities.Post;
import tn.esprit.ourbank.DAO.Entities.Theme;
import tn.esprit.ourbank.DAO.Repository.PostRepository;
import tn.esprit.ourbank.DAO.Repository.ThemeRepository;
import tn.esprit.ourbank.Service.Interface.ThemeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    ThemeRepository themeRepository;
    @Autowired
    SentimentServiceImpl sentimentService;
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Theme> retrieveAllTheme(){
        List<Theme> themes= (List<Theme>) (themeRepository.findAll());
        return themes;
    }

    @Override
    public Theme addTheme(Theme t) {
        themeRepository.save(t);
        return t;
    }
    @Override
    public void deleteTheme(int id) {
        themeRepository.deleteById(id);
    }
    @Override
    public Theme updateTheme(Theme t) {
        themeRepository.save(t);
        return t;
    }


    @Override
    public Theme retrieveTheme(int id) {
        return themeRepository.findById(id).get();
    }

    @Override
    public int getPostsTotalFeedback(int id) {
        int somme=0;
        List<Post> posts = new ArrayList<>(themeRepository.findById(id).get().getPosts());
        for (int i = 0; i < posts.size(); i++) {
            somme = somme +  posts.get(i).getSetntimentValue();
        }
        return somme ;
    }

   /* public HashMap<Long, Theme> getThemesFeedBack() {
        List<Theme> themes = themeRepository.findAll();
        HashMap<Long, Theme> result = new HashMap<>();
        themes.forEach(theme -> {
            Long positifFeedbacks = Long.valueOf(0);
            for (int i = 0; i < theme.getPosts().toArray().length; i++) {
                Post post = ((Post) theme.getPosts().toArray()[i]);
                positifFeedbacks += sentimentService.sentimentAnalysis(post.getId(),post)
                ;
                result.put(positifFeedbacks, theme);
            }
        });
        return result;
    }*/

}
