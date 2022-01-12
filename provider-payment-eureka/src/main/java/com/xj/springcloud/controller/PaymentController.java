package com.xj.springcloud.controller;

import com.xj.springcloud.entity.Payment;
import com.xj.springcloud.service.PaymentService;
import com.xj.springcloud.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("payment")
@Api(tags = "ttt")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("savePayment")
    @ApiOperation(value = "保存")
    public CommonResult<Integer> savePayment(@RequestBody Payment payment) {
        log.info("服务8081");
        Integer result = paymentService.savePayment(payment);
        if (result > 0) {
            return new CommonResult<Integer>(200,"保存成功"+serverPort,result);
        } else {
            return new CommonResult<Integer>(400,"保存失败"+serverPort,result);
        }
    }

    @GetMapping("getPaymentById")
    @ApiOperation(value = "获取")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",dataType = "string",name = "id",value = "id",required = true)
    })
    public CommonResult<Payment> getPaymentById(@RequestParam("id") String id) {
        log.info("服务8081");
        Payment paymentById = paymentService.getPaymentById(id);
        if (!ObjectUtils.isEmpty(paymentById)) {
            return new CommonResult<Payment>(200, "查询成功"+serverPort, paymentById);
        } else {
            return new CommonResult<Payment>(400, "查询失败"+serverPort, null);
        }
    }

    @GetMapping("discovery")
    @ApiOperation(value = "服务发现")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("timeOut")
    public String timeOut(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    /**
     * 链路跟踪
     * @return
     */
    @GetMapping("zipkin")
    public String zipkin(){
        return "zipkin + port:" + serverPort;
    }
}
