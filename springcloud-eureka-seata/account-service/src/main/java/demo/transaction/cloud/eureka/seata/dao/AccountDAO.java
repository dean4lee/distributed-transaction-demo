package demo.transaction.cloud.eureka.seata.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountDAO {

    @Select("select money from t_account where user_id = #{userId}")
    int selectMoneyByUserId(@Param("userId") Long userId);

    @Update("update t_account set money = #{money} where user_id = #{userId}")
    int updateByUserId(@Param("userId") Long userId, @Param("money") int money);
}
