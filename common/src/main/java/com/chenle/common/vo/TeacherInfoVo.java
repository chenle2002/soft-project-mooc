package com.chenle.common.vo;

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
public class TeacherInfoVo {
    private Integer id;
    private String lecturerName;
    private String lecturerMobile;
    private String lecturerPosition;
    private String lecturerHead;
    private String introduce;
}
