## 服务结构
![](https://imgkr.cn-bj.ufileos.com/5644e28e-ccd8-4a4b-9672-bc169d701a7a.png)
支付服务：创建支付信息\
订单服务：创建订单信息

## 运行sharding-seata.sql

## seata-server
1. 下载[seata-server](https://github.com/seata/seata/releases)
2. 启动seata-server
```
./bin/seata-server.sh -p 8091
```

## 测试
1. 启动order-service, pay-service服务
2. curl -X POST -d '{"money":10, "userId":1}' http://localhost:8080/pay
任何一个服务出现异常后，所有的服务都会回滚

[seata官网](https://seata.io/)\
[seata参数配置](https://seata.io/zh-cn/docs/user/configurations.html)\
[seata官方示例](https://github.com/seata/seata-samples)



