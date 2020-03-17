package demo.transaction.cloud.eureka.seata.service.impl;

import demo.transaction.cloud.eureka.seata.dao.PayDAO;
import demo.transaction.cloud.eureka.seata.feign.AccountFeign;
import demo.transaction.cloud.eureka.seata.feign.OrderFeign;
import demo.transaction.cloud.eureka.seata.service.PayService;
import demo.transaction.cloud.eureka.seata.util.SnowFlake;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayDAO payDAO;
    @Autowired
    private SnowFlake snowFlake;
    @Autowired
    private AccountFeign accountFeign;
    @Autowired
    private OrderFeign orderFeign;

    @GlobalTransactional
    @Override
    public String addPay(Long userId, Integer money) {
        //添加支付信息
        long payId = snowFlake.nextKey();
        payDAO.insert(payId, userId, money);
        //扣除账号金额
        accountFeign.deduction(userId, money);
        //创建订单
        orderFeign.addOrder(payId);
        //模拟异常
//        int a = 1/0;
        return "success";
    }
}
