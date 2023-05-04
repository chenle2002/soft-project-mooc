package com.chenle.courseservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.common.vo.CourseVo;
import com.chenle.courseservice.entity.CourseTreeEntity;

import com.chenle.courseservice.entity.CourserDesEntity;
import com.chenle.courseservice.service.CourseTreeService;
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
@Tag(name = "课程树结构管理")
@RequestMapping("course/coursetree")
public class CourseTreeController {
    @Autowired
    private CourseTreeService courseTreeService;

    @Operation(summary ="根据章节Id寻找父节点Id")
    @Parameters({
            @Parameter(name = "courseId",required = true,description = "章节Id")
    })
    @ApiResponse(description = "父节点Id", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = Integer.class)))
    @RequestMapping(value = "/findgrandfather/{courseId}", method= {RequestMethod.GET, RequestMethod.POST})
    public Integer findgrandfather(@PathVariable("courseId") Integer courseId){
        return courseTreeService.findgrandfather(courseId);
    }


    /**
     * 列表
     */
    @Operation(summary ="寻找所有课程树结构数据")
    @ApiResponse(description = "课程树数据", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = List.class)))
    @RequestMapping(value = "/list/lingketree", method= {RequestMethod.GET, RequestMethod.POST})
    public R listLingKe(){
        log.info(String.valueOf(123));
        List<CourseVo> entityList =  courseTreeService.lislingketree();
        return R.ok().put("page", entityList);
    }
    /**
     * 单独需要的课程
     */
    @Operation(summary ="根据课程Id寻找课程树实体类")
    @Parameters({
            @Parameter(name = "getId",required = true,description = "课程Id")
    })
    @ApiResponse(description = "课程树实体类", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/list/course", method= {RequestMethod.GET, RequestMethod.POST})
    public R listCourse(@RequestParam Integer getId){
//        log.info(String.valueOf(123));
        List<CourseTreeEntity> entityList =  courseTreeService.listCourse(getId);
        return R.ok().put("page", entityList);
    }

    /**
     * 列表
     */
    @Operation(summary ="返回课程树结构")
    @ApiResponse(description = "返回课程树结构并封装为R", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/list/tree", method= {RequestMethod.GET, RequestMethod.POST})
    public R listWithTree(@RequestParam Map<String, Object> params){
        log.info(String.valueOf(123));
        List<CourseTreeEntity> entityList =  courseTreeService.listWithTree();
        return R.ok().put("page", entityList);
    }


    /**
     * 列表
     */
    @Operation(summary ="无规律返回课程数据（默认方法不使用）")

    @ApiResponse(description = "返回所有课程树的数据", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/list", method= {RequestMethod.GET, RequestMethod.POST})
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseTreeService.queryPage(params);

        return R.ok().put("page", page);
    }



    @Operation(summary ="根据参数寻找父节点")
    @ApiResponse(description = "课程树数据", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/list/grandfather", method= {RequestMethod.GET, RequestMethod.POST})
    public R listgrandfather(@RequestParam Map<String, Object> params){
        PageUtils page = courseTreeService.listgrandfather(params);

        return R.ok().put("page", page);
    }



    @Operation(summary ="根据参数寻找所有子节点")
    @ApiResponse(description = "课程字节点数据", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/list/grandson", method= {RequestMethod.GET, RequestMethod.POST})
    public R grandson(@RequestParam Map<String, Object> params){
        PageUtils page = courseTreeService.listgrandson(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @Operation(summary ="根据课程Id寻寻找课程树实体类")
    @Parameters({
            @Parameter(name = "courseId",required = true,description = "课程Id")
    })
    @ApiResponse(description = "课程树实体类", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = CourseTreeEntity.class)))
    @RequestMapping(value = "/info/{courseId}", method= {RequestMethod.GET, RequestMethod.POST})
    public R info(@PathVariable("courseId") Integer courseId){
        CourseTreeEntity courseTree = courseTreeService.getById(courseId);

        return R.ok().put("courseTree", courseTree);
    }

    /**
     * 保存
     */
    @Operation(summary ="保存课程树信息")
    @Parameters({
            @Parameter(name = "courseTree",required = true,description = "课程树实体类")
    })
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/save", method= {RequestMethod.GET, RequestMethod.POST})
    public R save(@RequestBody CourseTreeEntity courseTree){
        courseTreeService.save(courseTree);

        return R.ok();
    }

    /**
     * 修改
     */
    @Operation(summary ="修改课程树信息")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/update", method= {RequestMethod.GET, RequestMethod.POST})
    public R update(@RequestBody CourseTreeEntity courseTree){
        courseTreeService.updateById(courseTree);

        return R.ok();
    }

    /**
     * 删除
     */
    @Operation(summary ="删除课程树信息")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/delete", method= {RequestMethod.GET, RequestMethod.POST})
    public R delete(@RequestBody Integer[] courseIds){
        courseTreeService.removeByIds(Arrays.asList(courseIds));

        return R.ok();
    }

}
