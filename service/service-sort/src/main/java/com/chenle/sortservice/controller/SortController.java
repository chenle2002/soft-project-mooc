package com.chenle.sortservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.sortservice.entity.SortEntity;
import com.chenle.sortservice.service.SortService;
import io.swagger.v3.oas.annotations.Operation;
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
//@Api(tags = "课程分类信息")
@RestController
@RequestMapping("sort/sort")
public class SortController {
    @Autowired
    private SortService sortService;

    @RequestMapping(value = "/getone/{sortId}", method= {RequestMethod.GET, RequestMethod.POST})
    public SortEntity getone(@PathVariable("sortId") Integer sortId){
        return sortService.getOne(new QueryWrapper<SortEntity>().eq("sort_id", sortId));
    }


    /**
     * 列表
     */

    @Operation(summary ="获取用户主页显示的所有课程并进行结构封装")
//    @ApiOperation(value = "获取用户主页显示的所有课程并进行结构封装")
    @RequestMapping(value = "/list/zone", method= {RequestMethod.GET, RequestMethod.POST})
    public R getzone(){
        List<SortEntity> page = sortService.getzone();

        return R.ok().put("page", page);
    }




    /**
     * 列表
     */
    @RequestMapping(value = "/list", method= {RequestMethod.GET, RequestMethod.POST})
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sortService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{sortId}", method= {RequestMethod.GET, RequestMethod.POST})
    public R info(@PathVariable("sortId") Integer sortId){
		SortEntity sort = sortService.getById(sortId);

        return R.ok().put("sort", sort);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", method= {RequestMethod.GET, RequestMethod.POST})
    public R save(@RequestBody SortEntity sort){
		sortService.save(sort);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", method= {RequestMethod.GET, RequestMethod.POST})
    public R update(@RequestBody SortEntity sort){
		sortService.updateById(sort);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method= {RequestMethod.GET, RequestMethod.POST})
    public R delete(@RequestBody Integer[] sortIds){
		sortService.removeByIds(Arrays.asList(sortIds));

        return R.ok();
    }

}
