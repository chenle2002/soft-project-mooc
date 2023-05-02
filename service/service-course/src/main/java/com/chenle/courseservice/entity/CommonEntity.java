package com.chenle.courseservice.entity;

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
 * @date 2022-12-16 20:59:34
 */
@Data
@TableName("common")
@Schema(name="common",description ="评论实体类" )
public class CommonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@Schema(name="id",description ="评论Id" )
	private Integer id;
	/**
	 *
	 */
	@Schema(name="userId",description ="评论所属用户Id" )
	private Integer userId;
	/**
	 *
	 */
	@Schema(name="courseId",description ="课程Id" )
	private Integer courseId;
	/**
	 *
	 */
	@Schema(name="information",description ="评论内容" )
	private String information;
	/**
	 *
	 */
	@Schema(name="zan",description ="点赞数" )
	private Integer zan;
	/**
	 *
	 */
	@Schema(name="time",description ="评论时间" )
	private String time;

}
