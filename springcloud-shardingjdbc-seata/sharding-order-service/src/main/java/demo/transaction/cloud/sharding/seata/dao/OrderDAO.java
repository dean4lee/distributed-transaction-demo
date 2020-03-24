package demo.transaction.cloud.sharding.seata.dao;

import demo.transaction.cloud.sharding.seata.domain.Order;
import org.apache.ibatis.annotations.Insert;

public interface OrderDAO {

    @Insert("insert into t_order(t_pay_id, user_id) values(#{tPayId}, #{userId})")
    int insert(Order order);
}
