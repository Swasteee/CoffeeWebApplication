package com.example.coffeeweb.Controller;

import com.example.coffeeweb.Entity.Payment;
import com.example.coffeeweb.Pojo.GlobalApiResponse;
import com.example.coffeeweb.Pojo.PaymentPojo;
import com.example.coffeeweb.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public GlobalApiResponse<Integer> saveData(@RequestBody PaymentPojo paymentPojo){
        GlobalApiResponse<Integer> globalApiResponse = new GlobalApiResponse<>();
        Integer id = paymentService.savePayment(paymentPojo);
        globalApiResponse.setData(id);
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Payment saved successfully");
        return globalApiResponse;
    }
    @GetMapping
    public GlobalApiResponse <List<Payment>> getAll(){
        GlobalApiResponse<List<Payment>> globalApiResponse = new GlobalApiResponse<>();
        globalApiResponse.setData(paymentService.findAll());
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Data retrieved successfully");
        return globalApiResponse;
    }
    @DeleteMapping("/delete/{id}")
    public GlobalApiResponse<Integer> deleteData(@PathVariable Integer id) {
        GlobalApiResponse<Integer> globalApiResponse = new GlobalApiResponse<>();
        paymentService.deleteById(id);
        globalApiResponse.setData(null);
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Payment deleted successfully");
        return globalApiResponse;
    }

    @GetMapping("/getById{id}")
    public GlobalApiResponse<Payment> findData(@PathVariable Integer id) {
        GlobalApiResponse<Payment> globalApiResponse = new GlobalApiResponse<>();
        globalApiResponse.setData(paymentService.findById(id));
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Payment retrieved successfully");

        return globalApiResponse;}
}
