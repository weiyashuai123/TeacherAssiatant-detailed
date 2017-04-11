## 第二章 注册与签到（扩展User类以及往数据库中写入数据）（上）
源码:[Demo2点击下载源码](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/Demo2Register.zip)</br>
首先我们来对User类来进行扩展，假设我们需要给教师用户添加一个“性别”属性.</br>
建立一个teacher类继承自BmobUser：</br>
`public class Teacher extends BmobUser{}`</br>
在类中写入我们新建的属性：</br>
`private String sex;`</br>
重写构造器并设置set，get方法：</br>
![Teacher](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/2.2.png "teacher")</br>
我们简单的扩展已经完成，接下来我们实现注册功能：</br>
注册界面不说了，两个edittext用于输入用户名与密码，radiobutton用于选择性别，一个button用于注册</br>
![Register](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/2.4.png "register")</br>
直接来介绍注册按钮的点击事件：</br>
![Register](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/2.3.png "register")</br>
new一个Teacher对象 设置其用户名密码性别，然后调用sign up方法，好的到这里注册功能就实现了，我们来运行一下：</br>
![Register](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/regis.gif "register")</br>
打开我们的Bmob后台数据库表可以看到刚才注册的用户：</br>
![Register](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/2.5.png "register")</br>
