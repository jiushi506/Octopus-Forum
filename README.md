## [在线地址](http://www.zykcoderman.xyz)

## 章鱼论坛
**暑假最近刚刚接触SpringBoot，感觉SpringBoot比起SSM大大的简化了配置，我们不需要向之前搭建SSM的环境啥的，SpringBoot的核心就是自动配置吧，因此写了一个简单的社区，现在项目已经部署上线，想要学习这个项目的可以来看看哟~。**

## 资料
[Spring 文档](https://spring.io/guides)   
[Spring Web文档](https://spring.io/guides/gs/serving-web-content/)  
[es社区](https://elasticsearch.cn/explore)  
[GitHub deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)  
[BootStrap 文档](https://v3.bootcss.com/getting-started/)  
[GitHub OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)  
[菜鸟教程](https://www.runoob.com/)    
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)    
[Spring Dev Tool](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#using-boot-devtools)  
[Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html)  
[Markdown 插件](http://editor.md.ipandao.com/)   
[UFfile SDK](https://github.com/ucloud/ufile-sdk-java)  
[Count(*) VS Count(1)](https://mp.weixin.qq.com/s/Rwpke4BHu7Fz7KOpE2d3Lw)  

## 工具
[Git](https://git-scm.com/downloads)  
[Visual Paradigm](https://www.visual-paradigm.com/cn/)      
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)     
[lombok](https://projectlombok.org/)  
[ctotree](https://www.octotree.io/)  
[Table of content sidebar](https://chrome.google.com/webstore/detail/table-of-contents-sidebar/ohohkfheangmbedkgechjkmbepeikkej)            
[One Tab](https://chrome.google.com/webstore/detail/chphlpgkkbolifaimnlloiipkdnihall)         
[Live Reload](https://chrome.google.com/webstore/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei/related)         
[Postman](https://chrome.google.com/webstore/detail/coohjcphdfgbiolnekdpbcijmhambjff)          
[LiveReload](https://chrome.google.com/webstore/detail/livereload/jnihajbhpnppcggbcgedagnkighmdlei)

## 技术栈
1. 使用SpringBoot,Maven管理项目的依赖。
2. Mybatis持久层,Spring,Springmvc,Thymeleaf模板引擎。
2. 前端使用UI框架：BootStrap框架，Jquery库，flatui主题
3. 数据库使用MySql。
4. 开发坏境JDK1.8,IDEA集成环境，Sqlyog可视化工具
5. 适合人群：刚接触springboot，暂无项目经验的同鞋。（话不多少开始项目吧）
6.  项目参考哔哩哔哩SpringBoot论坛（码匠社区），在原有的基础下，添加了许多的功能。
7.  Ajax来处理前后端交互，页面多处使用异步请求。
## 功能
1.登入使用github授权登入，QQ授权，百度账号授权登入，等一系列的oauth2.（考虑到大家登入的方便因此采用这种方式比较好）
2. 提问，选中问题分类，选择问题的标签，可以将问题加入一个话题，这样就能让大家更容易的找到你的问题。
3.发起问题使用的基于markdown语法（使用editormd前端插件）
4. 评论问题，回复问题
5. 点赞包括（点赞问题,点赞评论）
6.通知功能:点赞通知和回复通知，关注通知
6. 搜索功能
7. 按问题的分类查询
8. 按时间热度查询
9. 热门标签，以及热门标签查询(springboot定时任务的使用)
10. 相关问题  
11. 1小内自动登入。
12. 退出登入
12. 我的问题（CRUD）
13. 关注好友，取消关注，好友问题。查看我的粉丝，我收藏的问题。
14. 收藏问题。
15. 话题模块。创建问题的时候可以加入话题，关注话题，相关话题。
16. 网站聊天室。
17. 网站广告管理
还有一些小功能就不具体说了,,如果你也是刚接触SpringBoot可以用这个项目练练手
(做的不是很好请见谅!!!嘻嘻嘻)
## 部署
1. 服务器：阿里云ESC云服务器。
2. 图片上传：阿里OSS对象存储。

## 数据库脚本

```sql
问题表
CREATE TABLE `question` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `description` text CHARACTER SET utf8,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `comment_count` int(10) DEFAULT '0',
  `view_count` int(10) DEFAULT '0',
  `like_count` int(10) DEFAULT '0',
  `tag` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `creator` int(10) DEFAULT NULL,
  `category` int(10) DEFAULT NULL COMMENT '分类',
  `topic` int(10) DEFAULT NULL COMMENT '属于的话题',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=258 DEFAULT CHARSET=utf8mb4
用户表
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `token` char(36) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `avatar_url` varchar(100) DEFAULT NULL,
  `bio` varchar(120) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8
通知表
CREATE TABLE `notification` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `notifier` bigint(20) DEFAULT NULL,
  `receiver` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `outter_id` int(11) DEFAULT NULL COMMENT '外键,关联问题或评论',
  `gmt_create` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '通知的状态,已读未读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=510 DEFAULT CHARSET=utf8

关注用户表
Create Table
CREATE TABLE `follow` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `followed_user` int(10) DEFAULT NULL,
  `status` int(3) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8

Create Table

CREATE TABLE `collect` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `question_id` int(10) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4
问题点赞表
Create Table
CREATE TABLE `question_zan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(100) DEFAULT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4
广告表
Create Table

CREATE TABLE `ad` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) DEFAULT NULL,
  `url` varchar(512) DEFAULT NULL,
  `image` varchar(256) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `gmt_start` bigint(20) DEFAULT NULL,
  `gmt_end` bigint(20) DEFAULT NULL,
  `status` int(20) DEFAULT NULL,
  `postion` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4
话题表
CREATE TABLE `topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `talk_count` bigint(20) DEFAULT NULL,
  `follow_count` int(100) DEFAULT NULL,
  `image` varchar(10000) DEFAULT NULL,
  `simple_desc` varchar(256) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `status` int(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4
问题收藏表
Create Table

CREATE TABLE `collect` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `question_id` int(10) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4

```




# 演示

![主页](https://img-blog.csdnimg.cn/20190825102842870.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjU3MTAz,size_16,color_FFFFFF,t_70)
![我的问题](https://img-blog.csdnimg.cn/20190825102834306.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjU3MTAz,size_16,color_FFFFFF,t_70)
![我的通知](https://img-blog.csdnimg.cn/20190825102821883.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjU3MTAz,size_16,color_FFFFFF,t_70)
![项目展示](https://img-blog.csdnimg.cn/20190825100402717.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjU3MTAz,size_16,color_FFFFFF,t_70)
![我的关注](https://img-blog.csdnimg.cn/20190825100441317.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjU3MTAz,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190825100451284.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjU3MTAz,size_16,color_FFFFFF,t_70)


如果项目不能访问可能是正在更新可以添加
楸楸（QQ）：3053161401

**最后感谢大家，共同学习，共同进步吧，冲鸭~~~~**
