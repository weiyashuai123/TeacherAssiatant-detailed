## 第3章 注册与签到（扩展User类以及往数据库中写入数据）（下）
源码:[Demo3点击下载源码](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/src/Demo3sign.zip)</br>
接下来我们来实现一个签到功能：</br>
我们签到需要保存什么信息呢，假设我们签到信息要保存：签到时间、签到用户、签到地点这三个信息.</br>
那么首先创建一个继承自BmobObject的JavaBean用于存放签到信息：</br>
![Sign](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/3.1.png "sign")</br>
为什么没有定义签到时间这个属性呢，因为父类BmobObject中已经有createAt这个属性，用来保存数据的创建时间，我们可以直接拿来用。</br>
接下来在MainActivity中添加一个按钮用于执行签到操作</br>
好了，来看我们签到按钮的点击事件：</br>
使用BmobUser类执行用户登录操作有一个好处是在登录后我们可以在程序中随时调出该用户的信息</br>
![Sign](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/3.2.png "sign")</br>
在这个点击事件里：首先我们通过BmobUser的getCurrentUser方法获取到当前登录的用户</br>
接下来我们new了一个SignInfo对象用于保存签到信息，这里的位置我们先设置为固定，定位服务我们在接下来的章节里使用百度LBS在实现</br>
然后通过save方法保存这个信息.</br>
好了 现在运行一下程序：</br>
![Sign](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/sign.gif "sign")</br>
查看一下后端云数据库：</br>
![Sign](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/3.3.png "sign")</br>
会发现多了一张表。表中存放着我们刚才的签到信息。</br>
好了 到这里 签到的功能就实现了</br>
