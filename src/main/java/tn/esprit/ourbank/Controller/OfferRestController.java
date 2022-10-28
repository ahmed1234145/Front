package tn.esprit.ourbank.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.DocumentException;


import tn.esprit.ourbank.DAO.Entities.Offer;
import tn.esprit.ourbank.DAO.Entities.SmsRequest;
import tn.esprit.ourbank.Service.Implementation.EmailSenderService;
import tn.esprit.ourbank.Service.Interface.OfferService;
import tn.esprit.ourbank.Service.Interface.SmsSenderService;

@CrossOrigin
@RestController
public class OfferRestController {
	
	@Autowired
	OfferService offerService;
	
	@Autowired 
	SmsSenderService smsSenderService;
	
	@Autowired
	EmailSenderService EmailService;
	
	@GetMapping("allOffers")
	public List<Offer> GetAllOffers(){
		return offerService.retrieveAllOffers();
	}
	
	@PostMapping("addOffer")
	public Offer ajouterOffer(@RequestBody Offer offer) throws MessagingException
		{
		/*EmailService.sendSimpleEmail("ahmed.hamadi@esprit.tn",
 				"Check out our latest and Special Offer",
 				"Brand New Offers");
		smsSenderService.sendSms();*/
		offerService.addOffer(offer);
		
		return offer;
		}
	

    @GetMapping("retrieve_Offer/{id}")
    public Offer retrieveOffer(@PathVariable("id") int id) {
    	
    return offerService.retirieveOffer(id);
    } 
	
    
    @DeleteMapping("/delete_Offer/{id}")  
	public void deleteOfferById(@PathVariable("id")int id) {
    	offerService.deleteOffer(id);
	}
    
     @PutMapping("/modify_Offer_Promotion/{id}/{promotion}") 
    	public void mettreAjourOfferPromotion(@PathVariable("id") int id,@PathVariable("promotion") double promotion) {
    	 offerService.updateOfferByid(id, promotion);
    	}
	

     @PutMapping("/modifynbAjout/{id}") 
    	public void mettreAjourNbAjout(@PathVariable("id") int id) {
    	 offerService.updatenbAjout(id);
    	}
	
     @GetMapping("retrieve_OfferSup/{nb}")
     public List<Offer> retrieveOfferSup(@PathVariable("nb") int nb) {
    	 return offerService.RetrieveOffersSup(nb);
     }
     
     
     @PutMapping("editOffers/{id}")
     public Offer updateeOffer(@RequestBody Offer offer, @PathVariable int id) {
    	return offerService.updateOffer(id,offer); 
     }
     

 	@PostMapping("addNewOffer/{nb}")
 	public void ajouterNOffer(@PathVariable ("nb") int nb){
 		offerService.addNewOffer(nb);
 		}
 	//@Scheduled(cron="0 0 0 1 1/1 *")
 	//@Scheduled(fixedRateString = "PT1M")
 	@PutMapping("modify_Score") 
 	public void MofifierScore() throws NullPointerException {
 			Offer o = null;
 			offerService.updateScore(o);
 	}
 	
 	//@Scheduled(cron="0 0 0 1 1/1 *")
 	//@Scheduled(fixedRateString = "PT1M")
 	@PutMapping("modify_Risque") 
 	public void MofifierRisque() throws NullPointerException {
 			Offer o = null;
 			offerService.updateRisque(o);
 	}
 	//@Scheduled(cron="0 0 0 1 1/1 *")
 	//@Scheduled(fixedRateString = "PT1M")
 	@PutMapping("modify_Promotion") 
 	public void MofifierPromotion() throws NullPointerException {
 			Offer o = null;
 			offerService.updatePromotion(o);
 			
 	}
 	
 	@GetMapping("Recommand_Offer/{Offer_name}")
    public List<Offer> retrieveOffer(@PathVariable("Offer_name") String name) {	
 		return offerService.RecommandOffers(name);
    } 
 	
 	@GetMapping("SendMail")
 	public void triggerMail() throws MessagingException {

 		EmailService.sendEmailWithAttachment("ahmed.hamadi@esprit.tn",
 				"Check out our latest and Special Offer",
 				"Brand New Offers",
				"C:\\Users\\MSI\\Desktop\\3eme\\Projet_PI\\NewOffer.jpg");
	}
 	
 	
 	 @GetMapping("Offerpdf")
     public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
 		 response.setContentType("application/pdf");
         DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
         String currentDateTime = dateFormatter.format(new Date());
          
         String headerKey = "Content-Disposition";
         String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
         response.setHeader(headerKey, headerValue);

         offerService.export(response);
          
     }
 	 
 	@PostMapping
    public void sendSms() {
        smsSenderService.sendSms();
    }
 	
 	
}
