package com.example.coffeeweb.Controller;

import com.example.coffeeweb.Entity.Order;
import com.example.coffeeweb.Pojo.GlobalApiResponse;
import com.example.coffeeweb.Pojo.OrderPojo;
import com.example.coffeeweb.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public GlobalApiResponse<Integer> saveData(@RequestBody OrderPojo orderPojo) {
        GlobalApiResponse<Integer> globalApiResponse = new GlobalApiResponse<>();
        Integer id = orderService.saveOrder(orderPojo);
        globalApiResponse.setData(id);
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Order saved successfully");
        return globalApiResponse;
    }
    @GetMapping
    public GlobalApiResponse <List<Order>> getOrders() {
        GlobalApiResponse<List<Order>> globalApiResponse = new GlobalApiResponse<>();
        globalApiResponse.setData(orderService.findAll());
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Orders retrieved successfully");
        return globalApiResponse;
    }
    @DeleteMapping("/delete/{id}")
    public GlobalApiResponse<Integer> deleteData(@PathVariable Integer id) {
        GlobalApiResponse<Integer> globalApiResponse = new GlobalApiResponse<>();
        orderService.deleteById(id);
        globalApiResponse.setData(null);
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Order deleted successfully");

        return globalApiResponse;
    }

    @GetMapping("{id}")
    public GlobalApiResponse<Order> findData(@PathVariable Integer id) {
        GlobalApiResponse<Order> globalApiResponse = new GlobalApiResponse<>();
        globalApiResponse.setData(orderService.findById(id));
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Order retrieved successfully");
        return globalApiResponse;
    }

}
