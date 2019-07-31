feign使用，RestTemplate对http请求进行了封装，feign在其基础上进一步封装，直接调用接口就可以实现，feign也可以实现负载均衡

启动eureka服务7001、7002、7003

启动提供方服务zchao-springCloud-provider-dept-8001、zchao-springCloud-provider-dept-8002、zchao-springCloud-provider-dept-8003

启动消费方 zchao-springCloud-consumer-feign-80 

测试 http://localhost/dept_consumer/get/1

成功则返回