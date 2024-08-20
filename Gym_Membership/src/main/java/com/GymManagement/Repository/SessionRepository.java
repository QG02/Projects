package com.GymManagement.Repository;

import com.GymManagement.DTO.Session.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//The jpa repository interface handles the information of mapped entities
//It pairs the mapped entity (in this case, a session object) with
//the type of primary key it depends on (in this case, an integer value)
public interface SessionRepository extends JpaRepository<Session, Integer> {
//CAN ADD CUSTOM QUERIES HERE WITH JPA NAMING CONVENTION
}

