package com.chenle.courseservice.openfeign;

import com.chenle.common.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-oss")
public interface OssServiceFeign {

    @RequestMapping("oss/courserdes/pdf/policy")
    public R pdfpolicy();

    @RequestMapping("oss/courserdes/image/policy")
    public R imagepolicy();

    @RequestMapping("oss/courserdes/video/policy")
    public R videopolicy();
}
