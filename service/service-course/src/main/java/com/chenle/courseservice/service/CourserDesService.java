package com.chenle.courseservice.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.chenle.common.util.PageUtils;
import com.chenle.common.vo.CourseDesResVo;
import com.chenle.common.vo.CourseDesVo;
import com.chenle.courseservice.entity.CourserDesEntity;

import java.util.List;
import java.util.Map;
/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-11-22 16:14:53
 */
public interface CourserDesService extends IService<CourserDesEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CourseDesResVo> listWithName(Map<String, Object> params);

    List<CourserDesEntity> listbySort(Integer zoneId);

    void saveall(CourserDesEntity courserDes);

    void updateByIdWithTree(CourserDesEntity courserDes);


    void removeByIdsAndtree(Integer[] ids);

    CourseDesVo getdesByID(Integer courseId);
}

