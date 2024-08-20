package com.GymManagement.Services;

import com.GymManagement.DTO.Payment.Payment;
import com.GymManagement.Repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Integer id){
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found."));
    }

    @Transactional
    public Payment createPayment(Payment payment){
        return paymentRepository.save(payment);
    }

    @Transactional
    public void deletePayment(Integer id){
        paymentRepository.deleteById(id);
    }

}
