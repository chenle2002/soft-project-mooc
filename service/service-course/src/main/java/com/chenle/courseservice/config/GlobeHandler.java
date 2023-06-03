package com.chenle.courseservice.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chenle.common.util.R;

/**
 * @Author 陈乐
 * @Date 2023/5/31 15:22
 * @Version 1.0
 */
public class GlobeHandler {
    public static R listbySortHandler(Throwable e){
        return R.error(300,"获取分类的请求过于频繁，请稍后再试！");
    }
    public static R listWithTree(){
        return R.error(300,"获取课程树的请求过于频繁，请稍后再试！");
    }
}
