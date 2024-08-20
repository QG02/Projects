package com.GymManagement.Controller;

import com.GymManagement.DTO.Payment.Payment;
import com.GymManagement.Services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){

        this.paymentService = paymentService;

    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment){

        return paymentService.createPayment(payment);

    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Integer id){

        return paymentService.getPaymentById(id);

    }

}
