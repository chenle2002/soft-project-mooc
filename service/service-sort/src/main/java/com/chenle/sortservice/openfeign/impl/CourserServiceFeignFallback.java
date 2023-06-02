package com.chenle.sortservice.openfeign.impl;

import com.chenle.common.util.R;
import com.chenle.sortservice.entity.CourserDesEntity;
import com.chenle.sortservice.openfeign.CourseServiceFeign;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author 陈乐
 * @Date 2023/5/31 14:09
 * @Version 1.0
 */
@Component
public class CourserServiceFeignFallback implements CourseServiceFeign {
    @Override
    public R listbySort(Integer zoneId) {
        return R.error(250,"下游服务发生熔断，下游服务（课程服务）暂不可用，请稍后再试！");
    }
}
