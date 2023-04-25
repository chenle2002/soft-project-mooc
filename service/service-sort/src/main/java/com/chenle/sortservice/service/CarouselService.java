package com.chenle.sortservice.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.chenle.common.util.PageUtils;
import com.chenle.sortservice.entity.CarouselEntity;

import java.util.Map;

/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-12-01 14:48:41
 */
public interface CarouselService extends IService<CarouselEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

