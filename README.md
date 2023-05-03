### 法途——法学在线教学管理平台（https://github.com/chenle2002/soft-project-mooc）
> 说明: 这是本项目的后端部分,后台管理系统见(https://github.com/chenle2002/online-mooc-admin),
用户前端见(https://github.com/chenle2002/online-mooc-web)
#### 项目介绍
该项目为云南大学大创校级立项项目，采用微服务架构，包含课程信息、视频点播、人员管理、用户评论等模块,可供用户进行课程信息查看、课程选择、课程章节视频播放、简单评论等功能，并支持管理员对课程信息、视频信息进行管理
（网站：www.sqchenle.top）

#### 主要技术

Vue2,SpringBoot,Spring Cloud,Mysql,Redis,MybatisPlus,Shiro,Docker等

#### 项目亮点

* 项目采用微服务架构开发，各模块耦合程度低，涉及地微服务理念包括服务发现、配置中心、微服务网关、负载均衡等
* 使用Redis完成短信登陆、注册功能，并使用Redis对查询的数据做缓存
* 使用阿里云OSS完成图片、视频、pdf等文件的存储，使用此类数据时直接通过请求进行获取
* 完成对后端返回数据的封装，根据前端所需数据的结构，在后端对数据库数据进行处理后返回前端使用
* 使用gateway根据前端axios请求前缀的不同，进行请求的分发，调用该请求所需要的微服务
* 使用Docker分别对前后端进行部署，可点击www.sqchenle.top 访问管理端
