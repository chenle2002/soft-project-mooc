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
@RestController
@RequestMapping("course/courserdes")
public class CourserDesController {

    @Autowired
    private CourserDesService courserDesService;
    @Autowired
    OssServiceFeign ossServiceFeign;

    @RequestMapping("/getone/{findgrandfather}")
    public CourserDesEntity getone(@PathVariable("findgrandfather") Integer findgrandfather){
        return courserDesService.getOne(new QueryWrapper<CourserDesEntity>().eq("course_id", findgrandfather));
    }

    @RequestMapping("/listbySort/{zoneId}")
    public List<CourserDesEntity> listbySort(@PathVariable("zoneId") Integer zoneId){
        return courserDesService.listbySort(zoneId);
    }

    @RequestMapping("/pdf/policy")
    public R pdfpolicy() {
        return ossServiceFeign.pdfpolicy();
    }

    @RequestMapping("/image/policy")
    public R imagepolicy() {
        return ossServiceFeign.imagepolicy();
    }

    @RequestMapping("/video/policy")
    public R videopolicy() {
        return ossServiceFeign.videopolicy();
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = courserDesService.queryPage(params);

        return R.ok().put("page", page);
    }

    @RequestMapping("/listname")
    public R listWithName(@RequestParam Map<String, Object> params) {
        List<CourseDesResVo> page = courserDesService.listWithName(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id) {
        CourserDesEntity courserDes = courserDesService.getById(id);

        return R.ok().put("courserDes", courserDes);
    }

    @RequestMapping("/info/des")
    public R getdes(@RequestParam Integer courseId) {
        CourseDesVo data = courserDesService.getdesByID(courseId);

        return R.ok().put("data", data);
    }
    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CourserDesEntity courserDes) {
        courserDesService.saveall(courserDes);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CourserDesEntity courserDes) {
        courserDesService.updateByIdWithTree(courserDes);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids) {
        courserDesService.removeByIdsAndtree(ids);

        return R.ok();
    }
}
