package com.chenle.sortservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenle.common.util.PageUtils;
import com.chenle.sortservice.entity.SortEntity;

import java.util.List;
import java.util.Map;
/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-11-22 16:14:53
 */
public interface SortService extends IService<SortEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SortEntity> getzone();
}

