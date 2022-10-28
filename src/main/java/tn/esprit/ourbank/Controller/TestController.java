package tn.esprit.ourbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ourbank.DAO.Entities.*;
import tn.esprit.ourbank.DAO.Forms.request.SignupRequest;
import tn.esprit.ourbank.DAO.Forms.response.MessageResponse;
import tn.esprit.ourbank.DAO.Repository.RoleRepository;
import tn.esprit.ourbank.DAO.Repository.UserRepository;
import tn.esprit.ourbank.Service.Interface.UserService;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @Autowired
  UserService userService;
  @Autowired
  PasswordEncoder encoder;
  @Autowired
  RoleRepository roleRepository;
  private String code;

  private String addressemail;

  @GetMapping("/all")
  public String allAccess() {
    return "Welcome To Our Bank";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }


  // URL : http://localhost:8081/getAllUsers
  @GetMapping("/getAllUsers")
  @PreAuthorize("hasRole('MODERATOR')or hasRole('ADMIN')")
  public List<User> getAllUsers(){
    return userService.getAllUsers();
  }


  // URL : http://localhost:8081/addUser
  @PostMapping("/addUser")
  @PreAuthorize("hasRole('ADMIN')")
  public User addUser(@RequestBody SignupRequest u){
   /* u.setPassword(encoder.encode(u.getPassword()));
    userService.AddRoleToUser(u, ERole.ROLE_USER);
    userService.addUser(u);
    return u;*/
    /*
    if (userRepository.existsByUsername(u.getUsername())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(u.getEmail())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Email is already in use!"));
    }
*/
    // Create new user's account
    User user = new User(u.getUsername(),
            u.getEmail(),
            encoder.encode(u.getPassword()),
            u.getCin(),
            u.getAge(),
            u.getFamilyMembers(),
            u.getJob(),
            u.getSalary());

    String strRoles = u.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {

        switch (strRoles) {
          case "admin":
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);

            break;
          case "mod":
            Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(modRole);

            break;
          default:
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        }
      ;
    }

    user.setRoles(roles);
    userService.addUser(user);
    //userService.sendEmail(user.getEmail(),"Welecome To OurBank","Welecome To OurBank "+user.getUsername());
    return user;
  }







  // URL : http://localhost:8081/getUserById/1
  @GetMapping("getUserById/{user_id}")
  public User getUserById(@PathVariable("user_id") Long id) {
    return userService.getUserById(id);
  }

  @GetMapping("getUserByUsername/{user_Username}")
  public User getUserByUsername(@PathVariable("user_Username") String Username) {
    return userService.getByUserName(Username);
  }

  // URL : http://localhost:8081/updateUser
  @PutMapping("updateUser")

  public User updateUser(@RequestBody SignupRequest  u){
    User user =userService.getByUserName(u.getUsername());
    user.setJob(u.getJob());
    user.setAge(u.getAge());
    user.setSalary(u.getSalary());
    user.setFamilyMembers(u.getFamilyMembers());
    userService.updateUser(user);
    return user;
  }


  // URL : http://localhost:8082/api/test/deleteUserById/1
  @DeleteMapping("/deleteUserById/{user_id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void deleteUserById(@PathVariable("user_id")Long id) {
    userService.deleteUserById(id);
  }

// URL : http://localhost:8082/api/test/forgotPassword/wissem.lahbib@esprit.tn
  @GetMapping("forgotPassword/{user_email}")
  public String forgotPassword(@PathVariable("user_email") String email) {
    code=userService.forgotPassword(email);
    return "Check Your Email";
  }
  // URL : http://localhost:8082/api/test/saisirCode/7wEpvy
  @GetMapping("saisirCode/{usercode}/{userEmail}")
  public String saisirCode(@PathVariable("usercode")String usercode,@PathVariable("userEmail")String email) {
    if(userService.compareCodes(code,usercode)) {
      userService.newPassword(email);
      return "Check Your Email";
    }
    return "Code Invalid";
  }
  @GetMapping("/getStat")

  public List<Stat> getStat(){
    return userService.getStat();
  }

  @GetMapping("/getStat2")

  public List<Stat2> getStat2(){
    return userService.getStat2();
  }

@GetMapping("/getStat3")
public List<Stat3> getStat3(){return userService.getStat3();}
}
