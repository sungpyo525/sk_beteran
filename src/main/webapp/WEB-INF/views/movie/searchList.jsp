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
							<td>영화명</td><td>영화명(영)</td><td>개봉연도</td><td>제작국가</td><td>감독</td>
						</tr>

						<tbody id="tbody">
							<c:forEach items="${lists.movieListResult.movieList}" var="movie">

								<tr>
									<td><a href='javascript:contentMovieModal("${movie.movieNm}","${movie.movieNmEn}","${movie.openDt }",
									"${movie.repNationNm}","${movie.directors}")'>${movie.movieNm }</td>
									<td>${movie.movieNmEn }</td>
									<td>${movie.openDt }</td>
									<td>${movie.repNationNm}</td>
									<td><c:forEach items="${movie.directors}" var="director">
											${director.peopleNm} /
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

	 <!-- Modal -->
	<div class="modal fade" id="contentmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<input type="text" class="form-control" id="movieNm" name="movieNm">
			</div>
			<div class="modal-body">

					<input type="hidden" neme="writer" id="writer"/>
					
					<div class="form-group">
						<label for="Name" class="col-xs-2 col-lg-2 control-label">포스터</label>
						<div class="col-xs-10 col-lg-10" id="poster">
							<img alt="제공되는 사진이 없습니다.미안" id="post_img"  width="400" height="500" >
						</div>
					</div>
					<div class="form-group">
						<label for="Name" class="col-xs-2 col-lg-2 control-label">내용</label>
						<div class="col-xs-10 col-lg-10">
							<textarea class="form-control" id="content" name="content" value="내용~~~~"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="Name" class="col-xs-2 col-lg-2 control-label">개봉년도</label>
						<div class="col-xs-10 col-lg-10">
							<textarea class="form-control" id="openDt" name="openDt" ></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="Name" class="col-xs-2 col-lg-2 control-label">국가</label>
						<div class="col-xs-10 col-lg-10">
							<textarea class="form-control" id="repNationNm" name="repNationNm" ></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="Name" class="col-xs-2 col-lg-2 control-label">감독</label>
						<div class="col-xs-10 col-lg-10" id="directors">
							<textarea  name="directors" ></textarea>
						</div>
					</div>
					<div class="form-group" id="btnDiv">
						<button id="rateBtn">평점입력</button>						
						
					</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				<button type="button" class="btn btn-primary">변경 사항 저장</button>
			</div>
		</div> <!-- 모달 콘텐츠 -->
	  </div> <!-- 모달 다이얼로그 -->
	</div> <!-- 모달 전체 윈도우 -->



<script>
	
	function contentMovieModal(movieNm,movieNmEn,openDt,repNationNm,directors){
		var image;
		var director;
		var image2;
		$.ajax({
			url		: "/movie/getPicture.bt",
			type	: "post",
			data	: {movieName : movieNm},
			dataType : "json",
			success : function(ary){
				
				$.each(ary.items, function(ids, obj){
					
					image = obj.image;
					
					image2 = "http://t1.search.daumcdn.net/thumb/R438x0.q85/?fname=http%3A%2F%2Fcfile117.uf.daum.net%2Fimage%2F231AB84F51AD703D2F09BC"
					director = obj.director;
					$("#poster").empty();
					$("#poster").append("<img alt='영화 포스터' src="+image+" width='300' height='400'>");
					$("#directors").empty();
					$("#directors").append("<input value="+director+">");
				})
			}
		})

		
		$('#contentmodal').modal();
		
		$('#movieNm').val(movieNm);
		$('#movieNmEn').val(movieNmEn);
		$('#openDt').val(openDt);
		$('#repNationNm').val(repNationNm);
		
		
		
		
	}

	$(document).ready(function(){
		
		$("#listBtn").click(function(){
			$("#listBtn").prop("data-dismiss","modal");
			alert();
			location.href="/board/list.bt";
		});
		
		
		//비동기 영화 search modal
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
