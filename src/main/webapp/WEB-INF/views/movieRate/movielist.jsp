<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<!-- Main 	tent -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Search PAGE</h3>
				</div>
				<div class="box-body">
					<select id="searchType">
						<option>제목</option>
						<option>작성자</option>
					</select>
					<input type="date" id="searchKeyword">
					<button id="searchBtn">Search</button>
					<button id="newBtn">Register</button>
				</div>
			</div>
		</div>
		<!--/.col (left) -->
	</div>
	<!-- /.row -->
	
    <!--  첫번째 로우 -->
    
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL MOVIES</h3>
				</div>
				<div class="box-body">	
	<table class="table table-bordered">
		<tr>
			<th>MOVIETITLE</th>
			<th>DIRECTOR</th>
			<th>DATE</th>
			<th>NATION</th>
			<th>RATE</th>
		</tr>

	<tbody id="tbody">

			<c:forEach items="${movielists}" var="movieVO">
			<form role="form" action="/movieRate/rateRegister.bt">
			<tr>
			<input id="movieid" type="hidden" name="movieid" value="${movieVO.movieid}"/>
			<input id="userid" type="hidden" name="userid" value="${loginUser.userid}"/>
			<td>${movieVO.moviename}</td>
			<td>${movieVO.moviedirector}</td>
			<td>${movieVO.moviedate}</td>
			<td>${movieVO.movienation}</td>

			<td id="${movieVO.movieid}">
				<select id="movierate" name="movierate">
					<option>select</option>
					<option>0.5</option>
					<option>1.0</option>
					<option>1.5</option>
					<option>2.0</option>
					<option>2.5</option>
					<option>3.0</option>
					<option>3.5</option>
					<option>4.0</option>
					<option>4.5</option>
					<option>5.0</option>
				</select>

			<button type="submit" id="rateBtn">점수등록</button></td>
			</form>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- <button id="rateBtn">등록</button> -->
		</div>
				<!-- /.box-body -->
				<!-- /.box-footer-->
		</div>
	</div>
	<!--/.col (left) -->
</div>
<!-- /.row -->
	
	
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">내가 입력한 평점</h3>
				</div>
				<div class="box-body">
				
					<table class="table table-bordered">
						<tr>
							<th>MOVIEID</th>
							<th>USERID</th>
							<th>MOVIERATE</th>
						</tr>
					
					
							<tbody id="tbody">
								<c:forEach items="${movieRatelists}" var="movieRateVO">
										<tr id="targetRate">
											<td>${movieRateVO.movieid}</td>
											<td>${movieRateVO.userid}</td>
											<td>${movieRateVO.movierate}</td>
								          	<td><a href="javascript:updateModal(${movieRateVO.movieid},'${movieRateVO.userid}',${movieRateVO.movierate})"><button id="updateRate" type="button">수정</button></a></td>
								          	<td><a href="/movieRate/rateDelete.bt?userid=${loginUser.userid}&movieid=${movieRateVO.movieid}"><button id="deleteRate" type="button">삭제</button></a></td>
										</tr>
								</c:forEach>


	</tbody>

</table>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">Footer</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
	
	
</section>
<!-- /.content -->
<!--  </div> -->
<!-- /.content-wrapper -->

<!-- 모달 -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	 <div class="modal-dialog">
	  <div class="modal-content">
	   <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">
	     <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
		</button>
			<h4 class="modal-title" id="myModalLabel">평점</h4>
	   </div>	
		<div class="modal-body">
			<!-- 태그 -->	
			
					<table class="table table-rate">
						<tr>
							<th>MOVIEID</th>
							<th>USERID</th>
							<th>MOVIERATE</th>
						</tr>
							<tbody id="tbody">
							<form role="form" action="/movieRate/updateRate.bt" method="post">
							
								<td><input type="text" id="modalmovieid" name="movieid"/></td>
								<td><input type="text" id="modaluserid" name="userid"/></td>
								<td>
								<select id="modalmovierate" name="movierate">
									<option>select</option>
									<option>0.5</option>
									<option>1.0</option>
									<option>1.5</option>
									<option>2.0</option>
									<option>2.5</option>
									<option>3.0</option>
									<option>3.5</option>
									<option>4.0</option>
									<option>4.5</option>
									<option>5.0</option>
								</select></td>
							</tbody>
						</table>
					<div><button id="updateBtn" type="submit">수정</button></div>

					<!-- 내용 들어가는 곳 -->
			</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary">변경 사항 저장</button>
				</div>
			</div>
			<!-- 모달 콘텐츠 -->
		</div>
		<!-- 모달 다이얼로그 -->
	</div>







	<script>
	
	
	function updateModal(movieid, userid, movierate){

		$("#updateModal").modal();
		$("#modalmovieid").val(movieid);
		$("#modaluserid").val(userid);
	}
	
	
	$(document).ready(function(){
		
 		$("#updateBtn").click(function(){
 			alert("하하");
 		});
		

	});
	
	
	

    </script>

<%@include file="../include/footer.jsp"%>
