package com.GymManagement.Controller;

import com.GymManagement.DTO.Staff.Staff;
import com.GymManagement.Services.StaffService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staffs")
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService){

        this.staffService = staffService;

    }

    @PostMapping
    public Staff createStaff(@RequestBody Staff staff){

        return staffService.createStaff(staff);

    }

    @GetMapping("/{id}")
    public  Staff getStaffById(@PathVariable Integer id){

        return staffService.getStaffById(id);

    }
}
