<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>공지사항</h2>

      <s:iterator value="list" status="stat">
		<s:url id="viewURL" action="notice_view">
			<s:param name="noti_no"><s:property value="noti_no" /></s:param>
			<s:param name="currentPage"><s:property value="currentPage" /></s:param>
		</s:url>
      <ul>
      	<li><s:property value="noti_no" /> <s:property value="noti_date" /><s:a href="%{viewURL}"><s:property value="noti_subject" /></s:a> <s:property value="noti_content" /></li>
      </ul>
           
      </s:iterator>

<s:property value="pagingHtml" escape="false" />

<input type="button" value="글쓰기" class="inputb" onClick="javascript:location.href='notice_write.action?&currentPage=<s:property value="currentPage" />';">