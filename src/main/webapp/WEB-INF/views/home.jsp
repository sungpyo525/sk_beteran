<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="./include/header.jsp"%>

<!-- Main content -->
<section class="content">
<div class="row">

		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">
				
					<table class="table table-bordered">
						<tr>
							<th>USERID</th>
							<th>USERNAME</th>
							<th>PWD</th>
							<th>GENDER</th>
							<th>BIRTH</th>
							<th>EMAIL</th>
							<th>ADDRESS</th>
						</tr>
					
					<tbody id= "tbody">
					<c:forEach items="${lists}" var="UserVO">
					
						<tr>
							<td>${UserVO.userid}</td>
							<td>${UserVO.username}</td>
							<td>${UserVO.pwd}</td>
							<td>${UserVO.gender}</td>
							<td>${UserVO.birth}</td>
							<td>${UserVO.email}</td>
							<td>${UserVO.address}</td>
						</tr>
					
					</c:forEach>
					</tbody>
					
					</table>

				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
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
					<h3 class="box-title">BOX OFFICE</h3>
				</div>
				<table class="table table-bordered">
						<tr>
							<th>1위</th>
							<th>2위</th>
							<th>3위</th>
							<th>4위</th>
							<th>5위</th>
							<th>6위</th>
							<th>7위</th>
							<th>8위</th>
							<th>9위</th>
							<th>10위</th>
							
						</tr>
					<tbody id= "tbody2">

						<tr>
							<c:forEach items="${dailyResult.boxOfficeResult.dailyBoxOfficeList}" var="boxoffice">
								<td><a href='javascript:contentMovieModal("${boxoffice.movieNm}")'>${boxoffice.movieNm }</td>
								
							</c:forEach>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- /.box -->
		</div>
		
		
		<!--/.col (left) -->
	</div>
	
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="./include/footer.jsp"%>