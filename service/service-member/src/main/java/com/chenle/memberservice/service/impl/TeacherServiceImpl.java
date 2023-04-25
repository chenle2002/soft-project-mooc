package com.chenle.memberservice.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.Query;
import com.chenle.common.vo.TeacherInfoVo;
import com.chenle.memberservice.dao.TeacherDao;
import com.chenle.memberservice.entity.CourserDesEntity;
import com.chenle.memberservice.entity.TeacherEntity;
import com.chenle.memberservice.openfeign.CourseServiceFeign;
import com.chenle.memberservice.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, TeacherEntity> implements TeacherService {

    @Autowired
    CourseServiceFeign courseServiceFeign;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TeacherEntity> page = this.page(
                new Query<TeacherEntity>().getPage(params),
                new QueryWrapper<TeacherEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public TeacherInfoVo getTeacherInfo(Integer courseId) {
        System.out.println(courseId);
        Integer findgrandfather = courseServiceFeign.findgrandfather(courseId);
        CourserDesEntity course_id = courseServiceFeign.getone(findgrandfather);
        Integer teacherId = course_id.getTeacherId();
        TeacherEntity teacher = this.getOne(new QueryWrapper<TeacherEntity>().eq("teacher_id", teacherId));

        TeacherInfoVo teacherInfoVo = new TeacherInfoVo();
        teacherInfoVo.setId(teacher.getTeacherId());
        teacherInfoVo.setLecturerName(teacher.getName());
        teacherInfoVo.setLecturerMobile("18313876850");
        teacherInfoVo.setLecturerPosition("陈远豪推荐，你值得相信！");
        teacherInfoVo.setLecturerHead("https://file.roncoos.com/education/education/765d471f0e314f64a7d35fc0b39295e0.png");
        teacherInfoVo.setIntroduce("<p>  " + teacher.getDescription() + "</p>");
        return teacherInfoVo;
    }

}
