package demo.transaction.cloud.eureka.seata.config;

import demo.transaction.cloud.eureka.seata.util.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    @Bean
    public SnowFlake snowFlake(){
        return new SnowFlake(1);
    }
}
