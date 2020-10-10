# springcloud
####1.cloud-api-commons 包含了各个子模块用到的统一的entity，接口等
####2.eureka单机版 cloud-consumer-order80 + cloud-provider-pament8001 + cloud-eureka-server7001 7001为服务注册中心，不包含任何业务代码
####3.eureka注册中心集群 cloud-consumer-order80 + cloud-provider-pament8001  + cloud-eureka-server7001  + cloud-eureka-server7002
####4.eureka注册中心集群+服务提供者集群 cloud-consumer-order80 + cloud-provider-pament8001 + cloud-provider-pament8002  + cloud-eureka-server7001  + cloud-eureka-server7002，8001和8002用同样的servicename注册进eureka,80通过服务名称调用以达到负载的目的
####5.zookeeper注册中心集群 cloud-consumerzk-order80 + cloud-provider-pament8004
####6.consul单机版 cloud-consumerconsul-order80 + cloud-providerconsul-pament8006
####7.openFeign cloud-consumer-feign-order80 + cloud-provider-pament8001 + cloud-provider-pament8002 + cloud-eureka-server7001 + cloud-eureka-server7002
####8.openFeign+zookeeper cloud-consumer-feign-zk-order80 + cloud-provider-pament8004 