package com.chenle.memberservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chenle.common.util.PageUtils;
import com.chenle.memberservice.entity.UserEntity;

import java.util.Map;

/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-11-22 16:14:53
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    UserEntity login(String username,String password);
}

