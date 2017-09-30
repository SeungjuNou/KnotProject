<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



	<ul>
		<title>자주묻는게시판</title>
	</ul>

	<ul>
		<h2>자주묻는게시판</h2>
	</ul>
		

		<s:if test="resultClass == NULL">   
		<form action="faqWriteAction.action" method="post" enctype="multipart/form-data"> </s:if>

	<ul>
			<li>번호 : <s:property value="resultClass.faq_no" /></li>
			<li>제목 : <s:textfield name="faq_subject" theme="simple" value="%{resultClass.faq_subject}" /></li>
			<li>내용 : <s:textarea name="faq_content" theme="simple" value="%{resultClass.faq_content}" /></li>

	</ul>
		

	

	  

	
			<input name="submit" type="submit" value="작성완료" class="inputb">

			