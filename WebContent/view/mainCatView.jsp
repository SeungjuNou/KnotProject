<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<h2>카테고리</h2>
	<ul>
		<li>번호<s:property value="resultClass.no" /></li>
		<li>이름<s:property value="resultClass.name" /></li>
		<li>이미지 <s:property value="resultClass.img" /> </li>
			
	</ul>
	
	<s:url id="modifyURL" action="admin_mainCatModifyForm">			
				<s:param name="cat_no">
					<s:property value="cat_no" />
				</s:param>
	</s:url>
				
	<input type="button" name="modify" value="수정" class="inputb"
		onclick="javascript:location.href='admin_mainCatModifyForm.action?no=<s:property value="resultClass.no" />&currentPage=<s:property value="currentPage" />&userReq=adminMainCatView'">
	<input type="button" name="list" value="목록" class="inputb"
		onclick="javascript:location.href='admin_mainCat.action?currentPage=<s:property value="currentPage" />'">

