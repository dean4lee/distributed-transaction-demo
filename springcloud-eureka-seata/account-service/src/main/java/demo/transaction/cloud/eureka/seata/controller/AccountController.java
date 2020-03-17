package demo.transaction.cloud.eureka.seata.controller;

import demo.transaction.cloud.eureka.seata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("deduction")
    public String deduction(Long userId, Integer money){
        return accountService.deduction(userId, money);
    }
}
