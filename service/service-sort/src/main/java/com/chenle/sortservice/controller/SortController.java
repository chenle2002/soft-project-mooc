package com.chenle.sortservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.sortservice.entity.CourserDesEntity;
import com.chenle.sortservice.entity.SortEntity;
import com.chenle.sortservice.service.SortService;
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
@RequestMapping("sort/sort")
public class SortController {
    @Autowired
    private SortService sortService;

    @RequestMapping("/getone/{sortId}")
    public SortEntity getone(@PathVariable("sortId") Integer sortId){
        return sortService.getOne(new QueryWrapper<SortEntity>().eq("sort_id", sortId));
    }


    /**
     * 列表
     */
    @RequestMapping("/list/zone")
    public R getzone(){
        List<SortEntity> page = sortService.getzone();

        return R.ok().put("page", page);
    }




    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sortService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sortId}")
    public R info(@PathVariable("sortId") Integer sortId){
		SortEntity sort = sortService.getById(sortId);

        return R.ok().put("sort", sort);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SortEntity sort){
		sortService.save(sort);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SortEntity sort){
		sortService.updateById(sort);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] sortIds){
		sortService.removeByIds(Arrays.asList(sortIds));

        return R.ok();
    }

}
