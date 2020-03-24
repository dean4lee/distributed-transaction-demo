package demo.transaction.cloud.sharding.seata.controller;

import demo.transaction.cloud.sharding.seata.domain.Pay;
import demo.transaction.cloud.sharding.seata.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
    @Autowired
    private PayService payService;

    @PostMapping("pay")
    public String pay(@RequestBody Pay pay) {
        return payService.pay(pay);
    }
}
