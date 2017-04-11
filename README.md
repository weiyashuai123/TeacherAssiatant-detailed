# TeacherAssiatant详解：教你如何一步一步的实现功能
## 1 登录功能（如何使用云服务实现联网登录）</br>
    源码:[loginDemo点击下载源码](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/LoginDemo.zip)</br>
    首先我们需要使用移动云服务来储存数据.打开Bmob官网：[http://www.bmob.cn/](http://www.bmob.cn/) 注册一个账号并登陆</br>
    在右上角点开我的控制台</br>
    ![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/0.png "bmob")</br>
    创建一个应用:</br>
    ![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/6.png "bmob")
    ![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/1.png "bmob")</br>
    在数据中可以看到我们的数据库表 系统一般会默认创建一个 User表 </br>
    我们现在先往这个表中添加一条数据 </br>
    点击添加行 添加一条用户名为teacher.密码为123456的用户（注意这个objectid 不要填写 是自动生成的）</br>
    ![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/5.png "bmob")</br>
    在左下角点开设置:</br>
    可以看到我们的application id 一会会用到这个![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/3.png "bmob")</br>
    现在我们建立一个工程，创建两个Activity LoginActivity和MainActivity 两个layout（布局文件）activity_main 和 activity_login.</br>
    并在login的布局中添加两个编辑框用于用户输入用户名和密码.一个登陆按钮用于登录操作</br>
    现在我们先来配置一下刚才云服务的SDK</br>在 Project 的 build.gradle 文件中添加 Bmob 的maven仓库地址：</br>
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
    `}`</br>
   在minifest中声明以下权限：</br>
`<uses-permission android:name="android.permission.INTERNET" /> `</br>
`<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" /> `</br>
`<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" /> `</br>
`<uses-permission android:name="android.permission.WAKE_LOCK" /> `</br>
`<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />`</br>
`<uses-permission android:name="android.permission.READ_PHONE_STATE" />` </br>
   好的 现在我们来实现登陆 在LoginActivity的oncreate中加入：Bmob.initialize(this, "Application ID");</br>
   这里的Application id 就是你刚才创建的应用的application id;</br>
   我们继续在 按钮的点击事件中写入登陆事件</br>
    ![s](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/4.png "bmob") </br>
   好的 现在运行一下程序 可以看到已经实现了登陆功能 </br>
    ![s](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/logindemo.gif "bmob")</br>
## 2 注册与签到（扩展User类以及往数据库中写入数据）（上）
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
## 3 注册与签到（扩展User类以及往数据库中写入数据）（下）
  源码:[Demo3点击下载源码](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/Demo3sign.zip)</br>
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
## 3.5 简单自定义drawable（插入章）
  xml源码:
  [bg_button.xml](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/bg_button.xml) ,
  [bg_button2.xml](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/bg_button2.xml)</br>
  首先来看几个图片：</br>
  ![shape](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/3.5.7.png "shape")</br>
  圆形的和带弧度按钮可不是找的图片哦，而是我们自己写的xml背景文件</br>
  先来介绍一下最简单的————shape：</br>
  找到res资源文件夹 右击里面的drawable 选择new-draw resource file</br>
  ![shape](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/3.5.1.png "shape")</br>
  在Root element中输入shape 在file name中输入文件名称（我这里叫bg_button）</br>
  ![shape](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/3.5.2.png "shape")</br>
  ![shape](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/3.5.5.png "shape")</br>
  这是一个圆形背景的资源，我们来一一介绍每个属性：</br>
  其中shape 为图形 有四种可以选择：line-直线，rectangle-矩形，oval-椭圆(圆是特殊的椭圆哟)，ring——环.可以看到我们这里是选择椭圆</br>
   ![shape](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/3.5.3.png "shape")</br>
  Corners 为圆角弧度 只有在shape为矩形的时候有效 矩形会变为圆角矩形，它的属性radius用来设置圆角的大小，除此之外还有四个属性 topleftradius，toprightradius，bottomleftradius，bottomrightradius用来为四个角设置单独的圆角大小。</br>
  gradient 为渐变 它的属性 startcolor为渐变起始颜色，endcolor为终止颜色，angle为角度，默认为水平左到右，90为下到上，270为上到下。他还有一些其他的属性如centercolor（设置中间色）等等 有兴趣可以自己研究下。</br>
  solid为单色填充 他只有一个属性color 用于设置填充色，这里我们用了渐变，所以不再设置填充。</br>
  stroke为描边 属性 color用来设置描边颜色 ，width 用来设置描边宽度 这里我们为了效果明显设置为5dp 一般1dp-2dp足以</br>
  接下来在设置背景 在Button 中设置background为@drawable/资源文件名</br>
  ![shape](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/3.5.6.png "shape")</br>
  好的 这样我们就成功地自己写了一个背景图片，yeah~</br>
  接下来讲一下颜色 Android 颜色有四种：（注：这里的数字都是16进制数字0-f代表 0 - 15）</br>
<table>
	<tr>
		<td>通道</td>
		<td>格式</td>
		<td>示例</td>
	</tr>
	<tr>
		<td>16位低精度三通道</td>
		<td>#RGB</td>
		<td>#F00（红色）</td>
	</tr>
	<tr>
		<td>16位低精度四通道</td>
		<td>#ARGB</td>
		<td> #FF00（不透明红色）#8F00（半透明红色）#0F00（纯透明红色）</td>
	</tr>
	<tr>
		<td>128位高精度三通道  </td>
		<td> #RRGGBB </td>
		<td> #FF0000（红色） #00FF00（绿色） </td>
	</tr>
	<tr>
		<td> 128位高精度四通道</td>
		<td>  #AARRGGBB  </td>
		<td> #FFFF0000（不透明红色）</td>
	</tr>
</table>
  关于配色我这里有个不错的网站：[http://tool.c7sky.com/webcolor/](http://tool.c7sky.com/webcolor/)</br>
  好，这章就到这里。</br>
## 4 查询数据
  运用数据库最重要的就是查询数据了，之前说了保存数据以及BmobUser类的使用这章我们来讲讲如何查询数据</br>
  首先我给之前建立的数据表SignInfo从后台插入了几条数据 用于我们对查询操作的详解.插完之后大概张这个样子：</br>
  ![query](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/4.1.png "query")</br>
  * 1）查询一个表中的所有数据</br>
  来看如何查询所有数据，假设我们要查询SignInfo表中的所有数据，我们就可以这样写：</br>
  ![query](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/4.2.png "query")</br>
  可以看到我们直接new了一个BmobQuery对象，然后调用了它的find方法，在它的find方法中有一个监听器的回调事件</br>
  在监听器的回调中，list就是返回的所有数据.</br>
  * 2）单条件查询</br>
  假设我们现在要查询所有位置为'火星'的签到信息，我们就可以这样写：</br>
  ![query](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/4.3.png "query")</br>
  可以看到我们加了一句话query.addWhereEqualTo("location","火星");</br>
  这个方法中有两个参数第一个参数用来指定查询的列名，第二个参数用来查询指定的值。</br>
  这句话的意思就是查询SignInfo表中所有location = "火星"的数据</br>
  * 3）多条件查询</br>
  假设我们要查询所有username = "laoshi"并且location = "地球"的签到信息，我们就可以这样写：</br>
  ![query](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/4.4.png "query")</br>
  有点复杂 多条件我们需要建立一个BmobQuery 的list 往里面加入我们的条件，然后调用BmobQuery对象的and()方法来查询</br>
  有and查询自然有or查询，假设我们现在要查询所有username = "laoshi"或者location = "地球"的签到信息。</br>
  只需要把and改为or既可以了：</br>
  ![query](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/4.5.png "query")</br>
  * 4）其他条件</br>
  有时候我会需要模糊一点的比较查询：比如在某个时间点之后的数据，包含xxx的数据，以xxx结尾的数据等</br>
  下面有一张我列出query的方法表，有所有查询条件的方法：</br>
  查询演示图：</br>
  ![query](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/check.gif "query")</br>
  很简单，就不给出界面和代码详解了，有兴趣可以在这里下载源码：</br>
  xml布局文件：[activity_check](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/activity_check.xml) 
  CheckActivity：[CheckActivity](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/CheckActivity.java)</br>
  好了 这章到这里就结束了</br>
