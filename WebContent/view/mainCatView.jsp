<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<h2>카테고리</h2>
	<ul>
		<li>번호<s:property value="resultClass.cat_no" /></li>
		<li>이름<s:property value="resultClass.cat_name" /></li>
		<li>이미지<s:url id="download" action="mainCatFileDownloadAction">
				<s:param name="cat_no">
					<s:property value="cat_no" />
				</s:param>
			</s:url>
			
			<s:a href="%{download}">
				<s:property value="resultClass.cat_img" />
			</s:a>
			
			<s:url id="modifyURL" action="mainCat_modify">			
				<s:param name="cat_no">
					<s:property value="cat_no" />
				</s:param>
			</s:url>
			
			<s:url id="deleteURL" action="mainCatDeleteAction">
				<s:param name="cat_no">
					<s:property value="cat_no" />
				</s:param>
			</s:url>
		</ul>
		
	<input type="button" name="modify" value="수정" class="inputb"
		onclick="javascript:location.href='mainCat_modify.action?cat_no=<s:property value="resultClass.cat_no" />&currentPage=<s:property value="currentPage" />'">
	<input type="button" name="list" value="목록" class="inputb"
		onclick="javascript:location.href='mainCat_list.action?currentPage=<s:property value="currentPage" />'">
	<input type="button" name="delete" value="삭제" class="inputb"
		onclick="javascript:location.href='catDeleteAction.action?cat_no=<s:property value="resultClass.cat_no" />&currentPage=<s:property value="currentPage" />'">

