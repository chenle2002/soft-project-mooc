package com.chenle.courseservice.entity;

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
@TableName("course_tree")
@Schema(name="course_tree",description ="课程树实体类" )
public class CourseTreeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@Schema(name="courseId",description ="课程Id" )
	private Integer courseId;
	/**
	 *
	 */
	@Schema(name="name",description ="课程名称" )
	private String name;
	/**
	 *
	 */
	@Schema(name="parentCid",description ="该节点的父节点Id" )
	private Integer parentCid;
	/**
	 *
	 */
	@Schema(name="catLevel",description ="节点层级" )
	private Integer catLevel;
	/**
	 *
	 */
	@Schema(name="showStatus",description ="显示状态" )
	private Integer showStatus;
	/**
	 *
	 */
	@Schema(name="icon",description ="图标" )
	private String icon;
	/**
	 *
	 */
	@Schema(name="sort",description ="分类" )
	private Integer sort;

	@Schema(name="video",description ="视频" )
	private String video;


	@Schema(name="children",description ="子节点集合" )
	@TableField(exist = false)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<CourseTreeEntity> children;

}
