package demo.transaction.cloud.sharding.seata.service;

import demo.transaction.cloud.sharding.seata.domain.Order;

public interface OrderService {

    String addOrder(Order order);
}
