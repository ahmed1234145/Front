package tn.esprit.ourbank.Service.Interface;

import tn.esprit.ourbank.DAO.Entities.Post;

public interface SentimentService {

     public int sentimentAnalysis(int id, Post post);
}
