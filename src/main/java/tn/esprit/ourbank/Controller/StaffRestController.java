package tn.esprit.ourbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.ourbank.DAO.Entities.RoleStaff;
import tn.esprit.ourbank.DAO.Entities.Staff;

import tn.esprit.ourbank.DAO.Entities.User;
import tn.esprit.ourbank.Service.Interface.StaffService;


import java.util.List;
@RestController
public class StaffRestController {

    @Autowired
    StaffService staffService;

    // URL : http://localhost:8083/SpringMVC/getAllStaffs
    @GetMapping("getAllStaffs")
    public List<Staff> getAllStaffs(){
        return staffService.getAllStaffs();
    }
    // URL : http://localhost:8083/SpringMVC/addStaff
    @PostMapping("addStaff")
    public int addStaff(@RequestBody Staff s){
    	staffService.addStaff(s);
    	return s.getId();
    }
    @PostMapping("addStaff2")
    public int addStaff2(Staff s){
        s.setId(2);
        s.setPwd("565989");
        s.setOffers(null);
        s.setAgency(null);
        s.setTypeStaff(RoleStaff.Consultant);
        staffService.addStaff(s);
        return s.getId();
    }
   // http://localhost:8083/SpringMVC/updateStaff
    @PutMapping("updateStaff")
    public int updateStaff(@RequestBody Staff s){
        staffService.updateStaff(s);
        return s.getId();
    }



    // URL : http://localhost:8083/SpringMVC/deleteStaffById/2
    @DeleteMapping("/deleteStaffById/{staff_id}")
    public void deleteStaffById(@PathVariable("staff_id")int id) {
        staffService.deleteStaffById(id);
    }
}

