package com.chenle.memberservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.common.vo.TeacherInfoVo;
import com.chenle.memberservice.entity.TeacherEntity;
import com.chenle.memberservice.entity.UserEntity;
import com.chenle.memberservice.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-11-22 16:14:53
 */
@RestController
@RequestMapping("member/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/getone/{id}")
    public TeacherEntity getone(@PathVariable("id") Integer id){
        return teacherService.getOne(new QueryWrapper<TeacherEntity>().eq("teacher_id", id));
    }

    @RequestMapping("/getteacherinfo/{courseId}")
    public TeacherInfoVo getteacherinfo(@PathVariable("courseId") Integer courseId){
        return teacherService.getTeacherInfo(courseId);
    }



    @RequestMapping("/getinfo")
    public R getTeacherInfo(@RequestParam Integer courseId){
        TeacherInfoVo data = teacherService.getTeacherInfo(courseId);

        return R.ok().put("data", data);
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = teacherService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{teacherId}")
    public R info(@PathVariable("teacherId") Integer teacherId){
		TeacherEntity teacher = teacherService.getById(teacherId);

        return R.ok().put("teacher", teacher);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TeacherEntity teacher){
		teacherService.save(teacher);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TeacherEntity teacher){
		teacherService.updateById(teacher);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] teacherIds){
		teacherService.removeByIds(Arrays.asList(teacherIds));

        return R.ok();
    }

}
