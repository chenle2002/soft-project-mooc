package com.chenle.memberservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-11-22 16:14:53
 */
@Data
@TableName("user")
@Schema(name="user",description ="用户实体类" )
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@Schema(name="id",description ="用户Id" )
	private Integer id;
	/**
	 *
	 */
	@Schema(name="username",description ="用户名" )
	private String username;
	/**
	 *
	 */
	@Schema(name="password",description ="密码" )
	private String password;
	/**
	 *
	 */
	@Schema(name="status",description ="用户状态" )
	private Integer status;

}
