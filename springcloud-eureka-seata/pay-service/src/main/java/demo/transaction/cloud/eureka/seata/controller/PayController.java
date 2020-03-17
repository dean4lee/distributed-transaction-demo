package demo.transaction.cloud.eureka.seata.controller;

import demo.transaction.cloud.eureka.seata.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {

    @Autowired
    private PayService payService;

    @GetMapping("pay")
    public String pay(@RequestParam("userId") Long userId, @RequestParam("money") Integer money){
        return payService.addPay(userId, money);
    }

}
