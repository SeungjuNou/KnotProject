<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


		<div id="top">
			<div id="top_inner">
			
				<div id="top_logo">
					<a href="main.action">
						<img src="image/icon/logo.png">
					</a>
				</div> 
 
				<fieldset id="top_find">
					<form action="other_find_item.action">
						<button onclick="other.action" class="find_button">
							<img src="image/icon/find2.png">
						</button>
						<input type="text" name="find" class="top_text" placeholder="필요한 재능을 찾아보세요" />
					</form>
				</fieldset>

				<div id="top_member">
					<ul id="nav2">
						<li>
							<a href="#">
								<img src="image/icon/member.png">
							</a>

							<c:if test="${sessionScope.mem_lev eq 3}">
								<ul>
									<a href=""><li>
										${sessionScope.mem_name} 님 
									</li>
									</a>
								<a href="admin_member.action">
									<li>관리자 페이지</li>
								</a>
								<a href="logout.action">
									<li>로그아웃</li>
								</a>
								</ul>
							</c:if>

							<c:if test="${sessionScope.mem_lev eq 2}">
								<ul>
									<li>
										${sessionScope.mem_name} 님 
									</li>
								<a href="myPage_notice.action">
									<li>마이 페이지 </li>
								</a>
								<a href="logout.action">
									<li>로그아웃</li>
								</a>
								</ul>
							</c:if>

							<c:if test="${sessionScope.mem_lev eq 1}">
								<ul>
									<li>
										${sessionScope.mem_name} 님 
									</li>
								<a href="myPage_notice.action">
									<li>마이 페이지 </li>
								</a>
								<a href="myPage_itemForm.action">
									<li>재능 판매 등록</li>
								</a>
								<a href="logout.action">
									<li>로그아웃</li>
								</a>
								</ul>
							</c:if>

							<c:if test="${empty sessionScope.mem_lev}">
								<ul>
								<a href="loginForm.action">
									<li>로그인</li>
								</a>
								<a href="memberForm.action">
									<li>회원가입</li>
								</a>
								</ul>
							</c:if>
						
						</li>
					</ul>
				</div>
				
			</div>
		</div>
	
		<!--=====================================
				Top Fixed Navigation Menu BEGIN
		======================================-->
		<div id="menu_div">
			<div id="navigation">
				<div id="menu">
					<ul id="nav"> 
						<li>
							<a href="main.action">홈으로</a>
						</li> 

						<li>
							<a href="#">분야별</a>
							<ul>
								<s:iterator value="menulist" status="stat">
									<s:url id="cat_item" action="other_cat_item">
        	
							        	 <s:param name="cat_no">
							            	<s:property value="no" />
							        	</s:param>

							        	<s:param name="userReq"> item </s:param>
						    	
						    		</s:url>

									<li>
										<s:a href="%{cat_item}">
											<s:property value="name" />
										</s:a>
									</li>
								</s:iterator> 
							</ul>
						</li>
						<!-- END Portfolio Item -->
						
						<li>
							<a href="#">지역별</a>
							<ul>
								<s:iterator value="menulist2" status="stat">
									<s:url id="area_cat_item" action="other_area_item">
        	
							        	 <s:param name="area_cat_no">
							            	<s:property value="no" />
							        	</s:param>

							        	<s:param name="userReq"> item </s:param>
						    	
						    		</s:url>

									<li>
										<s:a href="%{area_cat_item}">
											<s:property value="name" />
										</s:a>
									</li>
								</s:iterator>
							</ul>
						</li>
						<!-- END Blog Item -->

						<li>
							<a href="myPage_faq.action">자주묻는 질문</a>
						</li> 
						
					</ul><!-- #nav END-->
					

					 
				</div><!-- #menu END-->
			</div><!-- #navigation END-->
		</div><!-- #menu_div END-->
		<!--=====================================
				/Top Fixed Navigation Menu END 
		======================================-->

		<s:url id="member_id" action="myPage_qna.action">
        	
        	<s:param name="currentPage">
            	<s:property value="currentPage" />
        	</s:param>

        	<s:param name="mem_id">
            	${sessionScope.mem_id}
        	</s:param>
    	
    	</s:url>

    	<s:url id="re_sal_id" action="myPgae_sal_order.action">
        	
        	<s:param name="currentPage">
            	<s:property value="currentPage" />
        	</s:param>

        	<s:param name="mem_id">
            	${sessionScope.mem_id}
        	</s:param>
    	
    	</s:url>

    	<s:url id="re_mem_name" action="myPgae_user_order.action">
        	
        	<s:param name="currentPage">
            	<s:property value="currentPage" />
        	</s:param>

        	<s:param name="mem_name">
            	${sessionScope.mem_name}
        	</s:param>
    	
    	</s:url>

    	<s:url id="my_item" action="myPage_item.action">
        	
        	<s:param name="currentPage">
            	<s:property value="currentPage" />
        	</s:param>

        	<s:param name="mem_id">
            	${sessionScope.mem_id}
        	</s:param>
    	
    	</s:url>

    	<s:url id="memberFormgo" action="memberModify.action">
        	
        	<s:param name="currentPage">
            	<s:property value="currentPage" />
        	</s:param>

        	<s:param name="mem_id">
            	${sessionScope.mem_id}
        	</s:param>

        	<s:param name="userReq">
        	member
        	</s:param>
    	
    	</s:url>



		<div id="under_top">
			<div id="ut_inner">
				<ul>
					<li id="myPage_bu">
						<a href="#">
							MY Page
						</a>
					</li>
					<li>
						<s:a href="%{memberFormgo}">
							회원정보
						</s:a>
					</li>
					<li>

						<c:if test="${sessionScope.mem_lev eq 2}">
							<s:a href="%{re_sal_id}">
								예약내역
							</s:a>
						</c:if>

						<c:if test="${sessionScope.mem_lev eq 1}">
							<s:a href="%{re_mem_name}">
								예약내역
							</s:a>
						</c:if>

					</li>
					

					<li>
						<s:a href="%{member_id}">
							문의하기
						</s:a>
					</li>
					<li>
						<a href="myPage_notice.action">
							공지사항
						</a>
					</li>
					<li>
						
						<c:if test="${sessionScope.mem_lev eq 1}">
							<a href="#">
								자주묻는 질문
							</a> 
						</c:if>
						
						<c:if test="${sessionScope.mem_lev eq 2}">
							<s:a href="%{my_item}">
								판매상품
							</s:a>
						</c:if>

					</li>
					<li>
						<a href="#">
							회원탈퇴
						</a>
					</li>
				</ul>
			</div>
		</div>