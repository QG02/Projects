package com.GymManagement.Services;

import com.GymManagement.DTO.Member.Member;
import com.GymManagement.Repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMember(){
        return memberRepository.findAll();
    }

    public Member getMemberById(Integer id){
       return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found."));
    }

    @Transactional
    public Member createMember(Member member){
        return memberRepository.save(member);
    }

    @Transactional
    public void deleteMember(Integer id){
        memberRepository.deleteById(id);
    }

}
