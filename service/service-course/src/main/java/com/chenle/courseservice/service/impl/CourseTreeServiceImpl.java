package com.chenle.courseservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.Query;
import com.chenle.common.vo.CourseVo;
import com.chenle.courseservice.dao.CourseTreeDao;
import com.chenle.courseservice.entity.CourseTreeEntity;

import com.chenle.courseservice.entity.CourserDesEntity;
import com.chenle.courseservice.service.CourseTreeService;
import com.chenle.courseservice.service.CourserDesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("courseTreeService")
public class CourseTreeServiceImpl extends ServiceImpl<CourseTreeDao, CourseTreeEntity> implements CourseTreeService {
    @Autowired
    CourserDesService courserDesService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CourseTreeEntity> page = this.page(
                new Query<CourseTreeEntity>().getPage(params),
                new QueryWrapper<CourseTreeEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CourseTreeEntity> listWithTree() {
        //1.查出所有分类
        List<CourseTreeEntity> entities = baseMapper.selectList(null);

        //2.组装成父子的树形结构
        List<CourseTreeEntity> level1 = entities.stream().filter(courseTree ->
                courseTree.getParentCid() == 0
        ).map((menu) -> {
            menu.setChildren(getchildren(menu, entities));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());

        return level1;
    }

    @Override
    public PageUtils listgrandfather(Map<String, Object> params) {
        IPage<CourseTreeEntity> page = this.page(
                new Query<CourseTreeEntity>().getPage(params),
                new QueryWrapper<CourseTreeEntity>().eq("parent_cid", 0)
        );
        System.out.println(page);
        return new PageUtils(page);
    }

    @Override
    public PageUtils listgrandson(Map<String, Object> params) {
        IPage<CourseTreeEntity> page = this.page(
                new Query<CourseTreeEntity>().getPage(params),
                new QueryWrapper<CourseTreeEntity>().eq("cat_level", 3)
        );
        return new PageUtils(page);
    }

    @Override
    public List<CourseVo> lislingketree() {
        List<CourseTreeEntity> courseTreeEntities = listWithTree();
        List<CourseVo> collect = courseTreeEntities.stream().map(item -> {
            CourseVo courseVo = new CourseVo();
            courseVo.setId(item.getCourseId());
            courseVo.setCategoryName(item.getName());
            courseVo.setRemark(item.getName());
            courseVo.setParentId(item.getParentCid());

            courseVo.setList(findlist(item.getChildren()));
            return courseVo;
        }).collect(Collectors.toList());
        if (collect.size() <= 6) {
            return collect;
        } else {
            return collect.subList(0, 6);
        }
    }

    @Override
    public List<CourseTreeEntity> listCourse(Integer getId) {
        //1.查出所有分类
        List<CourseTreeEntity> entities = baseMapper.selectList(null);

        //2.组装成父子的树形结构
        List<CourseTreeEntity> level1 = entities.stream().filter(courseTree ->
                courseTree.getParentCid() == 0
        ).map((menu) -> {
            menu.setChildren(getchildren(menu, entities));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());

        List<CourseTreeEntity> courseTreeEntityList = new ArrayList<>();
        int find = findgrandfather(getId);
        for (int i = 0; i < level1.size(); i++) {
//            System.out.println(level1.get(i));
            if (level1.get(i).getCourseId() == find) {
                courseTreeEntityList.add(level1.get(i));
            }
        }

        return courseTreeEntityList;
    }

    @Transactional
    @Override
    public void updateByIdWithDes(CourseTreeEntity courseTree) {
        this.updateById(courseTree);
        CourseTreeEntity byId = this.getById(courseTree.getCourseId());
        courseTree=byId;
        if (courseTree.getParentCid() == 0) {
            CourserDesEntity course_id = courserDesService.getOne(new QueryWrapper<CourserDesEntity>().eq("course_id", courseTree.getCourseId()));
            course_id.setName(courseTree.getName());
            course_id.setCourse_id(null);
            courserDesService.updateById(course_id);
        }

    }

    public Integer findgrandfather(Integer getId) {
        CourseTreeEntity course_id = this.getOne(new QueryWrapper<CourseTreeEntity>().eq("course_id", getId));
        Integer parentCid = course_id.getParentCid();
        Integer x = null;
        if (parentCid == 0) {
            return getId;
        }
        if (parentCid != 0) {
            x = findgrandfather(parentCid);
        }
        return x;
    }

    private List<CourseVo> findlist(List<CourseTreeEntity> children) {
        List<CourseVo> courseVoList = new ArrayList<>();
        List<CourseVo> collect = children.stream().map(item -> {
            CourseVo courseVo = new CourseVo();
            courseVo.setId(item.getCourseId());
            courseVo.setCategoryName(item.getName());
            courseVo.setRemark(item.getName());
            courseVo.setParentId(item.getParentCid());

            if (item.getChildren() == null || item.getChildren().size() < 0) {
                courseVo.setList(new ArrayList<>());
            } else {
                List<CourseVo> list = findlist(item.getChildren());
                courseVo.setList(list);
            }
            return courseVo;
        }).collect(Collectors.toList());
        return collect;
    }

    //递归查找当前菜单的子菜单
    private List<CourseTreeEntity> getchildren(CourseTreeEntity root, List<CourseTreeEntity> all) {
        List<CourseTreeEntity> child = all.stream().filter(CourseTreeEntity -> {
            return root.getCourseId().equals(CourseTreeEntity.getParentCid());
        }).map(CourseTreeEntity -> {
            CourseTreeEntity.setChildren(getchildren(CourseTreeEntity, all));
            return CourseTreeEntity;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());

        return child;
    }
}
