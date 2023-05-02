package com.chenle.sortservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="CourseList",description ="课程集合" )
public class CourseList{
	@Schema(name="id",description ="课程Id" )
	Integer id;
	@Schema(name="courseName",description ="课程名称" )
	String courseName;
	@Schema(name="courseLogo",description ="课程图片" )
	String courseLogo;
	@Schema(name="rulingPrice",description ="价格" )
	Double rulingPrice;
	@Schema(name="coursePrice",description ="价格" )
	Double coursePrice;
}
