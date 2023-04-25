package com.chenle.courseservice.openfeign;

import com.chenle.courseservice.entity.SortEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-sort")
public interface SortServiceFeign {
    @RequestMapping("sort/getone/{sortId}")
    public SortEntity getone(@PathVariable("sortId") Integer sortId);
}
