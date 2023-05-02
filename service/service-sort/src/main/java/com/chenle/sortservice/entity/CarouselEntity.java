package com.chenle.sortservice.entity;

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
 * @date 2022-12-01 14:48:41
 */
@Data
@TableName("carousel")
@Schema(name="carousel",description ="轮播图实体类" )
public class CarouselEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@Schema(name="id",description ="轮播图Id" )
	private Integer id;
	/**
	 *
	 */
	@Schema(name="carouselTitle",description ="轮播图名称" )
	private String carouselTitle;
	/**
	 *
	 */
	@Schema(name="carouselImg",description ="轮播图图片" )
	private String carouselImg;
	/**
	 *
	 */
	@Schema(name="carouselUrl",description ="轮播图转向地址" )
	private String carouselUrl;
	/**
	 *
	 */
	@Schema(name="carouselTarget")
	private String carouselTarget;
	/**
	 *
	 */
	@Schema(name="statusId",description ="轮播图状态" )
	private Integer statusId;
	/**
	 *
	 */
	@Schema(name="sort",description ="轮播图分类" )
	private Integer sort;

}
