package demo.transaction.cloud.eureka.seata.service;

public interface PayService {

    String addPay(Long userId, Integer money);
}
