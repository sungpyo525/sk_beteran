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
					<h3 class="box-title">Search PAGE</h3>
				</div>

				<form action="/movie/search.bt">
					영화명: <input type="text" id="movieName" name="movieName"> 
					감독명: <input type="text" id="directorName" name="directorName" placeholder="감독으로 검색해봐">

					개봉연도조건: <input type="text" id="openStartDate" name="openStartDate"> 
							~ <input type="text" id="openEndDate" name="openEndDate">
					<button type='submit' id='search-btn' class="btn btn-flat"f>검색</button>
				</form>

				
				
				<!-- /.box-body -->
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
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">

					<table class="table table-bordered">
						<tr>
							<td>영화명</td><td>영화명(영)</td><td>개봉연도</td><td>장르</td><td>제작국가</td><td>감독</td>
						</tr>

						<tbody id="tbody">
							<c:forEach items="${lists.movieListResult.movieList}" var="movie">

								<tr>
									<td><a href='javascript:contentMovieModal("${movie.movieNm}","${movie.movieNmEn}","${movie.openDt }",
									"${movie.repNationNm}","${movie.directors[0].peopleNm}","${movie.repGenreNm}","${movie.prdtYear}")'>${movie.movieNm }</td>
									<td>${movie.movieNmEn }</td>
									<td>${movie.openDt }</td>
									<td>${movie.repGenreNm}</td>
									<td><c:forEach items="${movie.directors}" var="director">
											${director.peopleNm}
										</c:forEach>
									</td>
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
</div>
<!-- /.content-wrapper -->




<script>
	
	

	$(document).ready(function(){
		
		$("#listBtn").click(function(){
			$("#listBtn").prop("data-dismiss","modal");
			alert();
			location.href="/board/list.bt";
		});
		
		
		//비동기 영화 search modal 사용안함 걸리는 문제가 많음
		$("#searchBtn2").click(function(){
			var movieNm = $("#movieName").val();
			var directorNm = $("#directorName").val();
			var openStartDt = $("#openStartDate").val();
			var openEndDt = $("#openEndDate").val();
			
			$.ajax({
				url		: "/movie/searchOption.bt",
				type	: "post",
				data	: {movieName : movieNm, directorName : directorNm, openStartDate : openStartDt, openEndDate : openEndDt},
				dataType : "json",
				success : function(ary){
					alert(ary)
					
					$("#tbody").empty();
					
					var txt="";
					var directorName = "";
					$.each(ary.movieListResult.movieList, function(ids, obj){
						txt += "<tr><td><a href=javascript:contentMovieModal('"
								+obj.movieNm+"','aaaaaaa','"+obj.openDt+"','"+obj.repNationNm+"','aaaaaa')>"+obj.movieNm+"</td>"; 
								
						txt += "<td>"+obj.movieNmEn+"</td>";
						txt += "<td>"+obj.openDt+"</td>";
						txt += "<td>"+obj.repNationNm+"</td>";
						$.each(obj.directors, function(ids2, objDirector){
							directorName = objDirector.peopleNm;
						});
						
						txt += "<td>"+directorName+"</td></tr>";
					});
					$("#tbody").append(txt);
				}
			})
		});
	});
</script>

<%@include file="../include/footer.jsp"%>
