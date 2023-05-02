package com.chenle.courseservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenle.common.entity.UserEntity;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.common.vo.CourseDesResVo;
import com.chenle.common.vo.CourseDesVo;
import com.chenle.courseservice.entity.CourserDesEntity;
import com.chenle.courseservice.openfeign.OssServiceFeign;

import com.chenle.courseservice.service.CourserDesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-11-25 09:34:22
 */
@Slf4j
@Tag(name = "课程章节信息管理")
@RestController
@RequestMapping("course/courserdes")
public class CourserDesController {

    @Autowired
    private CourserDesService courserDesService;
    @Autowired
    OssServiceFeign ossServiceFeign;

    @Operation(summary ="获取该章节的父级结构")
    @Parameters({
            @Parameter(name = "findgrandfather",required = true,description = "课程章节Id"),
    })
    @ApiResponse(description = "返回该章节的父级结构并封装为CourserDesEntity", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = CourserDesEntity.class)))
    @RequestMapping(value = "/getone/{findgrandfather}", method= {RequestMethod.GET, RequestMethod.POST})
    public CourserDesEntity getone(@PathVariable("findgrandfather") Integer findgrandfather){
        return courserDesService.getOne(new QueryWrapper<CourserDesEntity>().eq("course_id", findgrandfather));
    }


    @Operation(summary ="获取该分类的所有课程信息")
    @Parameters({
            @Parameter(name = "zoneId",required = true,description = "分类Id"),
    })
    @ApiResponse(description = "返回该分类的所有课程信息并封装为List<CourserDesEntity>", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = List.class)))
    @RequestMapping(value = "/listbySort/{zoneId}", method= {RequestMethod.GET, RequestMethod.POST})
    public List<CourserDesEntity> listbySort(@PathVariable("zoneId") Integer zoneId){
        return courserDesService.listbySort(zoneId);
    }



    @Operation(summary ="获取pdf的加密信息")
    @ApiResponse(description = "返回加密信息并封装为R", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/pdf/policy", method= {RequestMethod.GET, RequestMethod.POST})
    public R pdfpolicy() {
        return ossServiceFeign.pdfpolicy();
    }


    @Operation(summary ="获取image的加密信息")
    @ApiResponse(description = "返回加密信息并封装为R", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/image/policy", method= {RequestMethod.GET, RequestMethod.POST})
    public R imagepolicy() {
        return ossServiceFeign.imagepolicy();
    }


    @Operation(summary ="获取video的加密信息")
    @ApiResponse(description = "返回加密信息并封装为R", content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/video/policy", method= {RequestMethod.GET, RequestMethod.POST})
    public R videopolicy() {
        return ossServiceFeign.videopolicy();
    }

    /**
     * 列表
     */
    @Operation(summary ="获取所有课程章节信息")
    @ApiResponse(description = "返回课程章节信息并封装为R", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/list", method= {RequestMethod.GET, RequestMethod.POST})
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = courserDesService.queryPage(params);

        return R.ok().put("page", page);
    }


    @Operation(summary ="根据名称或其他参数获取课程详细信息")
    @ApiResponse(description = "课程详细信息封装为List<CourseDesResVo>", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = List.class)))
    @RequestMapping(value = "/listname", method= {RequestMethod.GET, RequestMethod.POST})
    public R listWithName(@RequestParam Map<String, Object> params) {
        List<CourseDesResVo> page = courserDesService.listWithName(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @Operation(summary ="获取单个课程章节信息")
    @Parameters({
            @Parameter(name = "id",required = true,description = "课程章节Id")
    })
    @ApiResponse(description = "返回课程章节信息并封装为R", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/info/{id}", method= {RequestMethod.GET, RequestMethod.POST})
    public R info(@PathVariable("id") Integer id) {
        CourserDesEntity courserDes = courserDesService.getById(id);

        return R.ok().put("courserDes", courserDes);
    }


    @Operation(summary ="根据课程Id获取课程信息")
    @Parameters({
            @Parameter(name = "courseId",required = true,description = "课程Id"),
    })
    @ApiResponse(description = "根据课程Id获取课程信息并封装为CourseDesVo", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = CourseDesVo.class)))
    @RequestMapping(value = "/info/des", method= {RequestMethod.GET, RequestMethod.POST})
    public R getdes(@RequestParam Integer courseId) {
        CourseDesVo data = courserDesService.getdesByID(courseId);

        return R.ok().put("data", data);
    }
    /**
     * 保存
     */
    @Operation(summary ="保存课程章节信息")
    @Parameters({
            @Parameter(name = "courserDes",required = true,description = "课程章节实体类")
    })
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/save", method= {RequestMethod.GET, RequestMethod.POST})
    public R save(@RequestBody CourserDesEntity courserDes) {
        courserDesService.saveall(courserDes);

        return R.ok();
    }

    /**
     * 修改
     */
    @Operation(summary ="修改课程章节信息")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/update", method= {RequestMethod.GET, RequestMethod.POST})
    public R update(@RequestBody CourserDesEntity courserDes) {
        courserDesService.updateByIdWithTree(courserDes);

        return R.ok();
    }

    /**
     * 删除
     */
    @Operation(summary ="删除课程章节信息")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/delete", method= {RequestMethod.GET, RequestMethod.POST})
    public R delete(@RequestBody Integer[] ids) {
        courserDesService.removeByIdsAndtree(ids);

        return R.ok();
    }
}
