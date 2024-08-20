package com.GymManagement.Controller;

import com.GymManagement.DTO.Member.Member;
import com.GymManagement.Services.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    
    private final MemberService memberService;
    
    public MemberController(MemberService memberService){
        
        this.memberService = memberService;
        
    }
    
    @PostMapping
    public Member createMember(@RequestBody Member member){
        
        return memberService.createMember(member);
    
    }

    @GetMapping("/{id}")
    public  Member getMemberById(@PathVariable Integer id){
        
        return memberService.getMemberById(id);
        
    }
}
