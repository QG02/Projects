package com.GymManagement;

import com.GymManagement.DTO.Payment.Payment;
import com.GymManagement.Repository.PaymentRepository;
import com.GymManagement.Services.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PaymentTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private PaymentRepository paymentRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPaymentById(){

        Payment mockPayment = new Payment();
        mockPayment.setPaymentId(1);

        when(paymentRepository.findById(1)).thenReturn(Optional.of(mockPayment));

        Payment payment = paymentService.getPaymentById(1);
        assertNotNull(payment);
        assertEquals(1,payment.getPaymentId());

        verify(paymentRepository, times(1)).findById(1);
    }

}

