<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <footer class="main-footer">
        <div class="pull-right hidden-xs">
          <b>Version</b> 2.0
        </div>
        <strong>Copyright &copy; 2014-2015 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights reserved.
      </footer>
      
      <!-- Control Sidebar -->      
      <aside class="control-sidebar control-sidebar-dark">                
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
          <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
          
          <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
          <!-- Home tab content -->
          <div class="tab-pane" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">Recent Activity</h3>
            <ul class='control-sidebar-menu'>
              <li>
                <a href='javascript::;'>
                  <i class="menu-icon fa fa-birthday-cake bg-red"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
                    <p>Will be 23 on April 24th</p>
                  </div>
                </a>
              </li>
              <li>
                <a href='javascript::;'>
                  <i class="menu-icon fa fa-user bg-yellow"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>
                    <p>New phone +1(800)555-1234</p>
                  </div>
                </a>
              </li>
              <li>
                <a href='javascript::;'>
                  <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>
                    <p>nora@example.com</p>
                  </div>
                </a>
              </li>
              <li>
                <a href='javascript::;'>
                  <i class="menu-icon fa fa-file-code-o bg-green"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>
                    <p>Execution time 5 seconds</p>
                  </div>
                </a>
              </li>
            </ul><!-- /.control-sidebar-menu -->

            <h3 class="control-sidebar-heading">Tasks Progress</h3> 
            <ul class='control-sidebar-menu'>
              <li>
                <a href='javascript::;'>               
                  <h4 class="control-sidebar-subheading">
                    Custom Template Design
                    <span class="label label-danger pull-right">70%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                  </div>                                    
                </a>
              </li> 
              <li>
                <a href='javascript::;'>               
                  <h4 class="control-sidebar-subheading">
                    Update Resume
                    <span class="label label-success pull-right">95%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                  </div>                                    
                </a>
              </li> 
              <li>
                <a href='javascript::;'>               
                  <h4 class="control-sidebar-subheading">
                    Laravel Integration
                    <span class="label label-waring pull-right">50%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                  </div>                                    
                </a>
              </li> 
              <li>
                <a href='javascript::;'>               
                  <h4 class="control-sidebar-subheading">
                    Back End Framework
                    <span class="label label-primary pull-right">68%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                  </div>                                    
                </a>
              </li>               
            </ul><!-- /.control-sidebar-menu -->         

          </div><!-- /.tab-pane -->
          <!-- Stats tab content -->
          <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div><!-- /.tab-pane -->
          <!-- Settings tab content -->
          <div class="tab-pane" id="control-sidebar-settings-tab">            
            <form method="post">
              <h3 class="control-sidebar-heading">General Settings</h3>
              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Report panel usage
                  <input type="checkbox" class="pull-right" checked />
                </label>
                <p>
                  Some information about this general settings option
                </p>
              </div><!-- /.form-group -->

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Allow mail redirect
                  <input type="checkbox" class="pull-right" checked />
                </label>
                <p>
                  Other sets of options are available
                </p>
              </div><!-- /.form-group -->

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Expose author name in posts
                  <input type="checkbox" class="pull-right" checked />
                </label>
                <p>
                  Allow the user to show his name in blog posts
                </p>
              </div><!-- /.form-group -->

              <h3 class="control-sidebar-heading">Chat Settings</h3>

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Show me as online
                  <input type="checkbox" class="pull-right" checked />
                </label>                
              </div><!-- /.form-group -->

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Turn off notifications
                  <input type="checkbox" class="pull-right" />
                </label>                
              </div><!-- /.form-group -->

              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Delete chat history
                  <a href="javascript::;" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                </label>                
              </div><!-- /.form-group -->
            </form>
          </div><!-- /.tab-pane -->
        </div>
      </aside><!-- /.control-sidebar -->
      <!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
      <div class='control-sidebar-bg'></div>
    </div><!-- ./wrapper -->


	<!--영화 상세정보 및 평점 입력 Modal -->
	<div class="modal fade" id="contentmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<div id="movieNm">
					<h1 name="movieNm">영화 이름</h1>
				</div>
				
			</div>
			<div class="modal-body">

					<input type="hidden" name="writer" id="writer"/>
					
					<div class="form-group">
						<label for="Name" class="col-xs-2 col-lg-2 control-label">포스터</label>
						<div class="col-xs-10 col-lg-10" id="poster">
							<img alt="제공되는 사진이 없습니다.미안" id="post_img"  width="200" height="300" >
						</div>
					</div>
					
					<form action="/rate/rateInsert.bt">
						<div class="form-group">
							<label for="Name" class="col-xs-2 col-lg-2 control-label">개봉일</label>
							<div class="col-xs-10 col-lg-10">
								<input class="form-control" id="openDt" readonly="readonly">
								<div id="openYear">
								</div>
							</div>
						</div>
	
	
						<div class="form-group">
							<label for="Name" class="col-xs-2 col-lg-2 control-label">감독</label>
							<div class="col-xs-10 col-lg-10" id="directors">
								<input  name="moviedirector" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label for="Name" class="col-xs-2 col-lg-2 control-label">배우</label>
							<div class="col-xs-10 col-lg-10" id="actors">
								<input  name="actors" readonly="readonly">
							</div>
						</div>
						
						<div class="form-group">
							
								<input type="hidden" value="${loginUser.userid}" name="userid">
								<input type="hidden" id="hiddenMovieName" name="moviename">
								<label for="Name" class="col-xs-2 col-lg-2 control-label">평점 입력</label>
								<div class="col-xs-10 col-lg-10" >
									
									<select id="rate" name="movierate">
										<option>선택하세요</option>
										<option>0.0</option>
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
									<button type="submit" >저장</button>
								</div>
						</div>
					</form>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			</div>
			
		</div> <!-- 모달 콘텐츠 -->
	  </div> <!-- 모달 다이얼로그 -->
	</div> <!-- 모달 전체 윈도우 -->
	
	
	
	<script type="text/javascript">
	var image;
	var director;
	
	var actor;
	function contentMovieModal(movieNm,movieNmEn,openDt,repNationNm,directors,repGenreNm,prdtYear){

		$.ajax({
			url		: "/movie/getPicture.bt",
			type	: "post",
			data	: {movieName : movieNm},
			dataType : "json",
			success : function(ary){
					var i=0;
					var image;
					var actor;
					var openYear;
					var director;
					
					var patternDirector = new RegExp(directors);
					var patternNmEn = new RegExp(movieNmEn);
					
					image = ary.items[0].image;
					actor = ary.items[0].actor;
					openYear = ary.items[0].pubDate;
					director = ary.items[0].director;
					
					$.each(ary.items, function(ids, obj){
						
					
						if(patternDirector.test(obj.director)){
							image = obj.image;
							actor = obj.actor;
							openYear = obj.pubDate;
							director = obj.director;
							
						}
						
						
					});

					
					
					$("#poster").empty();
					$("#poster").append("<img alt='영화 포스터' src="+image+" height='300'>");
					$("#directors").empty();
					$("#directors").append("<input value='"+director+"' name='moviedirector' readonly='readonly'>");
					$("#actors").empty();
					$("#actors").append("<input value='"+actor+"' name='movieactor' readonly='readonly'>");
					$("#openYear").empty();
					$("#openYear").append("<input type='hidden' name='moviedate' value='"+openYear+"' readonly='readonly'>");
			}
		})
	
		$('#movieNm').empty();
		$('#movieNm').append("<h1>"+movieNm+"</h1>");
		
		
		
		$('#contentmodal').modal();
		$('#hiddenMovieName').val(movieNm);
		
		$('#movieNmEn').val(movieNmEn);
		$('#openDt').val(openDt);
		$('#openYear').val(openYear);
	}

	</script>

    <!-- Bootstrap 3.3.2 JS -->
    <script src="/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='/resources/plugins/fastclick/fastclick.min.js'></script>
    <!-- AdminLTE App -->
    <script src="/resources/dist/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="/resources/dist/js/demo.js" type="text/javascript"></script>
    
    
  </body>
</html>