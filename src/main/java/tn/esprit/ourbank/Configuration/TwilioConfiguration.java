package tn.esprit.ourbank.Configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration


public class TwilioConfiguration {
	
	private final String accountSid = "AC7fd121267dc9975f24bc7fc05556ec9c";
    private final String authToken = "f7c4c64a03873ed75bea033f7ba42e2c";
    private final String trialNumber = "+15708657519";

    
    public TwilioConfiguration() {
    	
    }    

	public String getAccountSid() {
        return accountSid;
	}

    public String getAuthToken() {
        return authToken;
    }

   
    public String getTrialNumber() {
        return trialNumber;
    }

	
	
}
