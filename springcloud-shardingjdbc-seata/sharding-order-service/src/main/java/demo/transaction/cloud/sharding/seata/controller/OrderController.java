package demo.transaction.cloud.sharding.seata.controller;

import demo.transaction.cloud.sharding.seata.domain.Order;
import demo.transaction.cloud.sharding.seata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("addOrder")
    public String addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }
}
