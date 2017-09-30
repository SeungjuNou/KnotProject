<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>공지사항 작성</h2>

<s:if test="resultClass == NULL">
	<form action="notice_writeAction.action" method="post">
</s:if>

<s:else>
	<form action="noticeModifyAction.action" method="post">
	<s:hidden name="noti_no" value="%{resultClass.noti_no}"/>
	<s:hidden name="currentPage" value="%{currentPage}"/>
</s:else>

<ul>
	<li>제목<s:textfield name="noti_subject" theme="simple" value="%{resultClass.noti_subject}"/></li>
	<li>내용<s:textarea name="noti_content" theme="simple" value="%{resultClass.noti_content}"/></li>
</ul>


<input name="submit" type="submit" value="작성완료" class="inputb"/>
<input name="list" type="button" value="목록" class="inputb" onClick="javascript:location.href='notice_list.action?currentPage=<s:property value="currentPage" />'">