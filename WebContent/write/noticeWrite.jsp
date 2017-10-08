<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>공지사항 작성</h2>

<s:if test="resultClass == NULL">
	<form action="admin_noticeWrite.action" method="post">
</s:if>
<s:hidden name="userReq" value="noticeWrite" />



<ul>
	<li>제목<s:textarea name="name" theme="simple" value="%{resultClass.name}"/></li>
	<li>내용<s:textarea name="content" theme="simple" value="%{resultClass.content}"/></li>
	
</ul>


<input name="submit" type="submit" value="작성완료" class="inputb"/>
<input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='admin_notice.action?currentPage=<s:property value="currentPage" />'">