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
					<input type="text" id="searchKeyword">
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
					<h3 class="box-title">MOVIE RATES</h3>
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
										<tr>
											<td>${movieRateVO.movieid}</td>
											<td>${movieRateVO.userid}</td>
											<td>${movieRateVO.movierate}</td>
								<!-- 		  <td><button type="button" id="rateBtn">점수등록</button></td> -->
										</tr>
								</c:forEach>


	</tbody>

</table>
	<button class="ratemovie" data-toggle="modal" data-target="#rateModal">
	내가 준 평점
	</button>
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
	<div class="modal fade" id="rateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	 <div class="modal-dialog">
	  <div class="modal-content">
	   <div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">
	     <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
		</button>
			<h4 class="modal-title" id="myModalLabel">글 상세</h4>
	   </div>	
		<div class="modal-body">
			<!-- 태그 -->	
					<table class="table table-bordered">
						<tr>
							<th>MOVIEID</th>
							<th>USERID</th>
							<th>MOVIERATE</th>
						</tr>
					
					
							<tbody id="tbody">
								<c:forEach items="${movieRatelists}" var="movieRateVO">
										<tr>
											<td>${movieRateVO.movieid}</td>
											<td>${movieRateVO.userid}</td>
											<td>${movieRateVO.movierate}</td>
								<!-- 		  <td><button type="button" id="rateBtn">점수등록</button></td> -->
										</tr>
								</c:forEach>


					</tbody>

					</table>

					<!-- 내용 들어가는 곳 -->

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
	
	 function rateModal(movieid, userid, movierate){
		alert(movieid);
		alert(userid);
		alert(movierate);
		$("#rateModal").modal();
	} 
	
	
	$(document).ready(function(){
		$("#rateBtn").click(function(){
			alert("감사합니다!");
		});
		
		/* $("#myRateBtn").click(function(){
			alert("^^");
		}); */
	});
	
	
	

    </script>

<%@include file="../include/footer.jsp"%>
