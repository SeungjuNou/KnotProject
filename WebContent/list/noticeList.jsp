<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>공지사항</h2>

      <s:iterator value="list" status="stat">
		<s:url id="viewURL" action="notice_view">
			<s:param name="no"><s:property value="no" /></s:param>
			<s:param name="currentPage"><s:property value="currentPage" /></s:param>
		</s:url>
      <ul>
      	<li><s:property value="no" /> <s:property value="todate" /><s:a href="%{viewURL}"><s:property value="noti_subject" /></s:a> <s:property value="noti_content" /></li>
      </ul>
           
      </s:iterator>

<s:property value="pagingHtml" escape="false" />

<input type="button" value="글쓰기" class="inputb" onClick="javascript:location.href='admin_noticeWrite.action?&currentPage=<s:property value="currentPage" />';">