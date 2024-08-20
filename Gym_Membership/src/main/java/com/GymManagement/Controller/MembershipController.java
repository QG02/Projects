package com.GymManagement.Controller;

import com.GymManagement.DTO.MemberShip.Membership;
import com.GymManagement.Services.MembershipService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/membership")
public class MembershipController {

    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService){

        this.membershipService = membershipService;

    }

    @PostMapping
    public Membership createMembership(@RequestBody Membership membership){

        return membershipService.createMembership(membership);

    }

    @GetMapping("/{id}")
    public Membership getMembershipById(@PathVariable Integer id){

        return membershipService.getMembershipById(id);

    }
}
