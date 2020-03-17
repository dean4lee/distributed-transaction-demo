package demo.transaction.cloud.eureka.seata.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("account-service")
public interface AccountFeign {

    @GetMapping("deduction")
    String deduction(@RequestParam("userId") Long userId, @RequestParam("money") Integer money);
}
