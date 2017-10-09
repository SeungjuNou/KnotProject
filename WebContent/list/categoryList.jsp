<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>메인카테고리</h2>

    <s:iterator value="list" status="stat">

    <s:url id="viewURL" action="admin_mainCatView">

        <s:param name="no">
            <s:property value="no" />
        </s:param>

        <s:param name="currentPage">
            <s:property value="currentPage" />
        </s:param>

        <s:param name="userReq"> mainCat </s:param>

    </s:url>

       
    <ul>
        <li>
            <s:property value="no" />
            <s:property value="name" />
            <s:a href="%{viewURL}">
                <s:property value="img" />
            </s:a>
        </li>
    </ul>
           
    
    </s:iterator>
    
<input type="button" value="글쓰기" class="inputb" onClick="javascript:location.href='admin_mainCatForm.action?&currentPage=<s:property value="currentPage" />';">