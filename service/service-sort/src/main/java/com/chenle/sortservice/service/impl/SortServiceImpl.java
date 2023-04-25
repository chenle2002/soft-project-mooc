package com.chenle.sortservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.Query;
import com.chenle.sortservice.dao.SortDao;
import com.chenle.sortservice.entity.CourseList;
import com.chenle.sortservice.entity.CourserDesEntity;
import com.chenle.sortservice.entity.SortEntity;
import com.chenle.sortservice.openfeign.CourseServiceFeign;
import com.chenle.sortservice.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("sortService")
public class SortServiceImpl extends ServiceImpl<SortDao, SortEntity> implements SortService {

    @Autowired
    CourseServiceFeign courseServiceFeign;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SortEntity> page = this.page(
                new Query<SortEntity>().getPage(params),
                new QueryWrapper<SortEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SortEntity> getzone() {
        List<SortEntity> sortEntities = this.baseMapper.selectList(null);

        List<SortEntity> collect = sortEntities.stream().map(item -> {
            Integer zoneId = item.getId();
            List<CourserDesEntity> courserDesEntities = courseServiceFeign.listbySort(zoneId);
            if(courserDesEntities!=null||courserDesEntities.size()>0){
                List<CourseList> courseListList = new ArrayList<>();
                courserDesEntities.forEach(courserDes -> {
                    CourseList courseList = new CourseList();
                    courseList.setId(courserDes.getId());
                    courseList.setCourseName(courserDes.getName());
                    courseList.setCourseLogo(courserDes.getImage());
                    courseList.setRulingPrice(10000.25);
                    courseList.setCoursePrice(2000D);

                    //course《list《list

                    courseListList.add(courseList);
                });
                item.setCourseList(courseListList);
                return item;
            }else {
                return item;
            }
        }).collect(Collectors.toList());
        return collect;
    }

}
