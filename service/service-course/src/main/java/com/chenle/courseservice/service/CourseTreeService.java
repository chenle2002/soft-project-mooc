package com.chenle.courseservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenle.common.util.PageUtils;
import com.chenle.common.vo.CourseVo;
import com.chenle.courseservice.entity.CourseTreeEntity;


import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-11-25 08:50:34
 */
public interface CourseTreeService extends IService<CourseTreeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CourseTreeEntity> listWithTree();

    PageUtils listgrandfather(Map<String, Object> params);

    PageUtils listgrandson(Map<String, Object> params);

    List<CourseVo> lislingketree();

    List<CourseTreeEntity> listCourse(Integer getId);

    void updateByIdWithDes(CourseTreeEntity courseTree);
    public Integer findgrandfather(Integer getId);
}

