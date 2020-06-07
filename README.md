# es and recommend demo

## 1.Data ready
 Current data is from 51job
 
 ### 1.1API
 > get data api:
 ```$xslt
url: 127.0.0.1:7070/spider/51job?city="cityName"
param: city (require input city name like "杭州")
type:  GET
sucess return: "爬取完成"
```

### swagger地址
http://127.0.0.1:7070/swagger-ui.html#/


### 结构说明
- portal 项目入口(应用层)
- persist 持久层
- etl 爬虫
- common common

### 表模型

> mysql 版本5.5.27

```sql
CREATE TABLE `dwd_spider_corp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(32) NOT NULL COMMENT '详情页url+publish_date md5值',
  `name` varchar(255) NOT NULL COMMENT '公司名',
  `type` varchar(32) DEFAULT NULL COMMENT '公司类型',
  `peoples` varchar(11) DEFAULT NULL COMMENT '人数规模',
  `trade_tag` varchar(255) DEFAULT NULL COMMENT '公司行业标签',
  `info` text COMMENT '公司信息',
  `url` varchar(255) DEFAULT NULL COMMENT '公司url',
  `create_time` datetime DEFAULT NULL,
  `dt` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`(191)) USING BTREE,
  KEY `uuid` (`uuid`(191)) USING BTREE
)


CREATE TABLE `dwd_spider_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(32) NOT NULL COMMENT '详情页url+publish_date md5值',
  `search_key` varchar(11) NOT NULL COMMENT '搜索的关键字',
  `position` varchar(255) NOT NULL COMMENT '招聘的职位',
  `position_peoples` varchar(32) DEFAULT NULL,
  `salary` varchar(32) DEFAULT NULL COMMENT '薪水',
  `salary_type` varchar(7) DEFAULT NULL COMMENT '薪水类型 1:日薪 2:月薪  3:年薪 0:无/面谈',
  `salary_lowest` varchar(32) DEFAULT NULL COMMENT '最低薪资',
  `salary_highest` varchar(32) DEFAULT NULL COMMENT '最高薪资',
  `education` varchar(32) DEFAULT NULL COMMENT '学历要求',
  `experience` varchar(32) DEFAULT NULL,
  `welfare_tag` varchar(128) DEFAULT NULL COMMENT '福利标签',
  `summary_tag` varchar(255) DEFAULT NULL COMMENT '摘要标签',
  `city` varchar(11) NOT NULL COMMENT '城市',
  `city_code` varchar(32) DEFAULT NULL COMMENT '地点编码',
  `city_detail` varchar(32) DEFAULT NULL COMMENT '地点详情',
  `publish_date` varchar(32) DEFAULT NULL COMMENT '发布日期',
  `url` varchar(255) DEFAULT NULL,
  `position_desc` text COMMENT '职位描述',
  `create_time` datetime DEFAULT NULL,
  `dt` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `position` (`position`(191)) USING BTREE,
  KEY `tag` (`summary_tag`(191)) USING BTREE
)


CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `telphone` varchar(40) NOT NULL DEFAULT '',
  `password` varchar(200) NOT NULL DEFAULT '',
  `nick_name` varchar(40) NOT NULL DEFAULT '',
  `gender` int(11) NOT NULL DEFAULT '0',
  `education` int(11) DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `tech_tag` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `city_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `telphone_unique_index` (`telphone`) USING BTREE
) 

```



```sql
// 职位数统计
select position, COUNT(uuid) count from dwd_spider_job GROUP BY position ORDER BY COUNT(uuid) DESC 

// 公司类型职位统计
select type, COUNT(uuid) count from dwd_spider_corp WHERE type IS NOT NULL GROUP BY type ORDER BY COUNT(uuid) DESC;
```

