package com.chenle.courseservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenle.common.entity.TeacherEntity;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.Query;
import com.chenle.common.vo.CourseDesResVo;
import com.chenle.common.vo.CourseDesVo;
import com.chenle.common.vo.TeacherInfoVo;


import com.chenle.courseservice.dao.CourserDesDao;
import com.chenle.courseservice.entity.CourseTreeEntity;
import com.chenle.courseservice.entity.CourserDesEntity;
import com.chenle.courseservice.entity.SortEntity;
import com.chenle.courseservice.openfeign.MemberServiceFeign;
import com.chenle.courseservice.openfeign.SortServiceFeign;
import com.chenle.courseservice.service.CourseTreeService;
import com.chenle.courseservice.service.CourserDesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("courserDesService")
public class CourserDesServiceImpl extends ServiceImpl<CourserDesDao, CourserDesEntity> implements CourserDesService {

    @Autowired
    SortServiceFeign sortServiceFeign;
    @Autowired
    MemberServiceFeign memberServiceFeign;

    @Autowired
    CourseTreeService courseTreeService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CourserDesEntity> page = this.page(
                new Query<CourserDesEntity>().getPage(params),
                new QueryWrapper<CourserDesEntity>()
        );

        return new PageUtils(page);
    }


    @Override
    public List<CourseDesResVo> listWithName(Map<String, Object> params) {
        List<CourserDesEntity> desEntities = this.baseMapper.selectList(null);
        List<CourseDesResVo> collect = desEntities.stream().map(item -> {
            CourseDesResVo courseDesResVo = new CourseDesResVo();

            Integer sortId = item.getSortId();
            if (sortId != null) {
                SortEntity sort_id = sortServiceFeign.getone(sortId);
                courseDesResVo.setSortName(sort_id.getZoneName());
            }
            Integer teacherId = item.getTeacherId();
            if (teacherId != null) {
                TeacherEntity teacher_id = memberServiceFeign.getoneTeacher(teacherId);
                courseDesResVo.setTeacherName(teacher_id.getName());
            }
            courseDesResVo.setId(item.getId());
            courseDesResVo.setName(item.getName());
            courseDesResVo.setDescription(item.getDescription());
            courseDesResVo.setImage(item.getImage());
            return courseDesResVo;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<CourserDesEntity> listbySort(Integer zoneId) {
        return this.baseMapper.selectList(new QueryWrapper<CourserDesEntity>().eq("sort_id", zoneId));
    }

    @Transactional
    @Override
    public void saveall(CourserDesEntity courserDes) {
        CourseTreeEntity courseTree = new CourseTreeEntity();
        courseTree.setName(courserDes.getName());
        courseTree.setParentCid(0);
        courseTree.setCatLevel(1);
        courseTree.setShowStatus(1);
        courseTree.setSort(0);
        courseTree.setVideo(null);

        courseTreeService.save(courseTree);
        CourseTreeEntity name = courseTreeService.getOne(new QueryWrapper<CourseTreeEntity>().eq("name", courserDes.getName()));
        courserDes.setCourse_id(name.getCourseId());
        this.save(courserDes);
    }

    @Transactional
    @Override
    public void updateByIdWithTree(CourserDesEntity courserDes) {
        CourserDesEntity courserDesold = this.baseMapper.selectById(courserDes.getId());
        String name = courserDesold.getName();
        this.updateById(courserDes);

        CourseTreeEntity courseTree = courseTreeService.getOne(new QueryWrapper<CourseTreeEntity>().eq("name", name));
        courseTree.setName(courserDes.getName());
        courseTreeService.updateById(courseTree);

    }

    @Transactional
    @Override
    public void removeByIdsAndtree(Integer[] ids) {
        this.removeByIds(Arrays.asList(ids));
//        System.out.println(ids);
//        Integer[] idsTree=new Integer[ids.length];
//
//        for(int i=0;i<ids.length;i++){
//            int s = Integer.parseInt(ids[i].toString());
//            CourserDesEntity id = this.getOne(new QueryWrapper<CourserDesEntity>().eq("id", s));
////            CourserDesEntity courserDesEntity = this.baseMapper.selectById(ids[i].toString());
//            idsTree[i]=id.getCourse_id();
//        }
//        courseTreeService.removeByIds(Arrays.asList(idsTree));
    }

    @Override
    public CourseDesVo getdesByID(Integer courseId) {
        CourserDesEntity courserDes = this.getOne(new QueryWrapper<CourserDesEntity>().eq("course_id", courseId));

        CourseDesVo courseDesVo = new CourseDesVo();
        courseDesVo.setAllowStudy(String.valueOf(0));
        courseDesVo.setId(String.valueOf(courserDes.getId()));
        courseDesVo.setGmtCreate("2020-10-05 17 50:26");
        courseDesVo.setGmtModified("2022-12-15 19:00");
        courseDesVo.setCourseName(courserDes.getName());
        courseDesVo.setCourseLogo(courserDes.getImage());
        courseDesVo.setIntroduce("<h4><br/></h4><br/> <h4 style='text-align: left'>"+courserDes.getDescription()+"</h4>");
        courseDesVo.setIsFree(String.valueOf(0));
        courseDesVo.setRulingPrice(String.valueOf(10000.5));
        courseDesVo.setCoursePrice(String.valueOf(2000));
        courseDesVo.setCountBuy(String.valueOf(2500));
        courseDesVo.setCountStudy(String.valueOf(8888));
        courseDesVo.setCategoryId(String.valueOf(111111111));

        TeacherInfoVo teacherInfo = memberServiceFeign.getteacherinfo(courseId);
        courseDesVo.setLecturerId(String.valueOf(teacherInfo.getId()));
        courseDesVo.setLecturerResp(teacherInfo);

        courseDesVo.setPdf(courserDes.getPdf());
        return courseDesVo;
    }

}
