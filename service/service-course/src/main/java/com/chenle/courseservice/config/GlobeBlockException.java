package com.chenle.courseservice.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class GlobeBlockException {
    public static String blockHandler(String name, BlockException e)
    {
        return "name:" + name + "~~被限流";
    }
}
