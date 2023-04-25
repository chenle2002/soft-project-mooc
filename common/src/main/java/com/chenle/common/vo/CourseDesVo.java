package com.chenle.common.vo;

import lombok.Data;

/**
 * "allowStudy":0,
 * "id":"1080759557655564289",
 * "gmtCreate":"2019-01-03 17:50:26",
 * "gmtModified":"2022-09-29 14:42:52",
 * "courseName":"领课教育系统",
 * "courseLogo":"http://static.roncoos.com/os/001.jpg",
 * "introduce":"<h4><img src=\"https://www.roncoo.net/_nuxt/img/san01.310ef3c.png\" alt=\"在线教育平台系统搭建\" style=\"color: var(--el-text-color-regular); text-align: initial;\"/><br/></h4><br/>",
 * "isFree":0,
 * "rulingPrice":100000,
 * "coursePrice":100000,
 * "countBuy":1024,
 * "countStudy":8888,
 * "categoryId":"1248244148498632705",
 * "lecturerId":"1064776676173942786",
 * "lecturerResp":{
 * "id":"1064776676173942786",
 * "lecturerName":"领课",
 * "lecturerMobile":"13800138001",
 * "lecturerPosition":"提供在线教育解决方案",
 * "lecturerHead":"https://file.roncoos.com/education/education/765d471f0e314f64a7d35fc0b39295e0.png",
 * "introduce":"<p>  领课网络（全称：广州市领课网络科技有限公司）作为一家软件科技企业，致力于为客户提供专业化的软件产品技术解决方案。公司成立于2016年，是通过国家认定的高新技术企业。<span style=\"color: var(--el-text-color-regular); text-align: initial;\">核心软件产品有：在线教育系统、支付结算系统、会务系统、直播系统。以不断迭代创新的核心软件产品为基础，为客户提供高品质的教育系统定制开发服务、教育系统SaaS服务、支付结算系统开发服务、会务系统开发服务等。</span></p>"
 * }
 */
@Data
public class CourseDesVo {
    private TeacherInfoVo lecturerResp;

    private String allowStudy;//0,
    private String id;//1080759557655564289,
    private String gmtCreate;//2019-01-03 17;//50;//26,
    private String gmtModified;//2022-09-29 14;//42;//52,
    private String courseName;//领课教育系统,
    private String courseLogo;//http;////static.roncoos.com/os/001.jpg,
    private String introduce;//<h4><img src=\https;////www.roncoo.net/_nuxt/img/san01.310ef3c.png\ alt=\在线教育平台系统搭建\ style=\color;// var(--el-text-color-regular); text-align;// initial;\/><br/></h4><br/>,
    private String isFree;//0,
    private String rulingPrice;//100000,
    private String coursePrice;//100000,
    private String countBuy;//1024,
    private String countStudy;//8888,
    private String categoryId;//1248244148498632705,
    private String lecturerId;//1064776676173942786,
    private String pdf;//1064776676173942786,
}
