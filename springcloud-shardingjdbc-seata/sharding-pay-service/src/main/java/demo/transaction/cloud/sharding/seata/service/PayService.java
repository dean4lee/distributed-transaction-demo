package demo.transaction.cloud.sharding.seata.service;

import demo.transaction.cloud.sharding.seata.domain.Pay;

public interface PayService {

    String pay(Pay pay);
}
