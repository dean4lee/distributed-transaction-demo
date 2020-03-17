package demo.transaction.cloud.eureka.seata.service.impl;


import demo.transaction.cloud.eureka.seata.dao.AccountDAO;
import demo.transaction.cloud.eureka.seata.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDAO accountDAO;

    @Override
    public String deduction(Long userId, Integer money) {
        int haveMoney = accountDAO.selectMoneyByUserId(userId);
        if(haveMoney < money){
            throw new RuntimeException("金额不足");
        }
        accountDAO.updateByUserId(userId, haveMoney - money);
        return "success";
    }
}
