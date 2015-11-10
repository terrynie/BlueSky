<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>添加巡检</title>
    <style type="text/css">
        b {
            margin-left: 20%;
        }
        ul{
            margin-top: 5%;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="css/manage.css" type="text/css">
    <link rel="stylesheet" href="css/addConstruction.css" type="text/css">
</head>
<body>
    <div id="contentDiv">
            <ul>
                <li>姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name" size="30"></li>
                <li>身份证号：<input type="text" name="IDCard" size="30"></li>
                <li>性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="sex">
                    <option selected="selected">请选择性别</option>
                    <option>男</option>
                    <option>女</option>
                </select></li>
                <li>科室：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="keshi">
                    <option selected="selected">请选择科室</option>
                    <option>巡检一科</option>
                    <option>巡检二科</option>
                    <option>巡检三科</option>
                </select></li>
                <li>负责片区：<input type="text" size="30" name="area"></li>
                <li>职责范围：<input type="text" size="30" name="duty"></li>
                <li>联系方式：<input type="text" size="30" name="tel"></li>
                <li>登录密码：<input type="password" size="30" name="passworld"></li>
                <li>密码验证：<input type="password" size="30" name="passworldVerify"></li>
            </ul>
            <b><input type="submit" value="提交" onclick="add()"></b>
        </form>
        <script type="text/javascript">
        function add(){
            alert("已添加！");
            window.location.href='manage1.html';
        }
    
    </script>
    </div>
</body>
</html>