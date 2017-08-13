<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">추천 List</h3>
				</div>
				<div class="box-body">
				
					<table class="table table-bordered">
						<tr>
							<th>MOVIENAME</th>
							<th>MOVIEID</th>
							<th>예상 평점</th>

						</tr>


						<tbody id="tbody">
							<c:forEach items="${recommendList}" var="PredictedRateVO">
								<tr id="targetRate">

									<td>${PredictedRateVO.moviename}</td>
									<td>${PredictedRateVO.movieid}</td>
									<td>${PredictedRateVO.rate}</td>
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

<%@include file="../include/footer.jsp"%>