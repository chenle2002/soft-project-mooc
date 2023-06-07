package com.chenle.sortservice.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.nacos.common.utils.ExceptionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.Query;
import com.chenle.common.util.R;
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
    public R getzone() {
        List<SortEntity> sortEntities = this.baseMapper.selectList(null);

        List<SortEntity> collect = new ArrayList<>();
        for (SortEntity item : sortEntities) {
            Integer zoneId = item.getId();
            R r = courseServiceFeign.listbySort(zoneId);
            if (r.getCode().equals(250)) {
                return R.error(250, "课程信息微服务暂不可用，请稍后再试！");
            } else {
                List<CourserDesEntity> courserDesEntities = r.getData("data", new TypeReference<List<CourserDesEntity>>() {
                });
                if (courserDesEntities != null || courserDesEntities.size() > 0) {
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
                }
            }
            collect.add(item);
        }
        return R.ok().put("page", collect);
    }
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SortEntity> page = this.page(
                new Query<SortEntity>().getPage(params),
                new QueryWrapper<SortEntity>()
        );

        return new PageUtils(page);
    }


}

