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
@TableName("teacher")
@Schema(name="teacher",description ="教师实体类" )
public class TeacherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@Schema(name="teacherId",description ="教师Id" )
	private Integer teacherId;
	/**
	 *
	 */
	@Schema(name="name",description ="教师名" )
	private String name;

	@Schema(name="description",description ="教师介绍" )
	private String description;

}
