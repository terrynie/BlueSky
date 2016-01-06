<%@page import="com.bluesky.bean.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	Admin admin=(Admin)request.getAttribute("admininfo");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<script type="text/javascript">
	function insurepad(){
		var pw1=document.getElementById("password").value;
		var pw2=document.getElementById("password2").value;
		alert(pw1);
		if(pw1==pw2){
			alert(pw1);
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
		var id=<%=admin.getId() %>;
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



</script>
</head>
<body>
<form class="" action="Userinformation" method="get">
<table  width="476" height="328" border="0">
  <tr>
    <th width="165" scope="row">姓名：</th>
    <td width="190">
      <label>
        <input type="text" name="username" value="<%=admin.getName()%>"/>
     	<input type="hidden" name="flag" value="change" />
        <input type="hidden" name="id" value="<%=admin.getId() %>" />
        </label>
    </td>
  </tr>
  <tr>
    <th scope="row">电话：</th>
    <td>
      <label>
        <input type="text" name="telphone" value="<%=admin.getTel()%>"/>
        </label>
    </td>
  </tr>
  <tr>
    <th scope="row">身份证号：</th>
    <td>
      <label>
        <input type="text" name="idcardno" value="<%=admin.getIdCardNo()%>"/>
      </label>
    </td>
  </tr>
  <tr>
    <th scope="row">密码为：***</th>
    <td><a onclick="onbeclick('<%=admin.getId()%>')">修改密码</a></td>
  </tr>
  <tr id="passwdpage">
        
  </tr>
  <tr>
    <th scope="row"><input type="submit" name="save" value="保存" /></th>
    <td><input type="reset" name="cancel" value="取消" /></td>
  </tr>
</table>
</form> 
</body>
</html>