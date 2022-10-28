package tn.esprit.ourbank.Service.Interface;

import tn.esprit.ourbank.DAO.Entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User addUser(User u);
    User updateUser(User u);
    void deleteUserById(Long id);
    User getUserById(Long id);
    void AddRoleToUser(User u , ERole eRole);
    void sendEmail(String email,String subject,String body);
    String forgotPassword(String email);
    boolean compareCodes(String c1 ,String c2);
    void newPassword(String email);
    User getByUserName(String Username);
    List<Stat> getStat();
    List<Stat2> getStat2();
    List<Stat3> getStat3();

}
