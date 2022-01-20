package com.xj.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static String handlerException(BlockException e){
        return "error 400 " + e.getMessage();
    }
}
