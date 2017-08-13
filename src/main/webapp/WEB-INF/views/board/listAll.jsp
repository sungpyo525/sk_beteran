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
					<h3 class="box-title">네티즌 리뷰</h3>
				</div>
				
				<div class="box-body">
					<select id="searchType">
						<option>제목</option>					
						<option>작성자</option>	
						<option>관련영화</option>				
					</select>
					<input type="text" id="searchKeyword">
					<button id="searchBtn">검색</button>
					<button class="bs-example-modal-sm" data-toggle="modal" data-target="#bs-example-modal-sm">등록</button>
				</div>
				
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
					<h3 class="box-title">전체 리스트</h3>
				</div>
				<div class="box-body">
				
					<table class="table table-bordered">
						<tr>
							<th style="width: 60px">번호</th>
							<th>제목</th>
							<th>영화</th>
							<th>글쓴이</th>
							<th>날짜</th>
							
							
							<!-- <th style="width: 40px">VIEWCNT</th> -->
						</tr>
					
					<tbody id= "tbody">
					<c:forEach items="${lists}" var="boardreviewVO">
					
						<tr>
							<td>${boardreviewVO.rvid}</td>
							<!--/는 루트를 기준으로, ./는 현재를 기준으로 -->
							<!--<td><a href='/board/read.do?seq=${boardVO.seq}'>${boardVO.title}</a></td> -->
							
							<td><a href="javascript:contentModal(${boardreviewVO.rvid},'${boardreviewVO.rvtitle}','${boardreviewVO.moviename}','${boardreviewVO.rvcontent}', '${boardreviewVO.userid}')">${boardreviewVO.rvtitle}</a></td>
							<td>${boardreviewVO.moviename}</td>
							<td>${boardreviewVO.userid}</td>
							<td>${boardreviewVO.rvregdate}</td>
						<%-- 	<td><span class="badge bg-red">${boardreviewVO.viewcnt }</span></td> --%>
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
	<div class="modal fade" id="contentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">리뷰 상세보기</h4>
	      </div>
	      <div class="modal-body">
	      
	      		<input type="hidden" name="userid" id="userid">
	      		
	      		<div class="form-group">  
	     			<label for="title">제목</label>
	      			<input type="text" class="form-control" id="rvtitle" name="rvtitle">
	      		</div>
	      		<div class="form-group">  
				   	<label for="content">내용</label>
				    <textarea class="form-control" id="rvcontent" name="rvcontent">
				    </textarea>
	      		</div>  
	      		<div class="form-group" id=btnDiv> 
	      			<button id="updateBtn" type="button" class="btn btn-primary">수정</button>
	        		<button id="deleteBtn" type="button" class="btn btn-primary">삭제</button>
	        		<button id="listBtn" type="button" class="btn btn-warning">목록</button> 
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
		var rvid;
		function contentModal(rvid, rvtitle, rvcontent, userid){
			this.rvid=rvid;
			//alert(seq+":"+title+":"+content+":"+writer);
			$("#contentModal").modal();
			
			$("#rvtitle").val(rvtitle);
			$("#rvcontent").val(rvcontent);		
			$("#userid").val(userid);
			
			
			
			
			if('${loginUser.userid}' != $("#userid").val()){
				$("#updateBtn").hide();
				$("#deleteBtn").hide();
			}else{
				$("#updateBtn").show();
				$("#deleteBtn").show();
			}
		}
		
	
		$(document).ready(function(){
			
			$("#deleteBtn").click(function(){
				alert(rvid);
				location.href="/board/delete.bt?rvid="+rvid;
			});
			
			$("#updateBtn").click(function(){
				alert(rvid);
				location.href="/board/modifyForm.bt?rvid="+rvid;
			});
			
			$("#newBtn").click(function(){
				/* location.href="/board/boardForm.bt"; */
				
			});
			
			$("#listBtn").click(function(){
				location.href="/board/list.bt";
			});
			
			
			
		
			
			$("#searchBtn").click(function(){
				var type= 	$("#searchType").val();
				var keyword= $("#searchKeyword").val();
				$.ajax({
					url : "search.bt",
					type : "post",
					data : {searchType:type, searchKeyword:keyword},
					dataType : "json",
					success : function(ary){
						alert(ary);
						$("#tbody").empty();
						var str="";
						$.each(ary, function(idx, obj){
							
							str += "<tr>";
							str += "<td>"+obj.rvid+"</td>";
							str += "<td><a href=''>"+obj.rvtitle+"</a></td>";
							str += "<td>"+obj.moviename+"</td>";
							str += "<td>"+obj.userid+"</td>";
							str += "<td>"+obj.rvregdate+"</td>";
							/* str += "<td><span class='badge bg-red'>"+obj.viewcnt +"</span></td>"; */
							str += "</tr>";
						});
						$("#tbody").append(str);
						
						
					}
				});
			});
		});
	
	</script>

<%@include file="../include/footer.jsp"%>
