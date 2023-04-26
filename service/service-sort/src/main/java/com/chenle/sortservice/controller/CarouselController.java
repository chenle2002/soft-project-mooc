package com.chenle.sortservice.controller;


import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.sortservice.entity.CarouselEntity;
import com.chenle.sortservice.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;





/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-12-01 14:48:41
 */
@RestController
@RequestMapping("sort/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list", method= {RequestMethod.GET, RequestMethod.POST})
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = carouselService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{id}", method= {RequestMethod.GET, RequestMethod.POST})
    public R info(@PathVariable("id") Integer id){
		CarouselEntity carousel = carouselService.getById(id);

        return R.ok().put("carousel", carousel);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", method= {RequestMethod.GET, RequestMethod.POST})
    public R save(@RequestBody CarouselEntity carousel){
		carouselService.save(carousel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update", method= {RequestMethod.GET, RequestMethod.POST})
    public R update(@RequestBody CarouselEntity carousel){
		carouselService.updateById(carousel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method= {RequestMethod.GET, RequestMethod.POST})
    public R delete(@RequestBody Integer[] ids){
		carouselService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
