package com.edu.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/17 21:58
 */
public class CustomerBlockHandler {

    public static String handExeption(BlockException exception){
        return "由于lombak的问题，这里用String，handExeption.客户自定义的4444";
    }

    public static String handExeption2(BlockException exception){
        return "由于lombak的问题，这里用String，handExeption2.客户自定义的4444  2号";
    }
}
