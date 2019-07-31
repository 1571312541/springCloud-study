hystrix熔断器、服务降级使用，启动eureka服务7001、7002、7003

启动提供方服务zchao-springCloud-provider-dept-hystrix-8001

启动消费方 zchao-springCloud-consumer-feign-80 或者 zchao-springCloud-consumer-80

测试 http://localhost/dept_consumer/get/11 或者 http://localhost/dept/get/11

当参数为11时，返回fullback

否则返回正常