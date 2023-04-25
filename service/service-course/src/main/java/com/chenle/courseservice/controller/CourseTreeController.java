package com.chenle.courseservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.common.vo.CourseVo;
import com.chenle.courseservice.entity.CourseTreeEntity;

import com.chenle.courseservice.entity.CourserDesEntity;
import com.chenle.courseservice.service.CourseTreeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-11-22 16:14:53
 */
@Slf4j
@RestController
@RequestMapping("course/coursetree")
public class CourseTreeController {
    @Autowired
    private CourseTreeService courseTreeService;


    @RequestMapping("/findgrandfather/{courseId}")
    public Integer findgrandfather(@PathVariable("courseId") Integer courseId){
        return courseTreeService.findgrandfather(courseId);
    }


    /**
     * 列表
     */
    @RequestMapping("/list/lingketree")
    public R listLingKe(){
        log.info(String.valueOf(123));
        List<CourseVo> entityList =  courseTreeService.lislingketree();
        return R.ok().put("page", entityList);
    }
    /**
     * 单独需要的课程
     */
    @RequestMapping("/list/course")
    public R listCourse(@RequestParam Integer getId){
//        log.info(String.valueOf(123));
        List<CourseTreeEntity> entityList =  courseTreeService.listCourse(getId);
        return R.ok().put("page", entityList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list/tree")
    public R listWithTree(@RequestParam Map<String, Object> params){
        log.info(String.valueOf(123));
        List<CourseTreeEntity> entityList =  courseTreeService.listWithTree();
        return R.ok().put("page", entityList);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseTreeService.queryPage(params);

        return R.ok().put("page", page);
    }
    @RequestMapping("/list/grandfather")
    public R listgrandfather(@RequestParam Map<String, Object> params){
        PageUtils page = courseTreeService.listgrandfather(params);

        return R.ok().put("page", page);
    }
    @RequestMapping("/list/grandson")
    public R grandson(@RequestParam Map<String, Object> params){
        PageUtils page = courseTreeService.listgrandson(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{courseId}")
    public R info(@PathVariable("courseId") Integer courseId){
        CourseTreeEntity courseTree = courseTreeService.getById(courseId);

        return R.ok().put("courseTree", courseTree);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CourseTreeEntity courseTree){
        courseTreeService.save(courseTree);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CourseTreeEntity courseTree){
        courseTreeService.updateById(courseTree);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] courseIds){
        courseTreeService.removeByIds(Arrays.asList(courseIds));

        return R.ok();
    }

}
