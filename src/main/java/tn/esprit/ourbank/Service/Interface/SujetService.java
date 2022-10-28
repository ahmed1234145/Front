package tn.esprit.ourbank.Service.Interface;

import tn.esprit.ourbank.DAO.Entities.Claim;
import tn.esprit.ourbank.DAO.Entities.Sujet;

import java.util.List;


public interface SujetService {
    List<Sujet> retrieveAllSujet();
    Sujet addSujet(Sujet t);
    void deleteSujet(int id);
    Sujet updateSujet(Sujet t);
    Sujet retrieveSujet(int id);
    int retreiveClaimsBySujet(int id);
    double retreiveClaimsBySujetPercentage(int id);
}


