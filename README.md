# TeacherAssiatant详解：教你如何一步一步的实现功能
1. 登录功能（如何使用云服务实现联网登录）</br>
    首先我们需要使用移动云服务来储存数据.打开Bmob官网：[http://www.bmob.cn/](http://www.bmob.cn/) 注册一个账号并登陆</br>
    在右上角点开我的控制台，创建一个应用。
    ![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/0.png "bmob")
    ![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/1.png "bmob")</br>
    在数据中可以看到我们的数据库表 系统一般会默认创建一个 User表 </br>
    我们现在先往这个表中添加一条数据 点击添加行 添加一条用户名为teacher.密码为123456的用户</br>
    在左下角点开设置:![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/2.png "bmob")可以看到我们的application id 一会会用到这个![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/3.png "bmob")</br>
    现在我们建立一个工程，创建两个Activity LoginActivity和MainActivity 两个layout（布局文件）activity_main 和 activity_login.</br>
    并在login的布局中添加两个编辑框用于用户输入用户名和密码.一个登陆按钮用于登录操作</br>
    现在我们先来配置一下刚才云服务的SDK.在 Project 的 build.gradle 文件中添加 Bmob 的maven仓库地址：</br>
    `allprojects { `</br>
        `  repositories {`</br>
        `  jcenter()`</br>
        `  maven { url "https://raw.github.com/bmob/bmob-android-sdk/master" }`</br>
        `  }`</br>
        `  }`</br>
    在app的build.gradle文件中添加compile依赖文件</br>
    `android {`</br>
       `  compileSdkVersion 25`</br>
       `  buildToolsVersion '25.0.0'`</br>
       `  useLibrary 'org.apache.http.legacy'`</br>
        ` }`</br>
    `dependencies `{</br>
       `  compile fileTree(dir: 'libs', include: ['*.jar'])`</br>
       `  compile 'cn.bmob.android:bmob-sdk:3.5.0'`</br>
    `}`
   在minifest中声明一下网络权限：</br>
<!--允许联网 --> 
`<uses-permission android:name="android.permission.INTERNET" /> `
<!--获取GSM（2g）、WCDMA（联通3g）等网络状态的信息  --> 
`<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /> `
<!--获取wifi网络状态的信息 --> 
`<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" /> `
<!--保持CPU 运转，屏幕和键盘灯有可能是关闭的,用于文件上传和下载 -->
`<uses-permission android:name="android.permission.WAKE_LOCK" /> `
<!--获取sd卡写的权限，用于文件上传和下载-->
`<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />`
<!--允许读取手机状态 用于创建BmobInstallation--> 
`<uses-permission android:name="android.permission.READ_PHONE_STATE" />` </br>
   好的 现在我们来实现登陆 在LoginActivity的oncreate中加入：Bmob.initialize(this, "Application ID");</br>
   这里的Application id 就是你刚才创建的应用的application id;</br>
   我们继续在 按钮的点击事件中写入登陆事件</br>
    ![s](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/4.png "bmob") </br>
   好的 现在运行一下程序 可以看到已经实现了登陆功能 </br>
    ![s](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/logindemo.gif "bmob")</br>
