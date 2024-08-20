package com.GymManagement.Services;

import com.GymManagement.DTO.Staff.Staff;
import com.GymManagement.Repository.StaffRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaffs(){
        return staffRepository.findAll();
    }

    public Staff getStaffById(Integer id){
        return staffRepository.findById(id).orElseThrow(() -> new RuntimeException("Staff not found."));
    }

    @Transactional
    public Staff createStaff(Staff staff){
        return staffRepository.save(staff);
    }

    @Transactional
    public void deleteStaff(Integer id){
        staffRepository.deleteById(id);
    }

}
