package demo.transaction.cloud.eureka.seata.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface OrderDAO {

    @Insert("insert into t_order(id, t_pay_id) values(#{id}, #{payId})")
    int insert(@Param("id") Long id, @Param("payId") Long payId);
}
