package com.xj.springcloud.controller;

import com.xj.springcloud.entity.Payment;
import com.xj.springcloud.service.Payment1Service;
import com.xj.springcloud.utils.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("payment")
@Api(tags = "ttt")
@Slf4j
public class Payment1Controller {
    @Resource
    private Payment1Service payment1Service;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("savePayment")
    @ApiOperation(value = "保存")
    public CommonResult<Integer> savePayment(@RequestBody Payment payment) {
        log.info("服务8082");
        Integer result = payment1Service.savePayment(payment);
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
        log.info("服务8082");
        Payment paymentById = payment1Service.getPaymentById(id);
        if (!ObjectUtils.isEmpty(paymentById)) {
            return new CommonResult<Payment>(200, "查询成功"+serverPort, paymentById);
        } else {
            return new CommonResult<Payment>(400, "查询失败"+serverPort, null);
        }
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
}
