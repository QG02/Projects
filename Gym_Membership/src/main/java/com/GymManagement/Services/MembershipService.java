package com.GymManagement.Services;

import com.GymManagement.DTO.MemberShip.Membership;
import com.GymManagement.Repository.MembershipRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MembershipService {

    private final MembershipRepository membershipRepository;

    public MembershipService(MembershipRepository membershipRepository){

        this.membershipRepository = membershipRepository;

    }

    public List<Membership> getAllMemberships(){

        return membershipRepository.findAll();

    }

    public Membership getMembershipById(Integer id){

        return membershipRepository.findById(id).orElseThrow(() -> new RuntimeException("Membership not found."));

    }

    @Transactional
    public  Membership createMembership(Membership membership){

        return membershipRepository.save(membership);

    }

    @Transactional
    public void deleteMembership(Integer id){
        membershipRepository.deleteById(id);
    }

}
