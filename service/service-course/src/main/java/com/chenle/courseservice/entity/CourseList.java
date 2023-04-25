package com.chenle.courseservice.entity;

import lombok.Data;

@Data
public class CourseList{
	Integer id;
	String courseName;
	String courseLogo;
	Double rulingPrice;
	Double coursePrice;
}
