
搭建struts2的工程环境的步骤：

1、找到struts-blank.war

2、添加相关的jar包到工程lib下

3、修改工程的web.xml(添加一个过滤器)
		
		<filter>
			<filter-name>struts2</filter-name>
			<filter-class>xxxx.StrutsPrepareAndExecuteFilter</filter-class>
		</filter>
		<filter-mapping>
			<filter-name>struts2</filter-name>
			<url-pattern>/*</url-pattern>
		</filter-mapping>
		
4、将struts的主配置放置到src下(放置到类路径之下)
	注意点：主配置的文件名不要修改,使用struts.xml(大小写也不能修改，最好从别的工程复制过来即可)
	
	
5、新建一个简单的登录页面
	确认表单提交的action参数
	这个就是我之前提过的，一切以页面为起源
	
6、创建了一个普通POJO类

	> 根据前台表单控件的name设置成员变量
	> 设置getter/setter方法
	> 创建一个普通方法:a 必须是public b 这个必须不带形参 c 返回值必须是String 
	
7、在struts的主配置文件配置POJO类	

		<!-- 在同一个包下action的name不能重复 class属性里面写的是这个类的全限定名(包名+类名) -->
    	<!-- method属性是指调用UserAction中的哪个方法 -->
		<action name="login" class="com.action.UserAction" method="login">
			<result name="success">welcome.jsp</result>
			<result name="error">error.jsp</result>
		</action>
		
8、创建welcome.jsp和error.jsp
		>从session域中获取用户名
	
