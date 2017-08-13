<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>


<!-- Main 	tent -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			

			<div class="box">
				
					<h1 class="box-title">고객님과 가장 유사한 '${firstSimUser.userid}'의 평점 정보 입니다</h1>
				
				
			</div>
		</div>
		<!--/.col (left) -->
	</div>
	<!-- /.row -->
	
	
<!-- /.row -->
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">${firstSimUser.userid} 평점 List</h3>
				</div>
				<div class="box-body">
				
					<table class="table table-bordered">
						<tr>
							<th>MOVIETITLE</th>
							<th>MOVIEID</th>
							<th>USERID</th>
							<th>MOVIERATE</th>

						</tr>


						<tbody id="tbody">
							<c:forEach items="${listSim}" var="movieRateVO">
								<tr id="targetRate">

									<td>${movieRateVO.moviename}</td>
									<td>${movieRateVO.movieid}</td>
									<td>${movieRateVO.userid}</td>
									<td>${movieRateVO.movierate}</td>
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
	
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">내가 준 평점</h3>
				</div>
				<div class="box-body">
				
					<table class="table table-bordered">
						<tr>
							<th>MOVIETITLE</th>
							<th>MOVIEID</th>
							<th>USERID</th>
							<th>MOVIERATE</th>

						</tr>
					
					
							<tbody id="tbody">
								<c:forEach items="${movieRatelists}" var="me">
										<tr id="targetRate">
											
											<td>${me.moviename}</td>
											<td>${me.movieid}</td>
											<td>${me.userid}</td>
											<td>${me.movierate}</td>
								          	<td><a href="javascript:updateModal(${me.movieid},'${me.userid}',${me.movierate})"><button id="updateRate" type="button">수정</button></a></td>
								          	<td><a href="/movieRate/rateDelete.bt?userid=${loginUser.userid}&movieid=${me.movieid}"><button id="deleteRate" type="button">삭제</button></a></td>
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
</div>
<!-- /.content -->
<!--  </div> -->
<!-- /.content-wrapper -->




<%@include file="../include/footer.jsp"%>