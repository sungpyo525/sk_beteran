<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
   <meta charset="utf-8" />
   <link rel="apple-touch-icon" sizes="76x76" href="../resources/assets/img/apple-icon.png">
   <link rel="icon" type="image/png" href="../resources/assets/img/favicon.png">
   <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

   <title>Sign Up Page - Material Kit by Creative Tim</title>

   <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

   <!--     Fonts and icons     -->
   <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

   <!-- CSS Files -->
    <link href="../resources/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../resources/assets/css/material-kit.css" rel="stylesheet"/>

</head>

<body class="signup-page">
   <nav class="navbar navbar-transparent navbar-absolute">
       <div class="container">
           <!-- Brand and toggle get grouped for better mobile display -->
           <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
              </button>
                
              <a class="navbar-brand" href="../main.do">H O M E</a>
                
           </div>

           <div class="collapse navbar-collapse" id="navigation-example">
              <ul class="nav navbar-nav navbar-right">
            
                
                  
              </ul>
           </div>
       </div>
    </nav>

    
    
    <!--    본문   -->
    <div class="wrapper">
      <div class="header header-filter" style="background-image: url('../resources/assets/img/city.jpg'); background-size: cover; background-position: top center;">
         <div class="container">
            <div class="row">
               <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
                  <div class="card card-signup">
                  
                  <%-- 
                        회 원 가 입 폼
                  --%>
                     <form class="form" name="joinForm" method="post" action="./join.do">
                        <div class="header header-primary text-center">
                           <h4>회원가입</h4>
                        </div>
                        <div class="content">

                           <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="material-icons">face</i>
                              </span>
   <%-- ID--%>                     <input type="text" name="id" id="id" class="form-control" placeholder="I D...">
                              <input type="button" class="btn btn-primary" onclick="idCheck()" value="중복확인">
                           </div>

                           <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="material-icons">lock_outline</i>
                              </span>
   <%-- PASSWORD --%>                  <input type="password" id="password" name="password" placeholder="Password..." class="form-control" />
                           </div>
                                    <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="material-icons">lock_outline</i>
                              </span>
   <%--PASSWORD AGAIN--%>            <input type="password" id="pwdAgain" name="pwdAgain" placeholder="Password Again..." class="form-control" />
                           </div>
                           
                           <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="material-icons">face</i>
                              </span>
   <%-- NAME --%>                     <input type="text" id="name" name="name"class="form-control" placeholder="Name...">
                           </div>
                                    
                                    <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="material-icons">email</i>
                              </span>
   <%-- EMAIL --%>               <input type="email" id="email" name="email" class="form-control" placeholder="Email...(xxxx@xxxx)">
                           </div>
                                    <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="material-icons">phone</i>
                              </span>
   <%-- PHONE--%>                  <input type="tel" id="phone" name="phone" class="form-control" placeholder="phone...">
                           </div>
                                    <div class="input-group">
                                    <div class="col-md-4 dropdown">
                    <a href="#" class="btn btn-simple dropdown-toggle" data-toggle="dropdown">
                        State
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">서울</a></li>
                        <li><a href="#">경기</a></li>
                        <li><a href="#">강원</a></li>
                        <li><a href="#">충남</a></li>
                        <li><a href="#">충북</a></li>
                        <li><a href="#">전남</a></li>
                        <li><a href="#">전북</a></li>
                        <li><a href="#">경남</a></li>
                        <li><a href="#">경북</a></li>
                        <li><a href="#">부산</a></li>
                        <li><a href="#">대전</a></li>
                        <li><a href="#">울산</a></li>
                        <li><a href="#">대구</a></li>
                        <li><a href="#">광주</a></li>
                        <li><a href="#">인천</a></li>
                        <li><a href="#">세종</a></li>
                    </ul>
                </div>               
                                      
                                    </div>
                                                  
                                      
                                    </div>
                                    <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="material-icons">home</i>
                              </span>
   <%--ADDRESS --%>            <input type="text" id="address" name="address" class="form-control" pla   ceholder="address...">
                           </div>
                                
                                <div class="input-group">
                                    <div class="col-md-3"><div class="radio">
   <label>
      <input type="radio" name="gender" id="man" value="M">
      Man                              <%-- GENDEER --%>
   </label>
</div></div>
                                    <div class="col-md-3"></div>
                                    <div class="col-md-3">                                    
<div class="radio">
   <label>
      <input type="radio" name="gender" id="woman" value="F" checked="true">
      Woman                           <%-- GENDEER --%>
   </label>
</div>
</div>
                                        
                </div> 
                                    
                                     <div class="input-group">
                              <span class="input-group-addon">
                                 <i class="material-icons">cake</i>
                              </span>
                              
       <%--BIRTH --%>                 <input class="datepicker form-control" name="birth"type="text" value="03/12/2016"/>

                           </div>
                                    
                                    
                        </div>
                        <div class="footer text-center">
                           <button type="button" class="btn btn-simple bt-primary btn-lg" onclick="check()">CONFIRM</button>
                                    
                        </div>
 <%-- HIDDEN AREA --%>                              
                                
                                
                                
                                
                                
 <%-- HIDDEN AREA --%>                                
                     </form>         <%-- end of form --%>
                  </div>
               </div>
            </div>
         </div>

         <footer class="footer">
              <div class="container">
                  
                  <div class="copyright pull-right">
                     <a href="http://www.creative-tim.com" target="_blank">Team Barcelona</a>
                  </div>
              </div>
          </footer>

      </div>

    </div>


</body>
   <!--   Core JS Files   -->
   <script src="../resources/assets/js/jquery.min.js" type="text/javascript"></script>
   <script src="../resources/assets/js/bootstrap.min.js" type="text/javascript"></script>
   <script src="../resources/assets/js/material.min.js"></script>

   <!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
   <script src="../resources/assets/js/nouislider.min.js" type="text/javascript"></script>

   <!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
   <script src="../resources/assets/js/bootstrap-datepicker.js" type="text/javascript"></script>

   <!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
   <script src="../resources/assets/js/material-kit.js" type="text/javascript"></script>

    <!-- javascript -->
    <script type="text/javascript">
       var isOverlapped = true;
    
    
        $('.datepicker').datepicker({
      weekStart:1
        });
        
        function check(){
           var email = document.joinForm.email.value;
           
           if(document.joinForm.id.value == ""){
              alert("Fill in the ID area");
              document.joinForm.id.focus();
              return false;
           }else if(isOverlapped == true){
              alert("ID 중복");
              return false;
           }
           else if(document.joinForm.password.value != document.joinForm.pwdAgain.value){
              alert("Password not equals");
              document.joinForm.password.focus();
              return false;
           }
           
           document.joinForm.submit();
        }
        
        function idCheck(){
           var id = $("#id").val();
           alert("ID CHECK");
           $.ajax({
            url         : "idcheck.do",
            type       : "post",
            data      : {id : id},
            dataType   : "json",
            success      : function(isExist){
               alert("Ajax func");
               alert(isExist);
               if(isExist == 1){
                  alert("ID 중복");
                  isOverlapped = true;
                  return false;
               }else{
                  alert("중복X");
                  isOverlapped = false;
                  return false;
               }
               
            }
         });
        }
        
        $("#id").focusout(function() {
        	var val=$(this).val();
        	var reg= /^[A-Za-z0-9+]{6,12}$/;
        	if(val==""|val==null)
				alert("ID를 입력하세요");
        	else if(!reg.test(val))
        		alert("6자리이상, 12자리 이하 영문과 숫자만 가능");
        });
        
        $("#password").focusout(function() {
        	var val=$(this).val();
        	var reg= /^(?=.*[A-Za-z])((?=.*\d)|(?=.*\W)).{8,16}$/;
        	if(val==""|val==null)
				alert("PASSWORD를 입력하세요");
        	else if(!reg.test(val))
        		alert("8자리이상, 16자리 이하, 숫자 혹은 특수 문자를 반드시 포함");
        });
        
        $("#pwdAgain").focusout(function() {
        	var val=$(this).val();
        	var beforeval=$("#password").val();
        	if(val==""|val==null)
				alert("PASSWORD를 다시한번 입력하세요");
        	else if(val!=beforeval)
        		alert("PASSWORD가 일치하지 않습니다");
        });
        
        $("#name").focusout(function() {
        	var val=$(this).val();
        	var reg= /^[가-힣]{2,33}$/;
        	if(val==""|val==null)
				alert("이름을 입력하세요");
        	else if(!reg.test(val))
        		alert("이름 다시써 내가 모를줄알아?");
        });
        
        $("#email").focusout(function() {
        	var val=$(this).val();
        	var reg= /^\w{1,12}@[a-z]{2,15}[\.][a-z]{2,3}[\.]?[a-z]{0,2}$/;
        	if(val==""|val==null)
				alert("email을 입력하세요");
        	else if(!reg.test(val))
        		alert("똑바로 입력해! 형 힘들다");
        });
        
        $("#phone").focusout(function() {
        	var val=$(this).val();
        	var reg= /^(010|016|011)\d{3,4}\d{4}$/;
        	if(val==""|val==null)
				alert("전화번호를 입력하세요");
        	else if(!reg.test(val))
        		alert("내가 원하는건 니 전화번호");
        });
        
        
        
        
        
        
        
        
        
</script>
    <%-- 
   <script language="javascript">
     function my_check(){
        if (document.myform.id.value == "")
        {
           alert("아이디를 입력하세요");
           document.myform.id.focus();
           return false;
        }
        if (document.myform.psw.value != document.myform.psw1.value)
        {
           alert("비밀번호를 확인해주세요");
           document.myform.psw.value="";
           document.myform.psw1.value="";
           document.myform.psw.focus();
           return false;
        }
        doc
        ument.myform.submit();
     }
  </script>

   --%> 
    
</html>

    
    
    
    
    
    
    
    
    
    