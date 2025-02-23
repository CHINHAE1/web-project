<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/9/28
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="loginHtml">
<head>
    <meta charset="utf-8">
    <title>注册--汽车出租系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="/car_rental/static/favicon.ico">
    <link rel="stylesheet" href="/car_rental/static/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="/car_rental/static/css/public.css" media="all" />
</head>
<body class="loginBody">
<form class="layui-form" id="loginFrm" method="post" action="/car_rental/login/register">
    <div class="login_face"><img src="/car_rental/static/images/face.jpg" class="userAvatar"></div>
    <div class="layui-form-item input-item">
        <label for="realname">用户名</label>
        <input type="text" placeholder="请输入用户名" autocomplete="off" name="realname" id="realname" class="layui-input" lay-verify="required">
    </div>
    <div class="layui-form-item input-item">
        <label for="identity">身份证号</label>
        <input type="text" placeholder="身份证号" autocomplete="off" name="identity" id="identity" class="layui-input" lay-verify="required">
    </div>
    <div class="layui-form-item input-item">
        <label for="password">密码</label>
        <input type="password" placeholder="请输入密码" autocomplete="off" name="password" id="password" class="layui-input" lay-verify="required">
    </div>
     <div class="layui-form-item input-item">
        <label for="repassword">确认密码</label>
        <input type="password" placeholder="请输入密码" autocomplete="off"   id="repassword" class="layui-input" lay-verify="required">
    </div>
    
    <div class="layui-form-item">
        <button class="layui-btn layui-block" lay-filter="login" lay-submit>注册</button>
    </div>
   <div class="layui-form-item">
        <input class="layui-btn layui-block" readonly lay-filter="login" onclick="javascript:login()" value="登录"> 
    </div>
    <div class="layui-form-item layui-row" style="text-align: center;color: red;">
        ${error}
        <%--<a href="javascript:;" class="seraph icon-qq layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
        <a href="javascript:;" class="seraph icon-wechat layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
        <a href="javascript:;" class="seraph icon-sina layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>--%>
    </div>
</form>
<script type="text/javascript" src="/car_rental/static/layui/layui.js"></script>
<script type="text/javascript" src="/car_rental/static/js/cache.js"></script>
<script type="text/javascript">
    layui.use(['form','layer','jquery'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

        /*$(".loginBody .seraph").click(function(){
            layer.msg("这只是做个样式，至于功能，你见过哪个后台能这样注册的？还是老老实实的找管理员去注册吧",{
                time:5000
            });
        })*/

        //注册按钮
        form.on("submit(login)",function(data){
             setTimeout(function(){
 
            			var password = document.getElementById("password").value;
            			var repassword = document.getElementById("repassword").value;
            			if (!password) {
            				alert("请输入密码！");
            				return;
            			}
            			if (!repassword) {
            				alert("请再次输入密码！");
            				return;
            			}
            			if (repassword!=password) {
            				alert("两次密码不一致！");
            				return;
            			}            		 
            	 
                $("#loginFrm").submit();
            },1);
            return false;
        })

        //表单输入效果
        $(".loginBody .input-item").click(function(e){
            e.stopPropagation();
            $(this).addClass("layui-input-focus").find(".layui-input").focus();
        })
        $(".loginBody .layui-form-item .layui-input").focus(function(){
            $(this).parent().addClass("layui-input-focus");
        })
        $(".loginBody .layui-form-item .layui-input").blur(function(){
            $(this).parent().removeClass("layui-input-focus");
            if($(this).val() != ''){
                $(this).parent().addClass("layui-input-active");
            }else{
                $(this).parent().removeClass("layui-input-active");
            }
        })
    })
function login(){
    	window.location.href="/car_rental/login/toLogin.action";
    }
</script>
</body>
</html>
