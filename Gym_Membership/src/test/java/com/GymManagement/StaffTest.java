package com.GymManagement;

import com.GymManagement.DTO.Staff.Staff;
import com.GymManagement.Repository.StaffRepository;
import com.GymManagement.Services.StaffService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StaffTest {

    @InjectMocks
    private StaffService staffService;

    @Mock
    private StaffRepository staffRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStaffById(){

        Staff mockStaff = new Staff();
        mockStaff.setStaffId(1);

        when(staffRepository.findById(1)).thenReturn(Optional.of(mockStaff));

        Staff staff = staffService.getStaffById(1);
        assertNotNull(staff);
        assertEquals(1, staff.getStaffId());

        verify(staffRepository, times(1));
    }
}

