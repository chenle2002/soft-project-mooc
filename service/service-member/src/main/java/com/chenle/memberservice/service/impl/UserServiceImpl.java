package com.chenle.memberservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.Query;
import com.chenle.memberservice.entity.UserEntity;
import com.chenle.memberservice.service.UserService;
import com.chenle.memberservice.dao.UserDao;

import org.springframework.stereotype.Service;

import java.util.Map;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public UserEntity login(String username,String password) {
        UserEntity userEntity = this.baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("username", username));
        if(userEntity!=null){
            if(userEntity.getPassword().equals(password)){
                return userEntity;
            }
        }
        return null;
    }
}
