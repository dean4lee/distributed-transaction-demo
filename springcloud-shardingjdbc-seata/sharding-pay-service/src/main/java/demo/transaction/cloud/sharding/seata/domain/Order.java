package demo.transaction.cloud.sharding.seata.domain;

import lombok.Data;

@Data
public class Order {

    private Long id;

    private Long tPayId;

    private Long userId;
}
