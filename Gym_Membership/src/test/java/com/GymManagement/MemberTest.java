package com.GymManagement;


import com.GymManagement.DTO.Member.Member;
import com.GymManagement.Repository.MemberRepository;
import com.GymManagement.Services.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MemberTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMemberById(){

        Member mockMember = new Member();
        mockMember.setMemberId(1);

        when(memberRepository.findById(1)).thenReturn(Optional.of(mockMember));

        Member member = memberService.getMemberById(1);
        assertNotNull(member);
        assertEquals(1,member.getMemberId());

        verify(memberRepository, times(1)).findById(1);
    }

}
