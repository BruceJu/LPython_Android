# LPython_Android

## 概述

> LPython项目的移动端部分，针对LPython_Spider所抓取来的数据进行展示。

* 目前设计了个模块
  * 文档模块 
  * 视频模块
  * 个人中心模块

### 数据部分
* 详细说明
  * 数据源是通过自己编写的分布式采集爬虫[LPython_Spider](https://github.com/BruceJu/LPython_Spider)进行的采集
  * 数据是存储是使用了`leancloud`的云存储功能。
  * 本地数据缓存目前是考虑使用 SQLite进行缓存

### UI结构
 * 搭建整体的试图部分的框架，采用  
    * BottomNavigationBar
    * Fragment
    * CommonTabLayout
    * 嵌套Fragment的结构
    * 支持下来刷新和上拉加载更多  
    * 部分截图
<div style="fload:left,margin:30px,display:inline">
   <img src="https://github.com/BruceJu/LPython_Android/blob/master/LPython_Android/image/index.jpg" width="250" />
   <img src="https://github.com/BruceJu/LPython_Android/blob/master/LPython_Android/image/refresh.jpg" width="250" />
   <img src="https://github.com/BruceJu/LPython_Android/blob/master/LPython_Android/image/vide0.jpg" width="250" />
</div>


    
