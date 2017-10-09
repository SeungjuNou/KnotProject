<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>QnA</h2>

    <s:iterator value="list" status="stat">

    <s:url id="viewURL" action="admin_qnaView">

        <s:param name="no">
            <s:property value="no" />
        </s:param>

        <s:param name="currentPage">
            <s:property value="currentPage" />
        </s:param>

        <s:param name="userReq"> qna </s:param>

    </s:url>

       
    <ul>
        <li>
            <s:property value="no" />
            <s:property value="mem_id" />
            <s:a href="%{viewURL}">
                <s:property value="mem_name" />
            </s:a>
            <s:property value="name" />
            <s:property value="todate" />
        </li>
    </ul>
           
    
    </s:iterator>
