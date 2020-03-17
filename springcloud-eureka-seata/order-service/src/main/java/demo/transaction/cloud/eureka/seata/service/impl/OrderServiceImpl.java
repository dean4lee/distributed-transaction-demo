package demo.transaction.cloud.eureka.seata.service.impl;

import demo.transaction.cloud.eureka.seata.dao.OrderDAO;
import demo.transaction.cloud.eureka.seata.service.OrderService;
import demo.transaction.cloud.eureka.seata.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private SnowFlake snowFlake;

    @Override
    public String add(Long payId){
        orderDAO.insert(snowFlake.nextKey(), payId);
        //模拟异常
//        int a = 1/0;
        return "success";
    }

}
