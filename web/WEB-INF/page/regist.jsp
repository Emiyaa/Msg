<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<jsp:include page="/js/resource/easyui.jsp"></jsp:include>
</head>
<body>
	<center>
									<!-- 在此处添加注册失败提示信息 -->
		<h4><font color="red">${reg_message }</font></h4>							
			<div class="easyui-panel" title="注 册" style="width:400px">
				<div style="padding:10px 60px 20px 60px">
				
			    					<!-- 在此处添加注册表单 -->
			    <form id="form" action="${pageContext.request.contextPath }/RegistAction" method="post">					
			    	<table cellpadding="5" align="center">
			    		<tr>
			    			<td>用户名:</td>
			    			<td><input class="easyui-textbox" name="userName" required="true" 
			    			validType="length[1,16]" maxLength="16" value="${userName }"></td>
			    		</tr>
			    		<tr>
			    			<td>昵称:</td>
			    			<td><input class="easyui-textbox" name="userNickName" required="true" 
			    			validType="length[1,16]" maxLength="16" value="${userNickName }"></td>
			    		</tr>
			    		<tr>
			    			<td>密码:</td>
			    			<td><input class="easyui-textbox" type="password" name="userPassword" 
			    			required="true" validType="length[1,16]" maxLength="16"></td>
			    		</tr>
			    		<tr>
			    			<td>生日:</td>
			    			<td><input class="easyui-datebox" name="userBirthday" required="true" 
			    			validType="md[\'2015-1-1\']" value="${userBirthday }"></td>
			    		</tr>
			    		<tr>
			    			<td>手机:</td>
			    			<td><input class="easyui-textbox" name="userMobile" data-options="required:true" 
			    			validType="mobile" value="${userMobile }"></td>
			    		</tr>
			    		<tr>
			    			<td>邮箱:</td>
			    			<td><input class="easyui-textbox" name="userMail" data-options="required:true" 
			    			validType="email" value="${userMail }"></td>
			    		</tr>
			    	</table>
			    </form>	
			    <div style="text-align:center;padding:5px">
			    	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" 
			    	style="width:25%;height:22px" onclick="document.getElementById('form').submit();return false">提 交</a>
			    </div>
			</div>
		</div>
	</center>
	
									<!-- 在此处添加验证手机号码的js -->
	<script type="text/javascript" charset="utf-8" src="js/checkMobile.js"></script>
</body>
</html>