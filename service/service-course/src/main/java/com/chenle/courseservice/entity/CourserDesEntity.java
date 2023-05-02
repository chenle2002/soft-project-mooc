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
 * @date 2022-11-25 09:34:22
 */
@Data
@TableName("courser_des")
@Schema(name="courser_des",description ="课程中章节的实体类" )
public class CourserDesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@Schema(name="id",description ="章节Id" )
	private Integer id;
	/**
	 *
	 */
	@Schema(name="description",description ="章节描述" )
	private String description;
	/**
	 *
	 */
	@Schema(name="sortId",description ="章节分类" )
	private Integer sortId;
	/**
	 *
	 */
	@Schema(name="course_id",description ="章节所属课程的Id" )
	private Integer course_id;

	@Schema(name="teacherId",description ="章节所属课程的教师" )
	private Integer teacherId;
	/**
	 *
	 */
	@Schema(name="name",description ="名称" )
	private String name;

	@Schema(name="image",description ="图片" )
	private String image;

	@Schema(name="pdf",description ="pdf地址" )
	private String pdf;

}
