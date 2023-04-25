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
 * @date 2022-11-25 09:34:22
 */
@Data
@TableName("courser_des")
public class CourserDesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer id;
	/**
	 *
	 */
	private String description;
	/**
	 *
	 */
	private Integer sortId;
	/**
	 *
	 */
	private Integer course_id;
	private Integer teacherId;
	/**
	 *
	 */
	private String name;
	private String image;
	private String pdf;

}
