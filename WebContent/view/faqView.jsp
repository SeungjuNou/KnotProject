<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul>
		<li>
			<h2>FAQ</h2>
		</li>
      
      	
      	<li>	NAME		: <s:property value="resultClass.name" /> 	 </li>
      	<li>	CONTENT	</li>
      	<li>  <s:property value="resultClass.content" /> </li>
</ul>

<c:if test="${sessionScope.mem_lev eq 3}">
		<input type="button" name="modify" value="수정" class="inputb"
				onclick="javascript:location.href='admin_faqModifyForm.action?no=<s:property value="resultClass.no" />&currentPage=<s:property value="currentPage" />&userReq=faq';">
		<input type="button" name="list" value="삭제" class="inputb"
				onclick="javascript:location.href='admin_faqDelete.action?no=<s:property value="resultClass.no" />&currentPage=<s:property value="currentPage" />&userReq=faq';">
</c:if>
		<input type="button" name="list" value="목록" class="inputb"
				onclick="javascript:location.href='admin_faq.action?currentPage=<s:property value="currentPage" />&userReq=faq';">
		