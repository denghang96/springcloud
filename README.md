# springcloud
#### 1.cloud-api-commons 包含了各个子模块用到的统一的entity，接口等
#### 2.eureka单机版 cloud-consumer-order80 + cloud-provider-pament8001 + cloud-eureka-server7001 7001为服务注册中心，不包含任何业务代码
#### 3.eureka注册中心集群 cloud-consumer-order80 + cloud-provider-pament8001  + cloud-eureka-server7001  + cloud-eureka-server7002
#### 4.eureka注册中心集群+服务提供者集群 cloud-consumer-order80 + cloud-provider-pament8001 + cloud-provider-pament8002  + cloud-eureka-server7001  + cloud-eureka-server7002，8001和8002用同样的servicename注册进eureka,80通过服务名称调用以达到负载的目的
#### 5.zookeeper注册中心集群 cloud-consumerzk-order80 + cloud-provider-pament8004
#### 6.consul单机版 cloud-consumerconsul-order80 + cloud-providerconsul-pament8006
#### 7.openFeign cloud-consumer-feign-order80 + cloud-provider-pament8001 + cloud-provider-pament8002 + cloud-eureka-server7001 + cloud-eureka-server7002
#### 8.openFeign+zookeeper cloud-consumer-feign-zk-order80 + cloud-provider-pament8004 
#### 9.Hystrix服务治理cloud-provider-hystrix-pament8001 + cloud-consumer-feign-hystrix-order80 降级、熔断、限流
#### 10.cloud-consumer-hystrix-dashborad9001 + cloud-provider-hystrix-pament8001 dashborad9001监控pament8001
#### 11.cloud-gateway-gateway9527做网关 ， cloud-eureka-server7001 + cloud-eureka-server7002 做注册中心集群，cloud-provider-pament8001做服务提供者
#### 12.cloud-config-center-3344做配置中心，cloud-config-client-3355和cloud-config-client-3366为需要加载公共配置的微服务，cloud-eureka-server7001的单机版做注册中心，SpringCloud Config + SpringCloud Bus
#### 13.loud-stream-rabbitmq-provider8801 + loud-stream-rabbitmq-provider8802 + loud-stream-rabbitmq-provider8803 + cloud-eureka-server7001
#### 14.本机nacos server + cloudalibaba-provider-payment9001 + cloudalibaba-provider-payment9002 + cloudalibaba-consumer-nacos-order83 nacos做服务注册中心以及负载均衡