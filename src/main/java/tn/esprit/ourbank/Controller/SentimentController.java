package tn.esprit.ourbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ourbank.DAO.Repository.PostRepository;
import tn.esprit.ourbank.Service.Interface.SentimentService;

@RestController
@RequestMapping("sentiment/")
public class SentimentController {

    @Autowired
    SentimentService sentimentService;

    @GetMapping("sentimentAnalysisByPost/{id}")
    public void sentimentAnalysis(@PathVariable("id") int id){
/*
        sentimentService.sentimentAnalysis(id);
*/
    }


}
