package demo.transaction.cloud.eureka.seata.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("order-service")
public interface OrderFeign {

    @GetMapping("addOrder")
    String addOrder(@RequestParam("payId") long payId);
}
