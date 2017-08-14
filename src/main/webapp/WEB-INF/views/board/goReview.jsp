<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">${moviename } 모든 리뷰 보기</h3>
				</div>
				<div class="box-body">
				
					

					<!-- RVID, RVTITLE, RVCONTENT, USERID, RVREGDATE, MOVIENAME -->
					<c:forEach items="${allLists}" var="vo">
				    <div class="media">
				   	 <input type="hidden" name="rvid" id="rvid${vo.rvid}" value="${vo.rvid} " >
				      <a class="pull-right" href="#">
				      </a>
				      <div class="media-body">
				       <h4 class="media-heading" style="color:#5D5D5D;">${vo.rvtitle }</h4>
				         <p id="content" style="color:#8C8C8C;">
				         	${vo.rvcontent }
				         </p>
				       <h6 style="color:#8C8C8C;">작성자 ${vo.userid}&nbsp; &nbsp; ${vo.rvregdate }</h6>
				      </div>
				      <b style="color:red;">LIKE</b> &nbsp;
	      				<span id="likeDiv${vo.rvid}">
	      				</span>&nbsp;
	      				<span id='reviewCount${vo.rvid}'></span>
					<hr>
				    </div>
					
					
					</c:forEach>


				</div>
				<!-- /.box-body -->
				<div class="box-footer">Review End</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script type="text/javascript">
/* Start :  좋아요 스크립트*/
var loginuserid="${loginUser.userid}";	// 리뷰 좋아요에 누를 사람의 userid
var rvid;
window.onload=function(){
	var size = ${allLists.size()};
 	for (index = 0; index<size; index++) {
 		var rvTemp=$("#rvid${allLists.get(index).rvid}").val();
		reviewCount(rvTemp);
		showLikeBtn(loginuserid, rvTemp);
	} 
}



function reviewCount(rvid){
	$.ajax({
		url : "selectCountLike.bt",
		type : "post",
		data : {rvid:rvid},
		dataType : "json",
		success : function(result){
			$("#reviewCount"+rvid).empty().append("<b>"+result+"</b>");
		}		
	});
}

function showLikeBtn(userid, rvid){
	$.ajax({
		url : "showLikeBtn.bt",
		type : "post",
		data : {userid:userid, rvid:rvid},
		dataType : "json",
		success : function(result){
			if(result==1){
				$("#likeDiv"+rvid).empty().append("<i class='fa fa-heart-o' aria-hidden='true' style='color:red;' id='notLikeBtn"+rvid+"' onclick='notLikeBtn("+rvid+")'></i> ");
			}else{
				$("#likeDiv"+rvid).empty().append("<i class='fa fa-heart' aria-hidden='true' style='color:red;' id='likeBtn"+rvid+"'  onclick='likeBtn("+rvid+")'></i> ");
			}
			
		
		}		
	});
}

function notLikeBtn(id){
	alert(loginuserid);
	$.ajax({
		url : "insertLike.bt",
		type : "post",
		data : {userid:loginuserid, rvid:id},
		dataType : "json",
		success : function(result){
//				alert(result);
			// 개수 보여주는 함수 실행 
			reviewCount(id);
			
			// 버튼 나타내주는 함수 실행
			showLikeBtn(loginuserid, id);
		
		}		
	});
}

function likeBtn(id){
	$.ajax({
		url : "deleteLike.bt",
		type : "post",
		data : {userid:loginuserid, rvid:id},
		dataType : "json",
		success : function(result){
//				alert(result);
			// 개수 보여주는 함수 실행 
			reviewCount(id);
			
			// 버튼 나타내주는 함수 실행
			showLikeBtn(loginuserid, id);
		
		}		
	});
}
/* End :  좋아요 스크립트*/
</script>

<%@include file="../include/footer.jsp"%>
