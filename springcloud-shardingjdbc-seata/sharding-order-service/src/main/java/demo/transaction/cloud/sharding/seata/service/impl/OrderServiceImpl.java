package demo.transaction.cloud.sharding.seata.service.impl;

import demo.transaction.cloud.sharding.seata.dao.OrderDAO;
import demo.transaction.cloud.sharding.seata.domain.Order;
import demo.transaction.cloud.sharding.seata.service.OrderService;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Override
    public String addOrder(Order order) {
        TransactionTypeHolder.set(TransactionType.BASE);
        orderDAO.insert(order);
        return "success";
    }
}
