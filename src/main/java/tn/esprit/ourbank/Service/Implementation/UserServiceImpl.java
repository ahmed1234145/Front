package tn.esprit.ourbank.Service.Implementation;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.ourbank.DAO.Entities.*;
import tn.esprit.ourbank.DAO.Repository.RoleRepository;
import tn.esprit.ourbank.DAO.Repository.UserRepository;
import tn.esprit.ourbank.Service.Interface.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();    }

    @Override
    public User addUser(User u) {
       // sendEmail(u.getEmail(),"Welecome To OurBank","Welecome To OurBank "+u.getUsername());
    userRepository.save(u);

    return u;
    }

    @Override
    public User updateUser(User u) {
        userRepository.save(u);
        return u;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void AddRoleToUser(User u , ERole eRole)
    {
        Role role=roleRepository.findByName(eRole).get();
        u.getRoles().add(role);
        userRepository.save(u);
    }
    @Override
    public void sendEmail(String email, String subject, String body) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("our.bankpi@gmail.com");
        message.setTo(email);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
        System.out.println("Email Sent Successfully");
    }

    @Override
    public String forgotPassword(String email) {
        String code= RandomStringUtils.randomAlphanumeric(6);
        sendEmail(email,"Forgot Password",code);
        return code;
    }

    @Override
    public boolean compareCodes(String c1, String c2) {
        return c1.equals(c2);
    }

    @Override
    public void newPassword(String email) {
        String newpass =RandomStringUtils.randomAlphanumeric(10);
        User u=userRepository.findByEmail(email).get();
        if(u != null ){
        u.setPassword(encoder.encode(newpass));
        userRepository.save(u);
        sendEmail(email,"New Password Rest",newpass);}
        else
            System.out.println("User Not Found");

    }

    @Override
    public User getByUserName(String Username) {
       return userRepository.findByUsername(Username).get();
    }

    @Override
    public List<Stat> getStat() {
        return userRepository.getStat();
    }

    @Override
    public List<Stat2> getStat2() {
        return userRepository.getStat2();
    }

    @Override
    public List<Stat3> getStat3() {
        return userRepository.getStat3();
    }
}
