package com.GymManagement;

import com.GymManagement.DTO.Session.Session;
import com.GymManagement.Repository.SessionRepository;
import com.GymManagement.Services.SessionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SessionTest {

    @InjectMocks
    private SessionService sessionService;

    @Mock
    private SessionRepository sessionRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetSessionById(){

        Session mockSession = new Session();
        mockSession.setSessionId(1);

        when(sessionRepository.findById(1)).thenReturn(Optional.of(mockSession));

        Session session = sessionService.getSessionById(1);
        assertNotNull(session);
        assertEquals(1, session.getSessionId());

        verify(sessionRepository, times(1));
    }
}

