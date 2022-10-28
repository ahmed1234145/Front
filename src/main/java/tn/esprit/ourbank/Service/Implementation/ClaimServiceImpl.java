package tn.esprit.ourbank.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ourbank.DAO.Entities.Claim;
import tn.esprit.ourbank.DAO.Entities.Claim;
import tn.esprit.ourbank.DAO.Entities.SmsRequest;
import tn.esprit.ourbank.DAO.Repository.ClaimRepository;
import tn.esprit.ourbank.Service.Interface.ClaimService;
import tn.esprit.ourbank.Service.Interface.SmsSenderService;


import java.util.Arrays;
import java.util.List;
@Service
public class ClaimServiceImpl implements ClaimService {

   // private BadWordFilter badWordFilter = new BadWordFilter();

    @Override
    public List<Claim> retrieveAllClaims() {

        List<Claim> claims= (List<Claim>) (claimRepository.findAll());
        return claims;
    }
    @Autowired
    ClaimRepository claimRepository;
    @Autowired
    SmsSenderService smsService;

    @Override
    public Claim addClaim(Claim c) {
        BadWordFilter.getCensoredText("");
        String [] wordsFromDescription = c.getDescription().split(" ");
        for (String s : wordsFromDescription)
            if (BadWordFilter.allBadWords.containsKey(s.toLowerCase()))
                return null;
        claimRepository.save(c);
        if (c.getUser() != null)
            smsService.sendSms(new SmsRequest("+216" + "27598874", "Claim added !"));
        else
            smsService.sendSms(new SmsRequest("+21627598874", "Claim added !"));
        return c;
    }

    @Override
    public void deleteClaim(int id) {
        claimRepository.deleteById(id);
    }

    @Override
    public Claim updateClaim(Claim c/*, int id*/) {
        BadWordFilter.getCensoredText("");
        String [] wordsFromDescription = c.getDescription().split(" ");
        for (String s : wordsFromDescription)
            if (BadWordFilter.allBadWords.containsKey(s.toLowerCase()))
                return null;
        claimRepository.save(c);
        return c;
    }

    @Override
    public Claim retrieveClaim(int id) {
        return claimRepository.findById(id).get();
    }

    @Override
    public List<Claim> findAllOrderByDate() {
        return claimRepository.findAllByOrderByCreationDate();
    }


    /*public Boolean badWordsValidation(String[] wordsFromText) {
        List<String> restrictWords = restrictWordService.findAll();
        Boolean thatsOk = true;
        if (!restrictWords.isEmpty())
            for (int i = 0; i < wordsFromText.length; i++) {
                String wordFromText = wordsFromText[i];
                if (restrictWords.stream().filter(word -> word.getWord().equalsIgnoreCase(wordFromText)).count() > 0) {
                    thatsOk = false;
                    break;
                }
            }
        return thatsOk;
    }*/

}
