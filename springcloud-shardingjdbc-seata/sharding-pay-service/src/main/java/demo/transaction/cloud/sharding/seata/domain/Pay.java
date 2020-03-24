package demo.transaction.cloud.sharding.seata.domain;

import lombok.Data;

@Data
public class Pay {

    private Long id;

    private Integer money;

    private Long userId;
}
