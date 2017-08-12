<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="./include/header.jsp"%>

<!-- Main content -->
<section class="content">
	 <div id="carousel-example-generic" class="carousel slide">
            <!-- Indicators -->
            <ol class="carousel-indicators">
              <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
              <li data-target="#carousel-example-generic" data-slide-to="1"></li>
              <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>
                 <!-- Carousel items -->
             <div class="carousel-inner">
                <div class="item active">
                   <img src="./slide1.jpg" alt="First slide">
                     <div class="carousel-caption">
                        <h3>슬라이드 효과 </h3>
                        <p>캡션 내부에는 HTML 태그 사용 가능합니다.</p>
                     </div>  
                </div>
                <div class="item">
                   <img src="./slide2.jpg" alt="Second slide"> 
                     <div class="carousel-caption">
                        <h3>슬라이드 효과 </h3>
                        <p>캡션 내부에는 HTML 태그 사용 가능합니다.</p>
                     </div>                                   
                </div>
                <div class="item">
                   <img src="./slide3.jpg" alt="Third slide">                 
                     <div class="carousel-caption">
                        <h3>슬라이드 효과 </h3>
                        <p>캡션 내부에는 HTML 태그 사용 가능합니다.</p>
                     </div>                     
                </div>
             </div>
            <!-- Controls -->
              <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                <span class="icon-prev"></span>
              </a>
              <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                <span class="icon-next"></span>
              </a>
          </div>

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
								<td><a href='javascript:contentMovieModal("${boxoffice.movieNm}","${boxoffice.movieNmEn}","${boxoffice.openDt }",
									"${boxoffice.repNationNm}","${boxoffice.directors}","${boxoffice.repGenreNm}")'>${boxoffice.movieNm }</td>
							</c:forEach>
						</tr>
					</tbody>
					<tbody id= "tbody2">
						<tr>
							<td><img alt='영화 포스터' src="${rank1.items[0].image}" ></td>
							<td><img alt='영화 포스터' src="${rank2.items[0].image}" ></td>
							<td><img alt='영화 포스터' src="${rank3.items[0].image}" ></td>
							<td><img alt='영화 포스터' src="${rank4.items[0].image}" ></td>
							<td><img alt='영화 포스터' src="${rank5.items[0].image}" ></td>
							<td><img alt='영화 포스터' src="${rank6.items[0].image}" ></td>
							<td><img alt='영화 포스터' src="${rank7.items[0].image}" ></td>
							<td><img alt='영화 포스터' src="${rank8.items[0].image}" ></td>
							<td><img alt='영화 포스터' src="${rank9.items[0].image}" ></td>
							<td><img alt='영화 포스터' src="${rank10.items[0].image}" ></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- /.box -->
		</div>
		<div>
			<%-- <input value="${rank1json.movieInfo.movieNm}"/> --%>
			
		</div>
		
		<!--/.col (left) -->
	</div>
	
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

 <!--메인 페이지 영화 포스터 띄우기  -->
 <script type='text/javascript' event='onload' for='window'>
 	function contentMovieModal(movieNm){
 		
 	}
 </script>

<%@include file="./include/footer.jsp"%>