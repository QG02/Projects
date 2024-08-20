package com.GymManagement.Controller;

import com.GymManagement.DTO.Session.Session;
import com.GymManagement.Services.SessionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService){

        this.sessionService = sessionService;

    }

    @PostMapping
    public Session createSession(@RequestBody Session session){

        return sessionService.createSession(session);

    }

    @GetMapping("/{id}")
    public  Session getSessionById(@PathVariable Integer id){

        return sessionService.getSessionById(id);

    }
}