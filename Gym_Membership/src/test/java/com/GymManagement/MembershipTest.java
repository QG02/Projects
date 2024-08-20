package com.GymManagement;

import com.GymManagement.DTO.MemberShip.Membership;
import com.GymManagement.Repository.MembershipRepository;
import com.GymManagement.Services.MembershipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MembershipTest {

    @InjectMocks
    private MembershipService membershipService;

    @Mock
    private MembershipRepository membershipRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMembershipById(){

        Membership mockMembership = new Membership();
        mockMembership.setMembershipId(1);

        when(membershipRepository.findById(1)).thenReturn(Optional.of(mockMembership));

        Membership membership = membershipService.getMembershipById(1);
        assertNotNull(membership);
        assertEquals(1, membership.getMembershipId());

        verify(membershipRepository, times(1));
    }
}
