## 第4章 查询数据
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
  多条件我们需要建立一个BmobQuery 的list，往里面加入我们的条件，然后调用BmobQuery对象的and()方法来查询</br>
  有and查询自然有or查询，假设我们现在要查询所有username = "laoshi"或者location = "地球"的签到信息。</br>
  只需要把and改为or既可以了：</br>
  ![query](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/4.5.png "query")</br>
  
* 4）其他条件</br>
  有时候我会需要模糊一点的比较查询：比如在某个时间点之后的数据，包含xxx的数据，以xxx结尾的数据等</br>
  下面有一张我列出query的方法表，有所有查询条件的方法：</br>
  
<table>
	<tr>
		<td>方法名</td>
		<td>示例</td>
		<td>解释</td>
	</tr>
	<tr>
		<td>addWhereEqualTo</td>
		<td>addWhereEqualTo("location","china");</td>
		<td>查询表中location为"china"的数据</td>
	</tr>
	<tr>
		<td>addWhereNotEqualTo</td>
		<td>addWhereNotEqualTo("location","china");</td>
		<td>查询表中location不等于"china"的数据</td>
	</tr>
	<tr>
		<td>addWhereGreaterThan</td>
		<td>addWhereGreaterThan("score",60);</td>
		<td>查询表中score(int)大于60的数据</td>
	</tr>
	<tr>
		<td>addWhereGreaterThanOrEqualTo</td>
		<td>addWhereGreaterThanOrEqualTo("score",60);</td>
		<td>查询表中score(int)大于等于60的数据</td>
	</tr>
	<tr>
		<td>addWhereLessThan</td>
		<td>addWhereLessThan("score",60);</td>
		<td>查询表中score(int)小于60的数据</td>
	</tr>
	<tr>
		<td>addWhereLessThanOrEqualTo</td>
		<td>addWhereLessThanOrEqualTo("score",60);</td>
		<td>查询表中score(int)小于等于60的数据</td>
	</tr>
	<tr>
		<td>addWhereGreaterThan,
		addWhereLessThan</td>
		<td>addWhereGreaterThan("createAt",date);</td>
		<td>特别添加：上述也可用于时间比较</td>
	</tr>
	<tr>
		<td>addWhereExists</td>
		<td>addWhereExists("username");</td>
		<td>查询username有值的数据</td>
	</tr>
	<tr>
		<td>addWhereDoesNotExists</td>
		<td>addWhereDoesNotExists("score");</td>
		<td>查询score为空的数据</td>
	</tr>
</table>
  
  还有一些模糊查询只有付费用户才能用，故此处不列出</br>
  想看更多可以查看官网的开发文档[Bmob开发文档](http://docs.bmob.cn/data/Android/b_developdoc/doc/index.html#查询结果计数)</br>
查询演示图：</br>
![query](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/check.gif "query")</br>
很简单，就不给出界面和代码详解了，有兴趣可以在这里下载源码：</br>
xml布局文件：[activity_check](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/activity_check.xml) 
CheckActivity：[CheckActivity](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/CheckActivity.java)</br>
好了 这章到这里就结束了</br>
