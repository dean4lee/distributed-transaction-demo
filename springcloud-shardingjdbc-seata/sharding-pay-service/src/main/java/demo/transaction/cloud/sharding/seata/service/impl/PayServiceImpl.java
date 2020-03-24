package demo.transaction.cloud.sharding.seata.service.impl;

import demo.transaction.cloud.sharding.seata.dao.PayDAO;
import demo.transaction.cloud.sharding.seata.domain.Order;
import demo.transaction.cloud.sharding.seata.domain.Pay;
import demo.transaction.cloud.sharding.seata.feign.OrderFeign;
import demo.transaction.cloud.sharding.seata.service.PayService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayDAO payDAO;
    @Autowired
    private OrderFeign orderFeign;

    @GlobalTransactional
    @Override
    public String pay(Pay pay){
        TransactionTypeHolder.set(TransactionType.BASE);
        payDAO.insert(pay);

        Order order = new Order();
        order.setTPayId(pay.getId());
        order.setUserId(pay.getUserId());
        orderFeign.addOrder(order);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 1/0;
        return "success";
    }
}
