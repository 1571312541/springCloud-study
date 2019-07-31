DeptClientService ----  feign使用，RestTemplate对http请求进行了封装，feign在其基础上进一步封装，直接调用接口就可以实现，feign也可以实现负载均衡

DeptClientServiceFallbackFactory  --- 服务降级 -- 降级处理是在客户端实现完成的，和服务端没有关系，一般从整体负荷考虑，当某个服务熔断后，服务器将不再被调用，此时客户端可以给自己准备一个fallback回调，返回要给缺省值，这样虽然服务水平下级，但可以使用，不会挂掉


