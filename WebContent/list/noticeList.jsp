<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>공지사항</h2>
      <s:iterator value="list" status="stat">

      <ul>
      	<li><s:property value="noti_no" /> <s:property value="noti_date" /> <s:property value="noti_subject" /> <s:property value="noti_content" /></li>
      </ul>
           
      </s:iterator>

<s:property value="pagingHtml" escape="false" />