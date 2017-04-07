# TeacherAssiatant详解：教你如何一步一步的实现功能
1. 登录功能（如何使用云服务实现联网登录）</br>
    首先我们需要使用移动云服务来储存数据.打开Bmob官网：[http://www.bmob.cn/](http://www.bmob.cn/) 注册一个账号并登陆</br>
    在右上角点开我的控制台，创建一个应用。</br>
    在左下角点开设置。可以看到我们的application id 一会会用到这个</br>
    现在我们建立一个工程，创建两个Activity LoginActivity和MainActivity 两个layout（布局文件）activity_main 和 activity_login.</br>
    并在login的布局中添加两个编辑框用于用户输入用户名和密码.一个登陆按钮用于登录操作</br>
    现在我们先来配置一下刚才云服务的SDK.在 Project 的 build.gradle 文件中添加 Bmob 的maven仓库地址：</br>
    `allprojects { </br>
        repositories {</br>
        jcenter()</br>
        maven { url "https://raw.github.com/bmob/bmob-android-sdk/master" }</br>
        }</br>
        }`
    在app的build.gradle文件中添加compile依赖文件</br>
    `android {</br>
        compileSdkVersion 25</br>
        buildToolsVersion '25.0.0'</br>
        useLibrary 'org.apache.http.legacy'</br>
        }</br>
    dependencies {</br>
        compile fileTree(dir: 'libs', include: ['*.jar'])</br>
        compile 'cn.bmob.android:bmob-sdk:3.5.0'</br>
    }`
