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

## branch
- job 基于51job数据分析
- develop 搜索推荐


## 业务界面
![yw](./img/1.png)
![yw](./img/2.jpg)


## 算法模块
主要使用xgboost回归预测
![xgboost](./img/3.png)

## 分析模块
 pass
