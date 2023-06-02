package com.chenle.sortservice.openfeign;

import com.chenle.common.util.R;
import com.chenle.sortservice.openfeign.impl.CourserServiceFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "service-course",fallback = CourserServiceFeignFallback.class)
public interface CourseServiceFeign {
    @RequestMapping("course/courserdes/listbySort/{zoneId}")
    public R listbySort(@PathVariable("zoneId") Integer zoneId);
}
