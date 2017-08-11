<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>AdminLTE 2 | Log in</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="/resources/plugins/iCheck/square/blue.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="/main.bt"><b>Beteran</b>Project</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>
        
        
        
<!-- USERID	USERNAME	PWD	GENDER	BIRTH	EMAIL	ADDRESS -->
<form action="/user/register.bt" method="post">
  <div class="form-group has-feedback">
    <input type="text" name="userid" class="form-control" id="userid" placeholder="User Id"/>
    <span class="glyphicon glyphicon-user form-control-feedback"></span>
  </div>
  <div class="form-group has-feedback">
    <button onclick="idCheck()" type="button" class="btn btn-warning" value="중복체크">중복체크</button>
    <span id="idCheck"></span>
  </div>
  <div class="form-group has-feedback">
    <input type="password" name="pwd" class="form-control" placeholder="Password"/>
    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
  </div>
  <div class="form-group has-feedback">
    <input type="password" name="pwd2" class="form-control" placeholder="Again Password"/>
    <span class="glyphicon glyphicon-ok form-control-feedback"></span>
  </div>
  <div class="form-group has-feedback">
    <input type="text" name="username" class="form-control" placeholder="User Name"/>
    <span class="glyphicon glyphicon-pencil form-control-feedback"></span>
  </div>
  <div class="form-group has-feedback">
    <input type="text" name="gender" class="form-control" placeholder="Gender"/>
    <span class="glyphicon glyphicon-heart form-control-feedback"></span>
  </div>
  <div class="form-group has-feedback">
    <input type="text" name="birth" class="form-control" placeholder="Birth"/>
    <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
  </div>
  <div class="form-group has-feedback">
    <input type="text" name="email" class="form-control" placeholder="Email"/>
    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
  </div>
  <div class="form-group has-feedback">
    <input type="text" name="address" class="form-control" placeholder="Address"/>
    <span class="glyphicon glyphicon-globe form-control-feedback"></span>
  </div>
  <div class="row">
    <div class="col-xs-8">
    </div>
    <div class="col-xs-4">
      <button type="submit" class="btn btn-primary btn-block btn-flat">Sign Up</button>
    </div><!-- /.col -->
  </div>
</form>


        <a href="#">I forgot my password</a><br>
       <!--  <a href="/user/register.bt" class="text-center">Register a new membership</a> -->

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->

    <!-- jQuery 2.1.4 -->
    <script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="/resources/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <script  type="text/javascript">
    var isOverlapped = true;
    function idCheck() {
    	var id= $("#userid").val();
	    if(id==""){
	    	 $("#idCheck").empty().append("<span><b>&nbsp;&nbsp;&nbsp;&nbsp;아이디를 입력해주세요.</b></span>");
	    }else{	
		    $.ajax({
		    	 url: "/user/userIdCheck.bt",
		    	 type: "post",
		    	 data : {userid : id},
		    	 datatype: "json",
		    	 success : function(isExist){
		    		 if(isExist==1){
		    			 $("#idCheck").empty().append("<span style='color:red'><b>&nbsp;&nbsp;&nbsp;&nbsp;사용할 수 없습니다.</b></span>");
		    			 return false
		    		 }else{
		    			 $("#idCheck").empty().append("<span style='color:green'><b>&nbsp;&nbsp;&nbsp;&nbsp;사용해도 좋습니다.</b></span>");
		    			 return false;
		    		 }
		    		 
		    	 }
		    });
	    }
    }
    
     
    </script>
  </body>
</html>