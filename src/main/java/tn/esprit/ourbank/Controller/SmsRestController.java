package tn.esprit.ourbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ourbank.DAO.Entities.SmsRequest;
import tn.esprit.ourbank.Service.Interface.SmsSenderService;


@RestController
@RequestMapping("sms/")
public class SmsRestController {


    @Autowired
    SmsSenderService smsService;

    @PostMapping("send")
    public void sendSms(@RequestBody SmsRequest smsRequest) {
        smsService.sendSms(smsRequest);
    }
}
