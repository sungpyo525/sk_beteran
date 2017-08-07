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
					<h3 class="box-title">SEARCH</h3>
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
							<th style="width: 10px">SEQ</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th style="width: 40px">VIEWCNT</th>
						</tr>
					
					<tbody id= "tbody">
					<c:forEach items="${lists}" var="boardVO">
					
						<tr>
							<td>${boardVO.seq}</td>
							<!--/는 루트를 기준으로, ./는 현재를 기준으로 -->
							<!--<td><a href='/board/read.do?seq=${boardVO.seq}'>${boardVO.title}</a></td> -->
							
							<td><a href="javascript:contentModal(${boardVO.seq},'${boardVO.title}','${boardVO.content}', '${boardVO.writer}')">${boardVO.title}</a></td>
							<td>${boardVO.writer}</td>
							<td>${boardVO.regdate}</td>
							<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
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
	        <h4 class="modal-title" id="myModalLabel">글 상세보기</h4>
	      </div>
	      <div class="modal-body">
	      
	      		<input type="hidden" name="writer" id="writer">
	      		
	      		<div class="form-group">  
	     			<label for="title">제목</label>
	      			<input type="text" class="form-control" id="title" name="title">
	      		</div>
	      		<div class="form-group">  
				   	<label for="content">내용</label>
				    <textarea class="form-control" id="content" name="content">
				    </textarea>
	      		</div>  
	      		<div class="form-group" id=btnDiv> 
	      			<button id="updateBtn" type="button" class="btn btn-primary">UPDATE</button>
	        		<button id="deleteBtn" type="button" class="btn btn-primary">DELETE</button>
	        		<button id="listBtn" type="button" class="btn btn-warning">LIST</button> 
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
		var seq;
		function contentModal(seq, title, content, writer){
			this.seq=seq;
			//alert(seq+":"+title+":"+content+":"+writer);
			$("#contentModal").modal('show');
			
			$("#title").val(title);
			$("#content").empty().append(content);		
			$("#writer").val(writer);
			
			//alert('${loginUser.id}'+" : "+$("#writer").val());
			
			/* if('${loginUser.id}' == $("#writer").val()){
				$("#btnDiv").empty();
				$("#btnDiv").append("<button id='updateBtn' type='button' class='btn btn-primary'>UPDATE</button>")
						.append("<button id='deleteBtn' type='button' class='btn btn-primary'>DELETE</button>")
						.append("<button id='listBtn' type='button' class='btn btn-warning'>LIST</button> ");
			}
			else{
				$("#btnDiv").empty();
				$("#btnDiv").append("<button id='listBtn' type='button' class='btn btn-warning'>LIST</button>");
			} */
			
			$("#updateBtn").show();
			$("#deleteBtn").show();
			if('${loginUser.id}' != $("#writer").val()){
				$("#updateBtn").hide();
				$("#deleteBtn").hide();
			}
		}
	
		$(document).ready(function(){
			
			$("#deleteBtn").click(function(){
				alert(seq);
				location.href="/board/delete.do?seq="+seq;
			});
			
			$("#updateBtn").click(function(){
				alert(seq);
				location.href="/board/modifyForm.do?seq="+seq;
			});
			
			$("#newBtn").click(function(){
				location.href="/board/boardForm.do";
			});
			
			$("#listBtn").click(function(){
				location.href="/board/list.do";
			});
			
			
			$("#searchBtn").click(function(){
				var type= 	$("#searchType").val();
				var keyword= $("#searchKeyword").val();
				$.ajax({
					url : "search.do",
					type : "post",
					data : {searchType:type, searchKeyword:keyword},
					dataType : "json",
					success : function(ary){
						alert(ary);
						$("#tbody").empty();
						var str="";
						$.each(ary, function(idx, obj){
							str += "<tr>";
							str += "<td>"+obj.seq+"</td>";
							str += "<td><a href=''>"+obj.title+"</a></td>";
							str += "<td>"+obj.writer+"</td>";
							str += "<td>"+obj.regdate+"</td>";
							str += "<td><span class='badge bg-red'>"+obj.viewcnt +"</span></td>";
							str += "</tr>";
						});
						$("#tbody").append(str);
						
						
					}
				});
			});
		});
	
	</script>

<%@include file="../include/footer.jsp"%>
