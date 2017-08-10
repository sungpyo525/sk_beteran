<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<!-- Main content -->
    <style type="text/css">
    .popup {position: absolute;}
    .back { background-color: gray; opacity:0.5; width: 100%; height: 300%; overflow:hidden;  z-index:1101;}
    .front { 
       z-index:1110; opacity:1; boarder:1px; margin: auto; 
      }
     .show{
       position:relative;
       max-width: 1200px; 
       max-height: 800px; 
       overflow: auto;       
     } 
  	
    </style>

    <div class='popup back' style="display:none;"></div>
    <div id="popup_front" class='popup front' style="display:none;">
     <img id="popup_img">
    </div>

<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">회원정보 수정/삭제</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" action="/user/userInfoModify.bt" method="post">

					<%-- 
					<input type='hidden' name='bno' value="${boardVO.bno}">
					<input type='hidden' name='page' value="${cri.page}">
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">
					 --%>

				<div class="box-body">
					<input type='hidden' name='userid' value="${loginUser.userid}">
					<div class="form-group">
						<label for="username">이름</label>
						<input type="text" id="username" name='username' 
						class="form-control" value="${loginUser.username}" readonly="readonly">
					</div>
					
					<div class="form-group">
						<label for="pwd">패스워드</label>
						 <input type="password" id="pwd" name='pwd'
						 class="form-control" value="${loginUser.pwd}" readonly="readonly">
					</div>
					
					<div class="form-group">
						<label for="birth">생년월일</label>
						 <input type="text" id="birth" name='birth'
						 class="form-control" value="${loginUser.birth}" readonly="readonly">
					</div>
					
					<div class="form-group">
						<label for="email">이메일</label>
						<input type="text" id="email" name="email"
						class="form-control" value="${loginUser.email}" readonly="readonly">
					</div>
					
					<div class="form-group">
						<label for="address">주소</label>
						<input type="text" id="address" name="address" 
						class="form-control" value="${loginUser.address}" readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->
			
			 <div class="box-footer" id="btnBox">
			   <button type="button" class="btn btn-warning" id="modifyBtn">Modify</button>
			   <button type="button" class="btn btn-danger" id="removeBtn">Withdraw</button>
			 </div>
			 </form>



			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
	
</section>
<!-- /.content -->









<script>
$(document).ready(function(){
	$("#modifyBtn").on("click", function(){
		$("#username").attr("readonly", false);
		$("#pwd").attr("readonly", false);
		$("#birth").attr("readonly", false);
		$("#email").attr("readonly", false);
		$("#address").attr("readonly", false);
		
		$("#btnBox").empty();
		$("#btnBox").append("<button type='submit' class='btn btn-primary'>Submit</button>");
	});
	
	$("#removeBtn").on("click", function(){
		if (confirm('정말 탈퇴하시겠습니까 ?')) {
			location.href="/user/deleteUser.bt?userid=${loginUser.userid}";
		} else {
		   	location.href="/user/userInfo.bt?userid=${loginUser.userid}";
		}
	});
	

});
</script>

</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>