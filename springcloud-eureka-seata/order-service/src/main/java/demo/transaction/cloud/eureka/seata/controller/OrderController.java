package demo.transaction.cloud.eureka.seata.controller;

import demo.transaction.cloud.eureka.seata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("addOrder")
    public String addOrder(@RequestParam("payId") Long payId){
        return orderService.add(payId);
    }

}
