<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>FAQ 리스트</h2>

	<ul>
		<li>번호 이름</li>
	</ul>
    <s:iterator value="list" status="stat">

    <s:url id="viewURL" action="admin_faqModifyForm">

        <s:param name="no">
            <s:property value="no" />
        </s:param>

        <s:param name="currentPage">
            <s:property value="currentPage" />
        </s:param>

        <s:param name="userReq"> faq </s:param>

    </s:url>

       
    <ul>
        <li>
            <s:property value="no" />
          	<s:a href="%{viewURL}">
                <s:property value="name" />
            </s:a>
        </li>
    </ul>
           
    
    </s:iterator>