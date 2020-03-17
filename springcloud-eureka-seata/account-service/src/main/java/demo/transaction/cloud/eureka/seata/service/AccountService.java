package demo.transaction.cloud.eureka.seata.service;

public interface AccountService {

    String deduction(Long userId, Integer money);
}
