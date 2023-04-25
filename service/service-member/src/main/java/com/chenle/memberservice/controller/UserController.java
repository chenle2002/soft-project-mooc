package com.chenle.memberservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.memberservice.entity.UserEntity;
import com.chenle.memberservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-11-22 16:14:53
 */
@RestController
@RequestMapping("member/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/getone/{id}")
    public UserEntity getone(@PathVariable("id") Integer id){
        return userService.getOne(new QueryWrapper<UserEntity>().eq("id", id));
    }

    @RequestMapping("/login")
    public R login(String username,String password){
        UserEntity userEntity=userService.login(username,password);
        if(userEntity!=null){
            return R.ok().put("user",userEntity);
        }else {
            return R.error();
        }
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		UserEntity user = userService.getById(id);

        return R.ok().put("user", user);
    }
    @RequestMapping("/getuserbyid")
    public R infod(@RequestParam Integer id){
        UserEntity user = userService.getById(id);

        return R.ok().put("user", user);
    }
    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserEntity user){
		userService.save(user);

        return R.ok();
    }
    @RequestMapping("/register")
    public R register(String username,String password){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(password);
        userEntity.setStatus(1);
        userService.save(userEntity);

        return R.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserEntity user){
		userService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		userService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
