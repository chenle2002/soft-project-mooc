package com.chenle.courseservice.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenle.common.entity.UserEntity;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.Query;
import com.chenle.common.vo.CommonVo;
import com.chenle.courseservice.dao.CommonDao;
import com.chenle.courseservice.entity.CommonEntity;
import com.chenle.courseservice.openfeign.MemberServiceFeign;
import com.chenle.courseservice.service.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service("commonService")
public class CommonServiceImpl extends ServiceImpl<CommonDao, CommonEntity> implements CommonService {

    @Autowired
    MemberServiceFeign memberServiceFeign;

    Random r = new Random();
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommonEntity> page = this.page(
                new Query<CommonEntity>().getPage(params),
                new QueryWrapper<CommonEntity>()
        );

        return new PageUtils(page);
    }
    @Override
    public List<CommonVo> getBycourseId(Integer courseId) {
        List<CommonEntity> commonEntities = this.baseMapper.selectList(new QueryWrapper<CommonEntity>().eq("course_id", courseId));
        List<CommonVo> id1 = commonEntities.stream().map(item -> {
            CommonVo commonVo = new CommonVo();
            commonVo.setId(item.getId());
            commonVo.setComment(item.getInformation());
            UserEntity id = memberServiceFeign.getone(item.getUserId());
            commonVo.setName(id.getUsername());
            commonVo.setHeadImg("https://ae01.alicdn.com/kf/Hd60a3f7c06fd47ae85624badd32ce54dv.jpg");
            commonVo.setTime(item.getTime());
            commonVo.setLike(r.nextInt(50));
            commonVo.setInputShow(false);
            return commonVo;
        }).collect(Collectors.toList());
        return id1;
    }
}
