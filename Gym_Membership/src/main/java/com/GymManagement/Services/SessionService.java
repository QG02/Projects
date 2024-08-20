package com.GymManagement.Services;

import com.GymManagement.DTO.Session.Session;
import com.GymManagement.Repository.SessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions(){
        return sessionRepository.findAll();
    }

    public Session getSessionById(Integer id){
        return sessionRepository.findById(id).orElseThrow(() -> new RuntimeException("Session not found."));
    }

    @Transactional
    public Session createSession(Session session){
        return sessionRepository.save(session);
    }

    @Transactional
    public void deleteSession(Integer id){
        sessionRepository.deleteById(id);
    }

}
