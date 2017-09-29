<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 상세보기</title>
</head>
<body>
	<h2>공지사항 상세보기</h2>

	<ul>
		<li>번호<s:property value="resultClass.noti_no" /></li>
		<li>등록날짜<s:property value="resultClass.noti_date" /></li>
		<li>제목<s:property value="resultClass.noti_subject" /></li>
		<li>내용<s:property value="resultClass.noti_content" /></li>
	</ul>

	<s:url id="modifyURL" action="ModifyForm">
		<s:param name="noti_no">
			<s:property value="noti_no" />
		</s:param>
	</s:url>

	<input type="button" name="modify" value="수정" class="inputb"
		onclick="javascript:location.href='noticeModifyForm.action?noti_no=<s:property value="resultClass.noti_no" />&currentPage=<s:property value="currentPage" />'">