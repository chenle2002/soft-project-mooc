package com.chenle.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * "id":"1064776676173942786",
 * "lecturerName":"领课",
 * "lecturerMobile":"13800138001",
 * "lecturerPosition":"提供在线教育解决方案",
 * "lecturerHead":"https://file.roncoos.com/education/education/765d471f0e314f64a7d35fc0b39295e0.png",
 * "introduce":"<p>  领课网络（全称：广州市领课网络科技有限公司）作为一家软件科技企业，致力于为客户提供专业化的软件产品技术解决方案。公司成立于2016年，是通过国家认定的高新技术企业。<span style=\"color: var(--el-text-color-regular); text-align: initial;\">核心软件产品有：在线教育系统、支付结算系统、会务系统、直播系统。以不断迭代创新的核心软件产品为基础，为客户提供高品质的教育系统定制开发服务、教育系统SaaS服务、支付结算系统开发服务、会务系统开发服务等。</span></p>"
 */
@Data
@Schema(name="TeacherInfoVo",description ="教师信息封装" )
public class TeacherInfoVo {
    @Schema(name="id",description ="教师Id" )
    private Integer id;
    @Schema(name="lecturerName",description ="教师名" )
    private String lecturerName;
    @Schema(name="lecturerMobile",description ="教师电话" )
    private String lecturerMobile;
    @Schema(name="lecturerPosition",description ="教师简介" )
    private String lecturerPosition;
    @Schema(name="lecturerHead",description ="图片" )
    private String lecturerHead;
    @Schema(name="introduce",description ="教师介绍" )
    private String introduce;
}
