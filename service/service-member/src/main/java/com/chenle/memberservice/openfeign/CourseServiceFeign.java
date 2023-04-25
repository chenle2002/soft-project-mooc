package com.chenle.memberservice.openfeign;

import com.chenle.memberservice.entity.CourserDesEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-course")
public interface CourseServiceFeign {

    @RequestMapping("course/courserdes/getone/{findgrandfather}")
    public CourserDesEntity getone(@PathVariable("findgrandfather") Integer findgrandfather);

    @RequestMapping("course/coursetree/findgrandfather/{courseId}")
    public Integer findgrandfather(@PathVariable("courseId") Integer courseId);
}
