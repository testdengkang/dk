<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>SB Admin - Start Bootstrap Template</title>
  <!-- Bootstrap core CSS-->
  <link href="/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="/static/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="/static/css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
        <form id="loginForm">
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input class="form-control" id="exampleInputEmail1" name="username" type="email" aria-describedby="emailHelp" placeholder="User Name">
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" id="exampleInputPassword1" name="password" type="password" placeholder="Password">
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember Password</label>
            </div>
          </div>
          <a class="btn btn-primary btn-block" id="loginButton">Login</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="register">Register an Account</a>
          <a class="d-block small" href="forgot-password">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="/static/vendor/jquery/jquery.min.js"></script>
  <script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="/static/vendor/jquery-easing/jquery.easing.min.js"></script>

  <script src="/static/js/common.js" ></script>
<script type="text/javascript">
    function login(){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/user/login" ,//url
            data: $('#loginForm').serialize(),
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if (result.code == 2002) {
                    //alert("SUCCESS");
                    window.location.href='index';
                }else {
                    alert(result.message);
                }

            }
        });
    }


    $("#loginButton").click(function(){
        login();
    });

</script>
</body>

</html>
