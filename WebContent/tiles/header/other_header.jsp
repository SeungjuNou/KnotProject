<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


		<div id="top">
			<div id="top_inner">
			
				<div id="top_logo">
					<a href="#">
						<img src="image/icon/logo.png">
					</a>
				</div> 
 
				<fieldset id="top_find">
					<form action="#">
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
								<a href="myPage.action">
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
								<a href="myPage.action">
									<li>마이 페이지 </li>
								</a>
								<a href="logout.action">
									<li>재능 판매 등록</li>
								</a>
								<a href="myPage_itemForm.action">
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
						<li><a href="#">Home</a>
							<ul>
								<li><a href="#">Lorem ipsum</a></li>
								<li><a href="#">Aenean massa</a></li>
								<li><a href="#">Nullam dictum felis</a></li>
								<li><a href="#">Aenean leo ligula</a></li>
								<li><a href="#">Curabitur ullamcorper</a></li>
								<li><a href="#">Item - Level 2</a>
									<ul>
										<li><a href="#">Sub item 1</a></li>
										<li><a href="#">Sub item 2</a></li>
										<li><a href="#">Item - Level 3</a></li>	<!-- Level 3 END -->					
									</ul>
								</li>	<!-- Level 2 END -->					
							</ul> 
						</li> <!-- Level 1 END -->
						<!-- END Home Item -->
						
						<li><a href="#">Portfolio</a>
							<ul>
								<li><a href="#">Maecenas tempus</a></li>
								<li><a href="#">Vestibulum ante ipsum</a></li>
								<li><a href="#">Praesent adipiscing</a></li>
								<li><a href="#">Curabitur ligula</a></li>
								<li><a href="#">Vestibulum</a>>
								</li>						
							</ul>
						</li>
						<!-- END Portfolio Item -->
						
						<li><a href="#">Blog</a>
							<ul>
								<li><a href="#">Fusce id purus</a></li>
								<li><a href="#">Aenean viverra</a></li>
								<li><a href="#">Phasellus magna</a></li>
								<li><a href="#">Morbi ac felis</a></li>
							</ul>
						</li>
						<!-- END Blog Item -->
						
						<li><a href="#">Services</a></li>
						<li><a href="#">About Us</a></li>
						<li><a href="#">Contact Us</a></li>
					</ul><!-- #nav END-->
					

					 
				</div><!-- #menu END-->
			</div><!-- #navigation END-->
		</div><!-- #menu_div END-->
		<!--=====================================
				/Top Fixed Navigation Menu END 
		======================================-->