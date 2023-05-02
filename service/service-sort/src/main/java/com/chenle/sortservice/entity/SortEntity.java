package com.chenle.sortservice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
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
@TableName("sort")
@Schema(name="Sort",description ="分类实体类" )
public class SortEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@Schema(name="id",description ="分类Id" )
	private Integer id;
	/**
	 *
	 */
	@Schema(name="zoneName",description ="分类名称" )
	private String zoneName;

	@Schema(name="zoneDesc",description ="分类描述" )
	private String zoneDesc;

	@TableField(exist = false)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@Schema(name="courseList",description ="该分类下的课程集合" )
	private List<CourseList> courseList;

}

