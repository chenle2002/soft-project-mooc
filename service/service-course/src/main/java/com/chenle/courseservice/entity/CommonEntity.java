package com.chenle.courseservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class CommonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer id;
	/**
	 *
	 */
	private Integer userId;
	/**
	 *
	 */
	private Integer courseId;
	/**
	 *
	 */
	private String information;
	/**
	 *
	 */
	private Integer zan;
	/**
	 *
	 */
	private String time;

}
