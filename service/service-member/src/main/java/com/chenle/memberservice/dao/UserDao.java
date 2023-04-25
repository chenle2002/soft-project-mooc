package com.chenle.memberservice.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chenle.memberservice.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-11-22 16:14:53
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
