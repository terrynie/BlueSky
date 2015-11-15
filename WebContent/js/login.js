/**
 * 
 */
$(function(){
   $(".btn btn-primary").click(function(){
       if(checkInput()) {
           $("form").action("loginservlet");
       }else{
           return false;
       }
 });
// $(".validationCode_img").click(function(){
//   $(".validationCode_img").attr("src","/validationCode?"+Math.random());
// });
 
    function checkInput(){
        //判断用户名
        if($("input[name=username]").val() == null || $("input[name=username]").val() == "" || $("input[name=username]").val() == "用户名"){
            alert("用户名不能为空");
            $("input[name=username]").focus();
            return false;
        }
        //判断密码
        if($("input[name=password]").val() == null || $("input[name=password]").val() == ""){
            alert("密码不能为空");
            $("input[name=password]").focus();
            return false;
        }
        //判断部门
        if($("select").val() == null || $("select").val() == "" ){
        	alert("请选择部门");
        	$("select").focus();
        	return false;
        }
//        //判断验证码
//        if($("input[name=validationCode]").val() == null || $("input[name=validationCode]").val() == ""){
//            alert("验证码不能为空");
//            $("input[name=validationCode]").focus();
//            return false;
//        }
        
        return true;
    }
});
