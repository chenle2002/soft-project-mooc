package com.chenle.memberservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chenle.common.util.PageUtils;
import com.chenle.common.util.R;
import com.chenle.common.vo.TeacherInfoVo;
import com.chenle.memberservice.entity.UserEntity;
import com.chenle.memberservice.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "用户管理")
@RequestMapping("member/user")
public class UserController {
    @Autowired
    private UserService userService;


    @Operation(summary ="根据用户Id获取该用户信息")
    @Parameters({
            @Parameter(name = "id",required = true,description = "用户Id")
    })
    @ApiResponse(description = "返回用户信息UserEntity", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = UserEntity.class)))
    @RequestMapping(value = "/getone/{id}", method= {RequestMethod.GET, RequestMethod.POST})
    public UserEntity getone(@PathVariable("id") Integer id){
        return userService.getOne(new QueryWrapper<UserEntity>().eq("id", id));
    }



    @Operation(summary ="用户登录功能")
    @Parameters({
            @Parameter(name = "username",required = true,description = "用户名"),
            @Parameter(name = "password",required = true,description = "密码")
    })
    @ApiResponse(description = "返回用户登陆状态", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/login", method= {RequestMethod.GET, RequestMethod.POST})
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
    @Operation(summary ="获取所有用户信息")
    @ApiResponse(description = "获取所有用户信息并封装为R", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/list", method= {RequestMethod.GET, RequestMethod.POST})
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @Operation(summary ="获取单个用户信息")
    @ApiResponse(description = "获取单个用户信息并封装为R", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/info/{id}", method= {RequestMethod.GET, RequestMethod.POST})
    public R info(@PathVariable("id") Integer id){
		UserEntity user = userService.getById(id);

        return R.ok().put("user", user);
    }


    @Operation(summary ="通过用户Id获取该用户信息实体类")
    @ApiResponse(description = "将用户实体类数据封装为R", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @Parameters({
            @Parameter(name = "id",required = true,description = "用户Id")
    })
    @RequestMapping(value = "/getuserbyid", method= {RequestMethod.GET, RequestMethod.POST})
    public R infod(@RequestParam Integer id){
        UserEntity user = userService.getById(id);

        return R.ok().put("user", user);
    }
    /**
     * 保存
     */
    @Operation(summary ="管理员保存一个新用户")
    @ApiResponse(description = "返回状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @Parameters({
            @Parameter(name = "user",required = true,description = "用户实体类")
    })
    @RequestMapping(value = "/save", method= {RequestMethod.GET, RequestMethod.POST})
    public R save(@RequestBody UserEntity user){
		userService.save(user);

        return R.ok();
    }


    @Operation(summary ="注册一个新用户")
    @ApiResponse(description = "返回注册状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @Parameters({
            @Parameter(name = "username",required = true,description = "用户名"),
            @Parameter(name = "password",required = true,description = "密码")
    })
    @RequestMapping(value = "/register", method= {RequestMethod.GET, RequestMethod.POST})
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
    @Operation(summary ="修改用户信息")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/update", method= {RequestMethod.GET, RequestMethod.POST})
    public R update(@RequestBody UserEntity user){
		userService.updateById(user);

        return R.ok();
    }

    /**
     * 删除
     */
    @Operation(summary ="删除教师信息")
    @ApiResponse(description = "返回操作状态码", content = @Content(mediaType = "application/json"
            , schema = @Schema(implementation = R.class)))
    @RequestMapping(value = "/delete", method= {RequestMethod.GET, RequestMethod.POST})
    public R delete(@RequestBody Integer[] ids){
		userService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
