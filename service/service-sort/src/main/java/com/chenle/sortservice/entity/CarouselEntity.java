package com.chenle.sortservice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author chenle
 * @email chenle@mail.ynu.edu.cn
 * @date 2022-12-01 14:48:41
 */
@Data
@TableName("carousel")
public class CarouselEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private Integer id;
	/**
	 *
	 */
	private String carouselTitle;
	/**
	 *
	 */
	private String carouselImg;
	/**
	 *
	 */
	private String carouselUrl;
	/**
	 *
	 */
	private String carouselTarget;
	/**
	 *
	 */
	private Integer statusId;
	/**
	 *
	 */
	private Integer sort;

}
