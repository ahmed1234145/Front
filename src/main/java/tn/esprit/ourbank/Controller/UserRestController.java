package tn.esprit.ourbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ourbank.DAO.Entities.RoleClient;
import tn.esprit.ourbank.DAO.Entities.User;
import tn.esprit.ourbank.Service.Interface.UserService;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    // URL : http://localhost:8081/SpringMVC/getAllUsers
    @GetMapping("getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    // URL : http://localhost:8081/SpringMVC/addUser
    @PostMapping("addUser")
    public int addUser(User u){
        u.setId(1);
        u.setName("Wissem");
        u.setFirstName("Lahbib");
        u.setEmail("lb@es.com");
        u.setPassword("0000");
        u.setCin("00000001");
        u.setAddress("Bizerte");
        u.setPhoneNum(55555555L);
        u.setJob("Ing");
        u.setStatu(true);
        u.setType(RoleClient.Client);
        u.setClaims(null);
        u.setPosts(null);
        u.setMaterialses(null);
        userService.addUser(u);
        return u.getId();
    }

    // URL : http://localhost:8081/SpringMVC/addUser2
    @PostMapping("addUser2")
    public int addUser2(User u){
        u.setId(2);
        u.setName("Bassem");
        u.setFirstName("Lahbib");
        u.setEmail("lb@es.com");
        u.setPassword("4444");
        u.setCin("25205251");
        u.setAddress("Bizerte");
        u.setPhoneNum(55555555L);
        u.setJob("Ing");
        u.setStatu(true);
        u.setType(RoleClient.Client);
        u.setClaims(null);
        u.setPosts(null);
        u.setMaterialses(null);
        userService.addUser(u);
        return u.getId();
    }


    // URL : http://localhost:8081/SpringMVC/getUserById/1
    @GetMapping("getUserById/{user_id}")
    public User getUserById(@PathVariable("user_id") int id) {
        return userService.getUserById(id);
    }
    // URL : http://localhost:8081/SpringMVC/updateUser
    @PutMapping("updateUser")
    public int updateUser(User u){
        u.setId(1);
        u.setName("Med");
        u.setFirstName("Lahbib");
        u.setEmail("lb@es.com");
        u.setPassword("1111");
        u.setCin("00000002");
        u.setAddress("Bizerte");
        u.setPhoneNum(55555555L);
        u.setJob("Ing");
        u.setStatu(true);
        u.setType(RoleClient.Client);
        u.setClaims(null);
        u.setPosts(null);
        u.setMaterialses(null);
        userService.addUser(u);
        return u.getId();
    }
    // URL : http://localhost:8081/SpringMVC/deleteUserById/2
    @DeleteMapping("/deleteUserById/{user_id}")
    public void deleteUserById(@PathVariable("user_id")int id) {
        userService.deleteUserById(id);
    }
}
