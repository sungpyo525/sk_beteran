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
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="./include/footer.jsp"%>