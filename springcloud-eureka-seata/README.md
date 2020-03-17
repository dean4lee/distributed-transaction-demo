## 服务结构
![](https://imgkr.cn-bj.ufileos.com/3dd00bdb-d8df-4f63-b6f0-54b197e40994.png)
支付服务：创建支付信息\
账户服务：查询账户余额，扣除账户余额\
订单服务：创建订单信息

## 运行seata.sql

## seata-server
1. 下载[seata-server](https://github.com/seata/seata/releases)
2. 修改conf/registry.conf，将registry.type修改为eureka。即将seata-server注册到eureka
```
registry {
  # file 、nacos 、eureka、redis、zk、consul、etcd3、sofa
  type = "eureka"

  eureka {
    serviceUrl = "http://localhost:8761/eureka"
    application = "seata-server"
    weight = "1"
  }
}
```
3. 启动eureka-server
4. 启动seata-server
```
./bin/seata-server.sh -p 8091
```

## 测试
1. 启动order-service, account-service, pay-service服务
2. curl http://localhost:8081/pay?money=30&userId=1 \
在每一服务中创建一个异常，任何一个服务出现异常后，所有的服务都会回滚

[seata官网](https://seata.io/)\
[seata参数配置](https://seata.io/zh-cn/docs/user/configurations.html)\
[seata官方示例](https://github.com/seata/seata-samples)



