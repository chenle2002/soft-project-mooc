package com.chenle.courseservice.openfeign;

import com.chenle.common.entity.TeacherEntity;
import com.chenle.common.entity.UserEntity;
import com.chenle.common.vo.TeacherInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-member")
public interface MemberServiceFeign {
    @RequestMapping("member/user/getone/{id}")
    public UserEntity getone(@PathVariable("id") Integer id);

    @RequestMapping("member/teacher/getone/{id}")
    public TeacherEntity getoneTeacher(@PathVariable("id") Integer id);

    @RequestMapping("member/teacher/getteacherinfo/{courseId}")
    public TeacherInfoVo getteacherinfo(@PathVariable("courseId") Integer courseId);
}
