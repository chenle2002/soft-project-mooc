package com.chenle.courseservice.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.chenle.common.util.PageUtils;
import com.chenle.common.vo.CommonVo;
import com.chenle.courseservice.entity.CommonEntity;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-12-16 20:59:34
 */
public interface CommonService extends IService<CommonEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CommonVo> getBycourseId(Integer courseId);
}

