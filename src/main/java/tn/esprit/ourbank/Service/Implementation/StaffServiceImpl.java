package tn.esprit.ourbank.Service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ourbank.DAO.Entities.Staff;
import tn.esprit.ourbank.DAO.Repository.StaffRepository;
import tn.esprit.ourbank.Service.Interface.StaffService;

import java.util.List;
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffRepository staffRepository;
    @Override
    public List<Staff> getAllStaffs() {
        return (List<Staff>) (staffRepository.findAll());
    }

    @Override
    public int addStaff(Staff s) {
        staffRepository.save(s);
        return s.getId();
    }

    @Override
    public int updateStaff(Staff s) {
        staffRepository.save(s);
        return s.getId();
    }

    @Override
    public void deleteStaffById(int id) {
        staffRepository.deleteById(id);

    }
}
