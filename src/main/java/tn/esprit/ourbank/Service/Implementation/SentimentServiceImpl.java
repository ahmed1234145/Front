package tn.esprit.ourbank.Service.Implementation;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ourbank.DAO.Entities.Pipeline;
import tn.esprit.ourbank.DAO.Entities.Post;
import tn.esprit.ourbank.DAO.Repository.PostRepository;
import tn.esprit.ourbank.Service.Interface.SentimentService;

import java.util.List;

@Service
public class SentimentServiceImpl implements SentimentService {

    @Autowired
    PostRepository postRepository;


    @Override
    public int sentimentAnalysis(int id, Post post) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
//        String text = "Hello this is John. I  don't like this place I really like this place, ";
/*
        Post post = postRepository.findById(id).get();
*/

        System.out.println(post);
        String text = post.getText();
        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreSentence> sentences = coreDocument.sentences();
        int nbrP=0;
        int nbrN=0;
        for (CoreSentence sentence : sentences){
            String sentiment = sentence.sentiment();
            System.out.println(sentiment + "\t" + sentence);
            if((sentiment).equals("Positive")){
                nbrP++;
            }else if((sentiment).equals("Negative")){
                nbrN++;
            }
        }
        //System.out.println(nbrP+" "+nbrN);
        if(nbrP-nbrN==0){
            System.out.println("Comment Neutral");
            return 0;
        }else if(nbrP-nbrN>0){
            System.out.println("Positive Comment");
            return 1;
        }else{
            System.out.println("Negtaive Comment");
            return -1;
        }

    }
}
