package com.chenle.courseservice.controller;


import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.common.vo.CommonVo;
import com.chenle.courseservice.entity.CommonEntity;
import com.chenle.courseservice.service.CommonService;

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
@RequestMapping("course/common")
public class CommonController {
    @Autowired
    private CommonService commonService;



    @RequestMapping("/getcommon")
    public R getById(@RequestParam Integer courseId){
        List<CommonVo> commonVo=commonService.getBycourseId(courseId);

        return R.ok().put("page", commonVo);
    }



    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = commonService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		CommonEntity common = commonService.getById(id);

        return R.ok().put("common", common);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody CommonEntity common){
		commonService.save(common);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CommonEntity common){
		commonService.updateById(common);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		commonService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
