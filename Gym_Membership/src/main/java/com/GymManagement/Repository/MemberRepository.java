package com.GymManagement.Repository;

import com.GymManagement.DTO.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//The jpa repository interface handles the information of mapped entities
//It pairs the mapped entity (in this case, a member object) with
//the type of primary key it depends on (in this case, an integer value)
public interface MemberRepository extends JpaRepository<Member, Integer> {
//CAN ADD CUSTOM QUERIES HERE WITH JPA NAMING CONVENTION
}
