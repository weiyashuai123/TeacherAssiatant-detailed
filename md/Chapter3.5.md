## A 自定义drawable-shape（插入章）
xml源码:
[bg_button.xml](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/src/bg_button.xml) ,
[bg_button2.xml](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/src/bg_button2.xml)</br>
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
* Corners 为圆角弧度 只有在shape为矩形的时候有效 矩形会变为圆角矩形，它的属性radius用来设置圆角的大小，除此之外还有四个属性 topleftradius，toprightradius，bottomleftradius，bottomrightradius用来为四个角设置单独的圆角大小。</br>
* gradient 为渐变 它的属性 startcolor为渐变起始颜色，endcolor为终止颜色，angle为角度，默认为水平左到右，90为下到上，270为上到下。他还有一些其他的属性如centercolor（设置中间色）等等 有兴趣可以自己研究下。</br>
* solid为单色填充 他只有一个属性color 用于设置填充色，这里我们用了渐变，所以不再设置填充。</br>
* stroke为描边 属性 color用来设置描边颜色 ，width 用来设置描边宽度 这里我们为了效果明显设置为5dp 一般1dp-2dp足以</br>
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
