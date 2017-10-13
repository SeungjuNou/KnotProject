<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="header">

		<div class="head_top">

			<ul>
				<li id="top_logo">
					<a href="main.action">
						<img src="image/icon/logo.png" width="166"  alt="logo"> 
					</a>
				</li>

				<li id="top_menu">
					<a href="#">
						<img src="image/icon/mobileMenu.png">
					</a>
				</li>

				<li id="top_member">
					<ul id="nav2">
						<li>
							<a href="#">
								<img src="image/icon/member.png">
							</a>

							<c:if test="${sessionScope.mem_lev eq 3}">
								<ul>
									<li>
										${sessionScope.mem_name} 님 
									</li>
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
				</li>
			</ul>
	
		</div>

		<div class="head_mid">
			<div class="mid_inner">
				<ul>
					<li>
						<form action="other_find_item.action" class="main_find">
							<p>숨은 인재들의 연결고리</p>
							<img src="image/icon/find.png" class="find_img">
							<input type="text" name="find" class="main_find_text" placeholder="Search...">
						</form>   
					</li>
				</ul>
			</div>
		</div>

		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<div id="cate">
							<span></span>
							<ul>
								<li id="left">
									<a class="arrow-left" href="#">
										<img src="image/icon/more.png">
									</a> 
								</li>

								<s:iterator value="menulist" status="stat">

								<s:url id="viewURL" action="other_cat_item">

							        <s:param name="cat_no">
							            <s:property value="no" />
							        </s:param>

							        <s:param name="userReq"> item </s:param>
						    	</s:url>


									<li id="cate_img">
										<s:a href="%{viewURL}">
											<img src="image/icon/need.png" width="150">
											<p><s:property value="name" /></p>	
										</s:a>
										
									</li>
								</s:iterator>

								<li id="right">
									<a class="arrow-right" href="#">
										<img src="image/icon/more.png"></a>
								</li>
							</ul>
							<span></span>
					</div>
				</div>

				<div class="swiper-slide">
					<div id="cate">
							<span></span>
							<ul>
								<li id="left">
									<a class="arrow-left" href="#">
										<img src="image/icon/more.png">
									</a> 
								</li>
								
								<s:iterator value="menulist2" status="stat">

								<s:url id="viewURL" action="other_cat_item">

							        <s:param name="cat_no">
							            <s:property value="no" />
							        </s:param>

							        <s:param name="userReq"> item </s:param>
						    	</s:url>


									<li id="cate_img">
										<s:a href="%{viewURL}">
											<img src="image/icon/need.png" width="150">
											<p><s:property value="name" /></p>	
										</s:a>
										
									</li>
								</s:iterator>

								<li id="right">
									<a class="arrow-right" href="#">
										<img src="image/icon/more.png"></a>
								</li>
							</ul>
							<span></span>
					</div>
				</div>

			<div class="pagination">
				
			</div>

		
			</div>
		
		</div>
	
	</div>



