package com.chenle.sortservice.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.Query;
import com.chenle.sortservice.dao.CarouselDao;
import com.chenle.sortservice.entity.CarouselEntity;
import com.chenle.sortservice.service.CarouselService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("carouselService")
public class CarouselServiceImpl extends ServiceImpl<CarouselDao, CarouselEntity> implements CarouselService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CarouselEntity> page = this.page(
                new Query<CarouselEntity>().getPage(params),
                new QueryWrapper<CarouselEntity>()
        );

        return new PageUtils(page);
    }

}
