package tn.esprit.ourbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ourbank.DAO.Entities.Claim;
import tn.esprit.ourbank.DAO.Entities.Sujet;
import tn.esprit.ourbank.Service.Implementation.SujetServiceImpl;
import tn.esprit.ourbank.Service.Interface.ClaimService;
import tn.esprit.ourbank.Service.Interface.SujetService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sujet")
public class SujetRestController {
    @Autowired
    SujetServiceImpl sujetServiceiml;

//    @GetMapping("Claims/{id}")
//    public int retreiveClaimsBySujet(@PathVariable("id") int id) {
//        return sujetService.retreiveClaimsBySujet(id);
//    }
@Autowired
SujetService sujetService;

    // http://localhost:8081/SpringMVC/add-sujet
    @PostMapping("add-sujet")
    @ResponseBody
    public Sujet addSujet(@RequestBody Sujet t)
    {
        Sujet sujet = sujetService.addSujet(t);
        return sujet;
    }

    // URLhttp://localhost:8081/SpringMVC/sujet/getAllSujetNamesJPQL
    @GetMapping("getAllSujetNames")
    public List<Sujet> getAllSujetNames(){
        return sujetService.retrieveAllSujet();
    }

    //urlhttp://localhost:8081/SpringMVC/add-sujet
    @GetMapping("retrieve-sujet/{sujetId}")
    public Sujet retrieveSujet(@PathVariable("sujetId") int sujetId) {
        return sujetService.retrieveSujet(sujetId);
    }

    // http://localhost:8081/SpringMVC/remove-sujet/{sujet-id}
    @DeleteMapping("remove-sujet/{sujetId}")
    @ResponseBody
    public void removeSujet(@PathVariable("sujetId") int sujetId) {
        sujetService.deleteSujet(sujetId);
    }

   // http://localhost:8081/SpringMVC/update-sujet
    @PutMapping("update-sujet")
    public Sujet updateSujet(@RequestBody Sujet sujet) {
        return sujetService.updateSujet(sujet);
    }
    @GetMapping("Claims/{id}")
    public double retreiveClaimsBySujetPercentage(@PathVariable("id") int id) {
        return sujetService.retreiveClaimsBySujetPercentage(id);
    }
}