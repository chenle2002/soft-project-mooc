package com.chenle.sortservice.openfeign;

import com.chenle.sortservice.entity.CourserDesEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("service-course")
public interface CourseServiceFeign {
    @RequestMapping("course/courserdes/listbySort/{zoneId}")
    public List<CourserDesEntity> listbySort(@PathVariable("zoneId") Integer zoneId);
}
