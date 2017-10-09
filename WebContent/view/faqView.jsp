<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul>
		<li>
			<h2>FAQ</h2>
		</li>
      
      	<li>	NO			: <s:property value="resultClass.no" /> 	 </li>
      	<li>	NAME		: <s:property value="resultClass.name" /> 	 </li>
      	<li>	CONTENT		: <s:property value="resultClass.content" /> </li>
</ul>

		<input type="button" name="modify" value="수정" class="inputb"
				onclick="javascript:location.href='admin_faqModifyForm.action?no=<s:property value="resultClass.no" />&currentPage=<s:property value="currentPage" />&userReq=faq';">
		<input type="button" name="list" value="목록" class="inputb"
				onclick="javascript:location.href='admin_faq.action?currentPage=<s:property value="currentPage" />&userReq=faq';">
		<input type="button" name="list" value="삭제" class="inputb"
				onclick="javascript:location.href='admin_faqDelete.action?no=<s:property value="resultClass.no" />&currentPage=<s:property value="currentPage" />&userReq=faq';">