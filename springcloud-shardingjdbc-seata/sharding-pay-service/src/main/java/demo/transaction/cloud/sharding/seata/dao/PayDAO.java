package demo.transaction.cloud.sharding.seata.dao;

import demo.transaction.cloud.sharding.seata.domain.Pay;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface PayDAO {

    @Insert("insert into t_pay(money, user_id) values(#{money}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Pay pay);
}
