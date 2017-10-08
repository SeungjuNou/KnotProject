<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<ul>
		<h2>자주묻는게시판</h2>
	</ul>
		

		<s:if test="resultClass == NULL">   
		<form action="admin_faqWrite.action" method="post" enctype="multipart/form-data"> </s:if>

		<s:hidden name="userReq" value="faqWrite" />
	<ul>
			<li>제목 : <s:textfield name="name" theme="simple" value="%{resultClass.name}" /></li>
			<li>내용 : <s:textarea name="content" theme="simple" value="%{resultClass.name}" /></li>

	</ul>
		


	 
			<input name="submit" type="submit" value="작성완료" class="inputb">

		</form>

			