package tn.esprit.ourbank.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ourbank.Configuration.Security.JwtUtils;
import tn.esprit.ourbank.DAO.Entities.ERole;
import tn.esprit.ourbank.DAO.Entities.Role;
import tn.esprit.ourbank.DAO.Entities.User;
import tn.esprit.ourbank.DAO.Forms.request.LoginRequest;
import tn.esprit.ourbank.DAO.Forms.request.SignupRequest;
import tn.esprit.ourbank.DAO.Forms.response.JwtResponse;
import tn.esprit.ourbank.DAO.Forms.response.MessageResponse;
import tn.esprit.ourbank.DAO.Repository.RoleRepository;
import tn.esprit.ourbank.DAO.Repository.UserRepository;
import tn.esprit.ourbank.Service.Implementation.UserDetailsImpl;
import tn.esprit.ourbank.Service.Interface.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  @Autowired
  UserService userService;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(),
                         userDetails.getCin(),
                         userDetails.getAge(),
                         userDetails.getFamilyMembers(),
                         userDetails.getJob(),
                         userDetails.getSalary(),
                         roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody User signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    signUpRequest.setPassword(encoder.encode(signUpRequest.getPassword()));
    userService.AddRoleToUser(signUpRequest, ERole.ROLE_USER);
    userService.addUser(signUpRequest);
    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }


}
