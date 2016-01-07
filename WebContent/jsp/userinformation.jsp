
<%@page import="com.bluesky.bean.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/pintuer.css"/>
	<link rel="stylesheet" type="text/css" href="../css/manager.css"/>
<%
	Admin admin=(Admin)request.getAttribute("admininfo");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<script type="text/javascript">
	function insurepad(){
		var pw1=document.getElementById("password").value;
		var pw2=document.getElementById("password2").value;
		//alert(pw1);
		if(pw1==pw2){
			//alert(pw1);
			document.getElementById("show").innerHTML="<font color='green'>两次密码相同</font>";
			document.getElementById("save").disabled=false;	
		}else{
			document.getElementById("show").innerHTML="<font color='red'>两次密码不相同</font>";
			document.getElementById("save").disabled=true;
		}
	}

</script>


<script type="text/javascript">
	var xmlHttp=false;
	function createXmlHttpRequest(){
		if(window.XMLHttpRequest){
			xmlHttp=new XMLHttpRequest();
		}else if(window.ActiveXObject){
			try{
				xmlHttp=new ActiveXObject("Msxm12.XMLHTTP");
			}catch(e){
				try{
					xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e){}  
			}
		}
	}
	function onbeclick(id){
		createXmlHttpRequest();
		
		var url="Userinformation?passwdpage=passwdpage&flag=ini&id="+id;
		xmlHttp.onreadystatechange=callback;
		xmlHttp.open("GET", url, true);
		xmlHttp.send();
	}
	
	function callback(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				document.getElementById("passwdpage").innerHTML="";
				document.getElementById("passwdpage").innerHTML=xmlHttp.responseText;
			}
		}
	}
	function checkpw(id){
		createXmlHttpRequest();
		var pw=document.getElementById("inipassword").value;	
		//alert("id"+id);
		var url="Userinformation?passwdpage=checkpasswd&flag=ini&id="+id+"&inipasswd="+pw;
		xmlHttp.onreadystatechange=checkpwback;
		xmlHttp.open("GET", url, true);
		xmlHttp.send();
	}
	function checkpwback(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				var text=xmlHttp.responseText;
				//alert("\""+text+"\""); 
				if("false"==text){
					//alert(text);
					document.getElementById("pwcheck").innerHTML="";
					document.getElementById("pwcheck").innerHTML="密码错误！";
					document.getElementById("save").disabled=true;	
					
				}else{
					document.getElementById("pwcheck").innerHTML="";
					document.getElementById("save").disabled=false;
				}
			}
		}
	}


</script>
</head>
<body>
<center>
	<h1>修改信息</h1>
	<hr>
	<div class="addDiv">
	<form action="Userinformation" method="post" id="form">
	<table class="table table-bordered">
		<tr><th width="25%">姓名：</th>
		<td width="25%"><input type="text" name="username" value="<%=admin.getName()%>"
        onfocus="if(value=='<%=admin.getName()%>'){value=''}"
        onblur="if(value==''){value='<%=admin.getName()%>'}"/>
     	<input type="hidden" name="flag" value="change" />
        <input type="hidden" name="id" value="<%=admin.getId() %>" />
        </td></tr>
        <tr><th width="10%">电话：</th>
		<td width="25%">
		<input type="text" name="telphone" id="telphone" value="<%=admin.getTel()%>"
        onfocus="if(value=='<%=admin.getTel()%>'){value=''}"
        onblur="if(value==''){value='<%=admin.getTel()%>'}"/>
        </td></tr>
        <tr><th width="10%">身份证号：</th>
		<td width="25%">
		<input type="text" name="idcardno"  id="idcardno" value="<%=admin.getIdCardNo()%>"
        onfocus="if(value=='<%=admin.getIdCardNo()%>'){value=''}"
        onblur="if(value==''){value='<%=admin.getIdCardNo()%>'}"/>
        </td></tr>
        <tr><th width="10%">密码为：***</th>
		<td width="25%">
		<a onclick="onbeclick('<%=admin.getId() %>')">修改密码</a>
        </td></tr>
        <tr id="passwdpage">
       <%--  <td  colspan="2" ><p style="margin-left:250px;font-weight:bold;">原始密码：
		<input type="password" name="password" id="inipassword" onblur="checkpw('<%=admin.getId() %>')" AUTOCOMPLETE="off"/><font id="pwcheck" color='red'></font> </p>
		<p style="margin-left:250px;font-weight:bold;">重复密码：
        <input type="password" onkeyup="insurepad()" name="password2" /></p>
        <span id="show"></span></td> --%>
        </tr>
        
		
		<tr><td colspan="2">
		<input type="submit" id="save" value="保存" onclick="checkInput();return false;" class="button bg-sub" style="margin-left:500px;"/>
		<input type="reset" id="cancel" value="取消" class="button bg-sub"/>
		</td></tr>
	</table>
	</form>
	</div>
	<script type="text/javascript">
			function checkInput() {
				if (document.getElementById("password").value == "") {
					alert("请输入密码！");
					document.getElementById("password").focus();
				}else {
					document.getElementById("form").submit();
					alert("修改信息成功！");
				}
			}
	</script>

</body>
</html>