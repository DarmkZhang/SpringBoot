<%@ page language="java" contentType="text/html; charset=UTF-8"%>  
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>User Register Page</title>  
<style type="text/css">  
.error{  
    color: red;   
}  
</style>  
</head>  
  
<body>  
    <%--  
        这里指定页面绑定的对象 modelAttribute. 之前很困惑，  
        为什么<form>上最重要的 <form action="someAction.do">属性没了呢？   
        后来发现，其实在controller中的方法以及指定了地址到method的对应关系，  
        <form>里的action属性就可以退休了。  
    --%>  
    <sf:form method="get" modelAttribute="user">  
        <p>用户注册页面：</p>  
        <table width="60%" align="center">  
            <colgroup>  
                <col width="10%" align="right" />  
                <col />  
            </colgroup>     
            <tr>  
                <th>用户名：</th>  
                <td>  
                    <sf:input path="userName" />  
                    <small>length of userName is not more than 20.</small><br />  
                    <%-- 显示关于userName属性相关的错误信息。 --%>  
                    <sf:errors path="userName" cssClass="error"/>  
                </td>  
            </tr>  
            <tr>  
                <th>密码：</th>  
                <td>  
                    <sf:password path="password" />  
                    <small>length of password is not less than 6.</small><br />  
                    <sf:errors path="password" cssClass="error" />  
                </td>  
            </tr>  
            <tr>  
                <th>邮箱：</th>  
                <td>  
                    <sf:input path="email"/>  
                    <small>format should confirm to general standard.</small><br />  
                    <sf:errors path="email" cssClass="error" />  
                </td>  
            </tr>           
            <tr>  
                <td colspan="2" align="center">  
                    <input type="submit" value="注册" />  
                </td>  
            </tr>  
        </table>  
    </sf:form>  
</body>  
</html>  