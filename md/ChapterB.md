## B 数据删除与修改
  关于对Bmob数据库中的数据，首先明确其均为BmobObject，皆由ObjectId来唯一标示，修改删除操作都是基于这个Objectid。所以删除（修改）数据有两种方法：</br>
  1. 直接从数据库中查出数据，对其进行操作。</br>
  2. new一个数据对象，设置其Objectid，对其进行操作。</br>
* 修改
  调用Bmobobject对象的 .update()方法.示例：</br>
  在数据库获取BmobObject对象后，通过对象的.set方法修改其属性，然后调用.update方法提交修改：</br>
        
	
	
	
	
          
                      BmobUser user = getUser()//getUser()方法是在这里自定义的方法，会获取到当前登录的User
                      user.setUserName("newname");
		      user.setPassWord("newpass");
		      user.update(new UpdateListener() {
			
			           @Override
			        public void done(BmobException e) {
			          	// TODO Auto-generated method stub
			       	if (e==null) {
					    toast("更新成功");
				      } else {
					    toast("错误："+e.getMessage());
				      }
			      }
	      	});
          
* 删除
  直接调用Bmobobject对象的.delete()方法.示例：</br>
        
          
                          BmobUser user = getUser("7a310bcc6e");
                          //getUser(String id)方法为自定义方法，会从数据库获取到ojectid为7a310bcc6e的数据对象
		          user.delete(new UpdateListener() {
			
			           @Override
			        public void done(BmobException e) {
			          	// TODO Auto-generated method stub
			       	if (e==null) {
					    toast("删除成功");
				      } else {
					    toast("错误："+e.getMessage());
				      }
			      }
	      	});
          
