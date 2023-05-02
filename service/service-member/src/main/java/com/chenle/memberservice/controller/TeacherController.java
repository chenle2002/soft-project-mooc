package com.chenle.memberservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.common.vo.TeacherInfoVo;
import com.chenle.memberservice.entity.TeacherEntity;
import com.chenle.memberservice.entity.UserEntity;
import com.chenle.memberservice.service.TeacherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name="人员管理")
@RestController
@RequestMapping("member/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;



    @Operation(summary ="根据教师Id获取一个教师实体类")
    @Parameters({
            @Parameter(name = "id",required = true,description = "教师Id")
    })
    @ApiResponse(description = "返回教师实体类", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = TeacherEntity.class)))
    @RequestMapping(value = "/getone/{id}", method= {RequestMethod.GET, RequestMethod.POST})
    public TeacherEntity getone(@PathVariable("id") Integer id){
        return teacherService.getOne(new QueryWrapper<TeacherEntity>().eq("teacher_id", id));
    }


    @Operation(summary ="根据课程Id获取教授该课程的教师信息")
    @Parameters({
            @Parameter(name = "courseId",required = true,description = "课程Id")
    })
    @ApiResponse(description = "返回教师信息并封装为TeacherInfoVo", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = TeacherInfoVo.class)))
    @RequestMapping(value = "/getteacherinfo/{courseId}", method= {RequestMethod.GET, RequestMethod.POST})
    public TeacherInfoVo getteacherinfo(@PathVariable("courseId") Integer courseId){
        return teacherService.getTeacherInfo(courseId);
    }




    @Operation(summary ="根据课程Id获取教授该课程的教师信息")
    @Parameters({
            @Parameter(name = "courseId",required = true,description = "课程Id")
    })
    @ApiResponse(description = "返回教师信息并封装为R", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/getinfo", method= {RequestMethod.GET, RequestMethod.POST})
    public R getTeacherInfo(@RequestParam Integer courseId){
        TeacherInfoVo data = teacherService.getTeacherInfo(courseId);

        return R.ok().put("data", data);
    }


    /**
     * 列表
     */
    @Operation(summary ="获取所有教师信息")
    @ApiResponse(description = "返回教师信息并封装为R", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/list", method= {RequestMethod.GET, RequestMethod.POST})
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = teacherService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @Operation(summary ="获取单个教师信息")
    @Parameters({
            @Parameter(name = "teacherId",required = true,description = "教师Id")
    })
    @ApiResponse(description = "返回教师信息并封装为R", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/info/{teacherId}", method= {RequestMethod.GET, RequestMethod.POST})
    public R info(@PathVariable("teacherId") Integer teacherId){
		TeacherEntity teacher = teacherService.getById(teacherId);

        return R.ok().put("teacher", teacher);
    }

    /**
     * 保存
     */
    @Operation(summary ="保存教师信息")
    @Parameters({
            @Parameter(name = "teacher",required = true,description = "教师实体类")
    })
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/save", method= {RequestMethod.GET, RequestMethod.POST})
    public R save(@RequestBody TeacherEntity teacher){
		teacherService.save(teacher);

        return R.ok();
    }

    /**
     * 修改
     */
    @Operation(summary ="修改教师信息")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/update", method= {RequestMethod.GET, RequestMethod.POST})
    public R update(@RequestBody TeacherEntity teacher){
		teacherService.updateById(teacher);

        return R.ok();
    }

    /**
     * 删除
     */
    @Operation(summary ="删除教师信息")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/delete", method= {RequestMethod.GET, RequestMethod.POST})
    public R delete(@RequestBody Integer[] teacherIds){
		teacherService.removeByIds(Arrays.asList(teacherIds));

        return R.ok();
    }

}
