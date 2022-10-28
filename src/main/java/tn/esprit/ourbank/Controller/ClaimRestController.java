package tn.esprit.ourbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ourbank.DAO.Entities.Claim;
import tn.esprit.ourbank.DAO.Entities.Claim;
import tn.esprit.ourbank.Service.Interface.ClaimService;

import java.util.List;
@RequestMapping("/Claim")
@CrossOrigin
@RestController
public class ClaimRestController {
    @Autowired
    ClaimService claimService;
    @GetMapping("getAllClaimsNamesJPQL")
    public List<Claim> getAllClaimsNamesJPQL(){
        return claimService.retrieveAllClaims();
    }
    //urlhttp://localhost:8089/SpringMVC/add-claim
    @GetMapping("retrieve-claim/{claimId}")
    public Claim retrieveClaim(@PathVariable("claimId") int claimId) {
        return claimService.retrieveClaim(claimId);
    }
    // http://localhost:8089/SpringMVC/add-claim
    @PostMapping("/add-claim")
    @ResponseBody
    public Claim addClaim(@RequestBody Claim c)
    {
        Claim claim = claimService.addClaim(c);
        return claim;
    }
    // http://localhost:8089/SpringMVC/remove-claim/{claim-id}
    @DeleteMapping("/remove-claim/{claimId}")
    @ResponseBody
    public void removeClaim(@PathVariable("claimId") int claimId) {
        claimService.deleteClaim(claimId);
    }
    // http://localhost:8089/SpringMVC/update-claim


    @GetMapping("/findAllByDate")
    public List<Claim> findAllByDate(){
        return claimService.findAllOrderByDate();


    }
    @PutMapping("update-claim")
    public Claim updateClaim(@RequestBody Claim claim) {
        return claimService.updateClaim(claim);
    }
}
