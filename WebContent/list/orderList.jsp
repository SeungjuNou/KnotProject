<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>ORDER 리스트</h2>

    <s:iterator value="list" status="stat">

    <s:url id="viewURL" action="admin_orderModifyForm">

        <s:param name="re_item_no">
            <s:property value="re_item_no" />
        </s:param>

        <s:param name="currentPage">
            <s:property value="currentPage" />
        </s:param>

        <s:param name="userReq"> order </s:param>

    </s:url>

       
    <ul>
        <li>
            <s:a href="%{viewURL}">
            	<s:property value="re_item_no" />
            </s:a>
           		<s:property value="re_item" />
      			<s:property value="re_mem_id" />
            	<s:property value="re_sal_id" />
            	<s:property value="re_price" />
            	<s:property value="re_cat_no" />
            	<s:property value="order_date" />
            	<s:property value="order_dtl" />
        </li>
    </ul>

    <s:property value="pagingHtml" escape="false" />
           
    
    </s:iterator>