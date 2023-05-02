package com.chenle.sortservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.sortservice.entity.SortEntity;
import com.chenle.sortservice.service.SortService;
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
@Tag(name="课程分类信息")
@RestController
@RequestMapping("sort/sort")
public class SortController {
    @Autowired
    private SortService sortService;

    @Operation(summary ="根据传来的分类Id获取该分类的实体类")
    @RequestMapping(value = "/getone/{sortId}", method= {RequestMethod.GET, RequestMethod.POST})
    @ApiResponse(description = "返回分类的实体类", content = @Content(mediaType = "application/json", schema = @Schema(implementation = SortEntity.class)))
    public SortEntity getone(@PathVariable("sortId") Integer sortId){
        return sortService.getOne(new QueryWrapper<SortEntity>().eq("sort_id", sortId));
    }


    /**
     * 列表
     */

    @Operation(summary ="获取用户主页显示的所有课程并进行结构封装")
    @ApiResponse(description = "返回所有课程信息数据并封装为R", content = @Content(mediaType = "application/json", schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/list/zone", method= {RequestMethod.GET, RequestMethod.POST})
    public R getzone(){
        List<SortEntity> page = sortService.getzone();

        return R.ok().put("page", page);
    }




    /**
     * 列表
     */
    @Operation(summary ="获取所有分类表数据")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json", schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/list", method= {RequestMethod.GET, RequestMethod.POST})
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sortService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @Operation(summary ="获取单个分类表数据")
    @Parameters({
            @Parameter(name = "sortId",required = true,description = "分类Id")
    })
    @ApiResponse(description = "返回分类实体类并封装为R", content = @Content(mediaType = "application/json", schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/info/{sortId}", method= {RequestMethod.GET, RequestMethod.POST})
    public R info(@PathVariable("sortId") Integer sortId){
		SortEntity sort = sortService.getById(sortId);

        return R.ok().put("sort", sort);
    }

    /**
     * 保存
     */
    @Parameters({
            @Parameter(name = "sort",required = true,description = "分类实体类")
    })
    @Operation(summary ="新增分类表数据")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json", schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/save", method= {RequestMethod.GET, RequestMethod.POST})
    public R save(@RequestBody SortEntity sort){
		sortService.save(sort);

        return R.ok();
    }

    /**
     * 修改
     */
    @Operation(summary ="修改分类表数据")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json", schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/update", method= {RequestMethod.GET, RequestMethod.POST})
    public R update(@RequestBody SortEntity sort){
		sortService.updateById(sort);

        return R.ok();
    }

    /**
     * 删除
     */
    @Operation(summary ="删除分类表数据")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json", schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/delete", method= {RequestMethod.GET, RequestMethod.POST})
    public R delete(@RequestBody Integer[] sortIds){
		sortService.removeByIds(Arrays.asList(sortIds));

        return R.ok();
    }

}
