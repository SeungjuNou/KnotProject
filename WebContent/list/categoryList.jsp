<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>메인카테고리</h2>

      <s:iterator value="list" status="stat">
		<s:url id="viewURL" action="mainCat_view">
			<s:param name="cat_no"><s:property value="cat_no" /></s:param>
			<s:param name="currentPage"><s:property value="currentPage" /></s:param>
		</s:url>
      <ul>
      	<li><s:property value="cat_no" /> <s:property value="cat_name" /><s:a href="%{viewURL}"><s:property value="cat_img" /></s:a></li>
      </ul>
           
      </s:iterator>

<s:property value="pagingHtml" escape="false" />

<input type="button" value="글쓰기" class="inputb" onClick="javascript:location.href='mainCat_write.action?&currentPage=<s:property value="currentPage" />';">