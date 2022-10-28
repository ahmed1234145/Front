package tn.esprit.ourbank.Service.Interface;

import tn.esprit.ourbank.DAO.Entities.Staff;


import java.util.List;

public interface StaffService {
    List<Staff> getAllStaffs();
    int addStaff(Staff s);
    int updateStaff(Staff s);
    void deleteStaffById(int id);
}
