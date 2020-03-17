package demo.transaction.cloud.eureka.seata.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface PayDAO {

    @Insert("insert into t_pay(id, user_id, money) values(#{id}, #{userId}, #{money})")
    int insert(@Param("id") Long id, @Param("userId") Long userId, @Param("money") Integer money);
}
