package com.chenle.courseservice.controller;


import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.common.vo.CommonVo;
import com.chenle.courseservice.entity.CommonEntity;
import com.chenle.courseservice.service.CommonService;

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
import java.util.List;
import java.util.Map;


/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-11-22 16:14:53
 */
@RestController
@Tag(name = "评论信息管理")
@RequestMapping("course/common")
public class CommonController {
    @Autowired
    private CommonService commonService;


    @Operation(summary ="获取该课程的所有评论")
    @Parameters({
            @Parameter(name = "courseId",required = true,description = "课程Id"),
    })
    @ApiResponse(description = "返回该课程的所有评论并封装为R", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/getcommon", method= {RequestMethod.GET, RequestMethod.POST})
    public R getById(@RequestParam Integer courseId){
        List<CommonVo> commonVo=commonService.getBycourseId(courseId);

        return R.ok().put("page", commonVo);
    }



    /**
     * 列表
     */
    @Operation(summary ="获取所有评论信息")
    @ApiResponse(description = "返回评论信息并封装为R", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/list", method= {RequestMethod.GET, RequestMethod.POST})
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commonService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @Operation(summary ="获取单个评论信息")
    @Parameters({
            @Parameter(name = "id",required = true,description = "评论Id")
    })
    @ApiResponse(description = "返回评论信息并封装为R", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/info/{id}", method= {RequestMethod.GET, RequestMethod.POST})
    public R info(@PathVariable("id") Integer id){
		CommonEntity common = commonService.getById(id);

        return R.ok().put("common", common);
    }

    /**
     * 保存
     */
    @Operation(summary ="保存评论信息")
    @Parameters({
            @Parameter(name = "common",required = true,description = "评论实体类")
    })
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @PostMapping(value = "/save")
    public R save(@RequestBody CommonEntity common){
		commonService.save(common);

        return R.ok();
    }

    /**
     * 修改
     */
    @Operation(summary ="修改评论信息")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/update", method= {RequestMethod.GET, RequestMethod.POST})
    public R update(@RequestBody CommonEntity common){
		commonService.updateById(common);

        return R.ok();
    }

    /**
     * 删除
     */
    @Operation(summary ="删除评论信息")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/delete", method= {RequestMethod.GET, RequestMethod.POST})
    public R delete(@RequestBody Integer[] ids){
		commonService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
