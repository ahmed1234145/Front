package tn.esprit.ourbank.Service.Interface;


import tn.esprit.ourbank.DAO.Entities.SmsRequest;

public interface SmsSenderService {

	void sendSms();
	void sendSms(SmsRequest smsRequest);
}
