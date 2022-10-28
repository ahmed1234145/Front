package tn.esprit.ourbank.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ourbank.DAO.Entities.Claim;
import tn.esprit.ourbank.DAO.Entities.Post;
import tn.esprit.ourbank.DAO.Entities.Sujet;
import tn.esprit.ourbank.DAO.Repository.ClaimRepository;
import tn.esprit.ourbank.DAO.Repository.SujetRepository;
import tn.esprit.ourbank.Service.Interface.SujetService;
import java.util.List;

@Service
public class SujetServiceImpl implements SujetService {
    @Autowired
    SujetRepository sujetRepository;
    @Autowired
    ClaimRepository claimRepository;

    @Override
    public List<Sujet> retrieveAllSujet(){
        List<Sujet> sujets= (List<Sujet>) (sujetRepository.findAll());
        return sujets;
    }

    @Override
    public Sujet addSujet(Sujet t) {
        sujetRepository.save(t);
        return t;
    }
    @Override
    public void deleteSujet(int id) {
        sujetRepository.deleteById(id);
    }
    @Override
    public Sujet updateSujet(Sujet t) {
        sujetRepository.save(t);
        return t;
    }


    @Override
    public Sujet retrieveSujet(int id) {
        return sujetRepository.findById(id).get();
    }

    @Override
    public int retreiveClaimsBySujet(int id) {
        Sujet sujet = sujetRepository.findById(id).get();
        return sujet.getClaims().size();
    }

    @Override
    public double retreiveClaimsBySujetPercentage(int id) {
        Sujet sujet = sujetRepository.findById(id).get();
        int sujetClaims = sujet.getClaims().size();
        int allClaims = claimRepository.findAll().size();
        return (double)sujetClaims / (double)allClaims *100;
    }

}
