## 第5章 点名功能的具体实现
接下来我们要实现第一个主要功能-点名，上课老师挨个点名浪费时间？APP来帮你！一键轻松点名~</br>
#### 演示：
* 点名：</br>
  ![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/5.1demo.gif "点名")</br>
* 创建群组：</br>
  ![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/5.2createclass.gif "创建群组")</br>
* 加入群组：</br>
  ![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/5.3joinclass.gif  "加入群组")</br>
* 查看记录：</br>
  ![](https://github.com/weiyashuai123/TeacherAssiatant-detailed/blob/master/image/5.4seerecord.gif "查看记录")</br>
#### 源码：
* 教师端：[TeacherAssiatant](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/src/TeacherAssistant.zip)</br>
* 学生端：[TeacherAssiatant-stu](https://github.com/weiyashuai123/TeacherAssiatant-detailed/raw/master/src/TeacherAssistant_Stu.zip)</br>
* 注：源码为Eclipse工程，为之前所做，与本章内容略有不同，仅供参考。
#### 详解：
* 数据对象：</br>
  SignInfo(签到信息表)：班级名称，教师用户名，学生姓名，学生学号，签到时间，签到地点纬度，签到地点经度;</br>
  Student(学生用户)：学生姓名，学号，密码，班级，学校;</br>
  SignRecord(点名记录)：教师用户名，点名开始时间，点名结束时间，班级名称;</br>
  Teacher(教师用户)：教师姓名，用户名（教工号），密码，学校;</br>
  TeacherClass(班级-教师)：班级名称，教师用户名，学生人数;</br>
  StuClass(班级-学生)：班级名称，学生学号，教师用户名;</br>
  关系：一个学生可以加入多个班级，一个教师可以创建多个班级，一个班级拥有多名学生，一个班级只有一个老师。</br>
* 思路简介：</br>
  可以分为教师端和学生端，也可暂时不分（登录时判断用户，教师与学生进入不同的界面），教师在教师端点击开始点名，学生在学生端点击签到，系统获取学生的信息，添加一条签到信息到数据库，教师点击停止点名，系统获取出签到名单展示给教师。在点名信息里记录一次点名</br>
* 功能步骤化：</br>
  1.教师创建班级（教师）：教师输入班级名称创建班级（教师），系统检查数据库中该名称的班级（教师）是否已存在，系统获取当前的登录用户名（教师用户名），创建班级（教师）。（操作的数据库表：TeacherClass（查询，添加））</br>
  2.学生加入班级：学生条件查询出班级（教师）信息，加入班级，系统获取查询出的班级（教师）信息以及登陆的学生信息，先检测是否已加入，然后在班级（学生）表中创建一个新的班级（学生）。（操作的数据库表：TeacherClass（查询），StuClass（查询，添加））</br>
  3.教师选择班级：从云数据库中根据教师用户名查出所有当前教师创建的班级。教师选择一个班级。（操作的数据库表：TeacherClass（查询））</br>
  4.教师开始点名：系统记录开始点名时间。（不操作数据库）.</br>
  5.学生选择班级：从云数据库中根据学生用户名（学号）查出所有当前学生加入的班级。学生选择一个班级。（操作的数据库表：StuClass（查询））</br>
  6.学生进行签到：学生点击签到，系统获取学生的信息及签到地点、签到时间，添加一条签到信息到SignInfo表。（操作的数据库表：SignInfo（添加））</br>
  7.教师结束点名：系统记录结束点名时间，向SignRecord表中添加一条数据（操作的数据库表：SignRecord（添加））。</br>
  8.系统显示本次名单：查询当前班级在开始点名时间的结束点名时间中间的签到信息（操作的数据库表：SignInfo（查询））。</br>
  到这里我们的点名功能就完全实现了，我们还可以返回来查历史记录，由于每条记录都有开始和结束时间，所以可以从SignInfo表中查出该记录签到的信息。</br>
* 注：一些疑点：</br>
** 看起来好像有两个班级表，是这样的，班级功能只用一个Class表对于教师管理班级的实现会很复杂，由于一个学生可以加入多个班级，一个班级拥有多名学生，而一个班级只有一个老师。有兴趣也可以自己研究研究关系，看用一个表实现会怎么样.</br>

** 班级,点名记录的唯一性，班级由教师和班级名称确定，一个教师是不能创建两个名称一样的班级的，这样就确保了班级的唯一。点名记录的唯一，一个学生，一个教师，或者一个班级在同一时间段只能上一节课，所以点名记录跟签到信息表是唯一对应的。
  
