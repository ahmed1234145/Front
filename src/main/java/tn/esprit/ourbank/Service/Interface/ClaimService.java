package tn.esprit.ourbank.Service.Interface;

import tn.esprit.ourbank.DAO.Entities.Claim;

import java.util.List;

public interface ClaimService {
    List<Claim> retrieveAllClaims();
    Claim addClaim(Claim c);
    void deleteClaim(int id);
    Claim updateClaim(Claim c);
    Claim retrieveClaim(int id);
    List<Claim> findAllOrderByDate();
}
