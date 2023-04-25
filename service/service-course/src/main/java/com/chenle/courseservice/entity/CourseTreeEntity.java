package com.chenle.courseservice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-11-22 16:14:53
 */
@Data
@TableName("course_tree")
public class CourseTreeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer courseId;
	/**
	 *
	 */
	private String name;
	/**
	 *
	 */
	private Integer parentCid;
	/**
	 *
	 */
	private Integer catLevel;
	/**
	 *
	 */
	private Integer showStatus;
	/**
	 *
	 */
	private String icon;
	/**
	 *
	 */
	private Integer sort;
	private String video;

	@TableField(exist = false)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<CourseTreeEntity> children;

}
